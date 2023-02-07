package com.inti.nosily_coach.domain.BodyRecord.service;

import com.inti.nosily_coach.auth.repository.MemberRepository;
import com.inti.nosily_coach.domain.BodyRecord.model.BodyRecord;
import com.inti.nosily_coach.domain.BodyRecord.model.dto.*;
import com.inti.nosily_coach.domain.BodyRecord.repository.BodyRecordRepository;
import com.inti.nosily_coach.domain.Member.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BodyRecordServiceImpl implements BodyRecordService {
    private final BodyRecordRepository bodyRecordRepository;
    private final MemberRepository memberRepository;

    // # 몸기록 전체 조회
    @Override
    @Transactional
    public List<GetBodyRecordsResponse> getAllBodyRecords(Long memberId, Pageable pageable) {
        return bodyRecordRepository.findAllByMemberId(memberId, pageable).stream()
                .map(record -> GetBodyRecordsResponse.of(record.getId(), record.getHeight(),
                                record.getWeight(), record.getBodyFatPercentage(), record.getMuscle(),
                                record.getCreatedAt().format(DateTimeFormatter.ofPattern("yy년 MM월 dd일 E요일"))))
                .collect(Collectors.toList());
    }

    // # 몸기록 날짜로 조회 (하루에 하나만 작성 가능하기 때문에 list X)
    @Override
    @Transactional
    public GetBodyRecordsResponse getBodyRecordByDate(Long memberId, LocalDate localDate) {
        BodyRecord record = bodyRecordRepository.findByDate(memberId, localDate);
        return GetBodyRecordsResponse.of(record.getId(), record.getHeight(), record.getWeight(),
                record.getBodyFatPercentage(), record.getMuscle(), record.getCreatedAt().format(DateTimeFormatter.ofPattern("yy년 MM월 dd일 E요일")));
    }

    // # 몸기록 작성
    @Override
    @Transactional
    public CreateBodyRecordResponse createBodyRecord(Long memberId, CreateBodyRecordRequest request) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("존재하지 않은 회원입니다."));
        if (bodyRecordRepository.recordNumOfDate(memberId, LocalDate.now()) > 0) {
            throw new RuntimeException("이미 오늘 작성된 몸기록이 있습니다.");
        }
        BodyRecord bodyRecord = bodyRecordRepository.save(request.toEntity(member, request.getHeight(),
                request.getWeight(), request.getBodyFatPercentage(), request.getMuscle()));

        return CreateBodyRecordResponse.of(bodyRecord.getId());
    }

    // # 몸기록 수정
    @Override
    @Transactional
    public UpdateBodyRecordResponse updateBodyRecord(Long memberId, Long recordId, UpdateBodyRecordRequest request) {
        BodyRecord bodyRecord = bodyRecordRepository.findByRecordId(memberId, recordId);
        bodyRecord.update(request.getHeight(), request.getWeight(), request.getBodyFatPercentage(), request.getMuscle());

        return UpdateBodyRecordResponse.of(bodyRecord.getId());
    }

    // # 몸기록 삭제
    @Override
    @Transactional
    public DeleteBodyRecordResponse deleteBodyRecord(Long memberId, Long recordId) {
        BodyRecord bodyRecord = bodyRecordRepository.findByRecordId(memberId, recordId);
        DeleteBodyRecordResponse deleteBodyRecordResponse = DeleteBodyRecordResponse.of(bodyRecord.getId());

        bodyRecordRepository.delete(bodyRecord);
        return deleteBodyRecordResponse;
    }
}