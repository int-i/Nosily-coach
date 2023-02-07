package com.inti.nosily_coach.domain.Exercise.service;

import com.inti.nosily_coach.domain.Exercise.model.dto.*;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ExerciseService {
    List<GetExerciseResponse> getAllExercises (Pageable pageable);
}
