package com.inti.nosily_coach.domain.ExerciseRecord.service;

import com.inti.nosily_coach.auth.repository.MemberRepository;
import com.inti.nosily_coach.domain.ExerciseRecord.model.ExerciseRecord;
import com.inti.nosily_coach.domain.ExerciseRecord.model.dto.CreateExerciseRecordRequest;
import com.inti.nosily_coach.domain.ExerciseRecord.model.dto.CreateExerciseRecordResponse;
import com.inti.nosily_coach.domain.ExerciseRecord.model.dto.GetExerciseRecordResponse;
import com.inti.nosily_coach.domain.ExerciseRecord.model.dto.UpdateExerciseRecordResponse;
import com.inti.nosily_coach.domain.ExerciseRecord.repository.ExerciseRecordRepository;
import com.inti.nosily_coach.domain.Member.model.Member;
import com.inti.nosily_coach.domain.SelectedExercise.service.SelectedExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExerciseRecordServiceImpl implements ExerciseRecordService {
    private final ExerciseRecordRepository exerciseRecordRepository;
    private final MemberRepository memberRepository;
    private final SelectedExerciseService selectedExerciseService;

    // # 운동기록 작성
    @Override
    @Transactional
    public CreateExerciseRecordResponse createExerciseRecord(Long memberId, CreateExerciseRecordRequest request) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("존재하지 않은 회원입니다."));
        if (exerciseRecordRepository.getNumOfTodayRecord(memberId, LocalDate.now()) > 0) {
            throw new RuntimeException("이미 오늘 작성된 운동 기록이 있습니다.");
        }
        ExerciseRecord exerciseRecord = exerciseRecordRepository.save(request.toEntity(member, request.getMemo()));

        return CreateExerciseRecordResponse.of(exerciseRecord.getId());
    }

    // # 운동기록 수정
    @Override
    @Transactional
    public UpdateExerciseRecordResponse updateExerciseRecord(Long memberId, Long recordId, String memo) {
        ExerciseRecord exerciseRecord = exerciseRecordRepository.findExerciseRecordByRecordId(memberId, recordId);
        exerciseRecord.update(memo);

        return UpdateExerciseRecordResponse.of(recordId);
    }

    // # 운동기록 전체 조회
    @Override
    @Transactional(readOnly = true)
    public List<GetExerciseRecordResponse> getAllExerciseRecords(Long memberId, Pageable pageable) {
        return exerciseRecordRepository.findAllWithPaging(memberId, pageable)
                .stream().map(record -> GetExerciseRecordResponse.of(record.getId(),
                        selectedExerciseService.getSelectedExercise(record.getSelectedExercises()),
                        record.getMemo(), record.getCreatedAt().format(DateTimeFormatter.ofPattern("MM월 dd일 E요일")))
                ).collect(Collectors.toList());
    }

    // # 운동기록 날짜별 조회 (단일 조회)
    @Override
    @Transactional(readOnly = true)
    public GetExerciseRecordResponse getExerciseRecordByDate(Long memberId, LocalDate localDate) {
        ExerciseRecord exerciseRecord = exerciseRecordRepository.findByDate(memberId, localDate);
        return GetExerciseRecordResponse.of(exerciseRecord.getId(),
                selectedExerciseService.getSelectedExercise(exerciseRecord.getSelectedExercises()),
                exerciseRecord.getMemo(), exerciseRecord.getCreatedAt().format(DateTimeFormatter.ofPattern("MM월 dd일 E요일")));
    }
}
