package com.inti.nosily_coach.domain.DietRecord.Service;

import com.inti.nosily_coach.auth.repository.MemberRepository;
import com.inti.nosily_coach.domain.DietRecord.DTO.DTODietRecord;
import com.inti.nosily_coach.domain.DietRecord.DTO.ModifyDietRecord;
import com.inti.nosily_coach.domain.DietRecord.DTO.ResponseDietRecord;
import com.inti.nosily_coach.domain.DietRecord.DTO.RequestDietRecord;
import com.inti.nosily_coach.domain.DietRecord.model.DietRecord;
import com.inti.nosily_coach.domain.DietRecord.repository.DietRecordRepository;
import com.inti.nosily_coach.domain.Member.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class DietRecordServiceImpl implements DietRecordService {
    private final DietRecordRepository dietRecordRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public List<DTODietRecord> viewDietRecord(Long memberId, Pageable pageable) { // 식단기록 조회하는 메서드
        return dietRecordRepository.pageDietRecord(memberId, pageable)
                .stream().map(dietRecord -> DTODietRecord.of(dietRecord.getId(), dietRecord.getCreatedAt().format(DateTimeFormatter.ofPattern("yy년 MM월 dd일 E요일")), dietRecord.getMemo(), dietRecord.getEats())).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ResponseDietRecord createDietRecord(Long memberId, RequestDietRecord requestDietRecord) { // 식단기록 추가하는 메서드
        Member member = memberRepository.findById(memberId).orElseThrow(()->new RuntimeException("존재하지 않은 회원입니다."));
        DietRecord dietRecord = dietRecordRepository.save(requestDietRecord.ToEntity(member, requestDietRecord.getMemo()));
        return ResponseDietRecord.of(dietRecord.getId());
    }

    @Override
    @Transactional
    public ModifyDietRecord modifyDietRecord(Long memberId, Long DietRecordId, String memo) { // 식단기록 수정하는 메서드
        DietRecord dietRecord = dietRecordRepository.findDietRecordByDietRecordId(memberId, DietRecordId);
        dietRecord.updateMemo(memo);
        return ModifyDietRecord.of(DietRecordId);
    }

}
