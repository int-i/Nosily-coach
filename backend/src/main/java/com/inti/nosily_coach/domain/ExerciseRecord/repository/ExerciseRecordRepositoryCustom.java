package com.inti.nosily_coach.domain.ExerciseRecord.repository;

import com.inti.nosily_coach.domain.ExerciseRecord.model.ExerciseRecord;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface ExerciseRecordRepositoryCustom {
    ExerciseRecord findExerciseRecordByRecordId(Long memberId, Long recordId);
    Long getNumOfTodayRecord(Long memberId, LocalDate date);
    List<ExerciseRecord> findAllWithPaging(Long memberId, Pageable pageable);
    ExerciseRecord findByDate(Long memberId, LocalDate localDate);
}
