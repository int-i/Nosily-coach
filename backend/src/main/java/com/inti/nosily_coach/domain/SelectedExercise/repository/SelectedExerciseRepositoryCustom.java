package com.inti.nosily_coach.domain.SelectedExercise.repository;

import com.inti.nosily_coach.domain.SelectedExercise.model.SelectedExercise;

public interface SelectedExerciseRepositoryCustom {
    SelectedExercise findByRecordAndExercise(Long memberId, Long exerciseId, Long recordId);
}
