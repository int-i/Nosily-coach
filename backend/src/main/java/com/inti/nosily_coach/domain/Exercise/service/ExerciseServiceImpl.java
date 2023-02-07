package com.inti.nosily_coach.domain.Exercise.service;

import com.inti.nosily_coach.domain.Exercise.model.dto.*;
import com.inti.nosily_coach.domain.Exercise.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService  {
    private final ExerciseRepository exerciseRepository;

    // # 운동법 전체 조회
    @Override
    @Transactional(readOnly = true)
    public List<GetExerciseResponse> getAllExercises (Pageable pageable) {
        return exerciseRepository.findAllWithPaging(pageable).stream()
                .map(exercise -> GetExerciseResponse.of(exercise.getName(), exercise.getType(),
                        exercise.getPosition(), exercise.getDescription(), exercise.getUrl(),
                        exercise.getRecCount(), exercise.getRecSet())).collect(Collectors.toList());
    }
}
