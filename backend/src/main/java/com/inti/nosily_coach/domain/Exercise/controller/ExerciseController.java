package com.inti.nosily_coach.domain.Exercise.controller;

import com.inti.nosily_coach.domain.Exercise.model.dto.GetExerciseResponse;
import com.inti.nosily_coach.domain.Exercise.service.ExerciseService;
import com.inti.nosily_coach.domain.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Pageable;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ExerciseController {
    private final ExerciseService exerciseService;

    // # 운동법 전체 조회
    @GetMapping("/api/exercises")
    public ApiResponse<List<GetExerciseResponse>> getAllExercises(@PageableDefault Pageable pageable) {
        List<GetExerciseResponse> getExerciseResponses = exerciseService.getAllExercises(pageable);
        return ApiResponse.success(getExerciseResponses);
    }
}
