package com.inti.nosily_coach.domain.ExerciseRecord.controller;

import com.inti.nosily_coach.domain.ExerciseRecord.model.dto.CreateExerciseRecordRequest;
import com.inti.nosily_coach.domain.ExerciseRecord.model.dto.CreateExerciseRecordResponse;
import com.inti.nosily_coach.domain.ExerciseRecord.model.dto.GetExerciseRecordResponse;
import com.inti.nosily_coach.domain.ExerciseRecord.model.dto.UpdateExerciseRecordResponse;
import com.inti.nosily_coach.domain.ExerciseRecord.service.ExerciseRecordService;
import com.inti.nosily_coach.domain.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ExerciseRecordController {
    private final ExerciseRecordService exerciseRecordService;

    // # 운동 기록 작성
    @PostMapping("/api/exerciseRecords")
    public ApiResponse<CreateExerciseRecordResponse> createExerciseRecord(
            Long memberId, @RequestBody CreateExerciseRecordRequest createExerciseRecordRequest) {
        CreateExerciseRecordResponse response = exerciseRecordService.createExerciseRecord(memberId, createExerciseRecordRequest);

        return ApiResponse.success(response);
    }

    // # 운동 기록 수정
    @PatchMapping("/api/exerciseRecords/{recordId}")
    public ApiResponse<UpdateExerciseRecordResponse> updateExerciseRecord(
            Long memberId, @PathVariable("recordId") Long recordId, @RequestBody(required = false) String memo) {
        UpdateExerciseRecordResponse response = exerciseRecordService.updateExerciseRecord(memberId, recordId, memo);

        return ApiResponse.success(response);
    }

    // # 운동 기록 전체 조회
    @GetMapping("/api/exerciseRecords")
    public ApiResponse<List<GetExerciseRecordResponse>> getAllExerciseRecords(
            Long memberId, @PageableDefault Pageable pageable) {
        List<GetExerciseRecordResponse> response = exerciseRecordService.getAllExerciseRecords(memberId, pageable);

        return ApiResponse.success(response);
    }

    // # 운동 기록 날짜별 조회
    @GetMapping("/api/exerciseRecords/date")
    public ApiResponse<GetExerciseRecordResponse> getExerciseRecordByDate(
            Long memberId, @RequestParam LocalDate localDate) {
        GetExerciseRecordResponse response = exerciseRecordService.getExerciseRecordByDate(memberId, localDate);

        return ApiResponse.success(response);
    }
}
