package com.inti.nosily_coach.domain.ExerciseRecord.service;

import com.inti.nosily_coach.domain.ExerciseRecord.model.dto.CreateExerciseRecordRequest;
import com.inti.nosily_coach.domain.ExerciseRecord.model.dto.CreateExerciseRecordResponse;
import com.inti.nosily_coach.domain.ExerciseRecord.model.dto.GetExerciseRecordResponse;
import com.inti.nosily_coach.domain.ExerciseRecord.model.dto.UpdateExerciseRecordResponse;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface ExerciseRecordService {
    CreateExerciseRecordResponse createExerciseRecord(Long memberId, CreateExerciseRecordRequest request);
    UpdateExerciseRecordResponse updateExerciseRecord(Long memberId, Long recordId, String memo);
    List<GetExerciseRecordResponse> getAllExerciseRecords(Long memberId, Pageable pageable);
    GetExerciseRecordResponse getExerciseRecordByDate(Long memberId, LocalDate localDate);
}
