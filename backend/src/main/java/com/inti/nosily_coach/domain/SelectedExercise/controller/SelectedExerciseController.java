package com.inti.nosily_coach.domain.SelectedExercise.controller;

import com.inti.nosily_coach.domain.ExerciseRecord.model.dto.CreateExerciseRecordRequest;
import com.inti.nosily_coach.domain.ExerciseRecord.repository.ExerciseRecordRepository;
import com.inti.nosily_coach.domain.ExerciseRecord.service.ExerciseRecordService;
import com.inti.nosily_coach.domain.SelectedExercise.model.dto.CreateSelectedExerciseRequest;
import com.inti.nosily_coach.domain.SelectedExercise.model.dto.DeleteSelectedExerciseRequest;
import com.inti.nosily_coach.domain.SelectedExercise.service.SelectedExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RequiredArgsConstructor
@RestController
public class SelectedExerciseController {
    private final SelectedExerciseService selectedExerciseService;
    private final ExerciseRecordService exerciseRecordService;
    private final ExerciseRecordRepository exerciseRecordRepository;

    // # 운동 오늘 기록에 추가
    @PostMapping("/api/selectedExercise")
    public void createSelectedExercise(Long memberId, Long exerciseId, @RequestBody CreateSelectedExerciseRequest request) {
        LocalDate localDate = LocalDate.now();
        if (exerciseRecordRepository.getNumOfTodayRecord(memberId, localDate) == 0) {
            CreateExerciseRecordRequest recordRequest = CreateExerciseRecordRequest.withEmpty();
            exerciseRecordService.createExerciseRecord(memberId, recordRequest);
        }
        selectedExerciseService.createSelectedExercise(memberId, exerciseId, localDate, request);
    }

    // # 선택한 운동 삭제
    @DeleteMapping("/api/selectedExercises")
    public void deleteSelectedExercise(Long memberId, @RequestBody DeleteSelectedExerciseRequest request) {
        selectedExerciseService.deleteSelectedExercise(memberId, request);
    }

    // # 선택한 운동 수정
}