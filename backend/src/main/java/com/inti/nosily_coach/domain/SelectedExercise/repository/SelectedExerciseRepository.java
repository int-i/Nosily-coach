package com.inti.nosily_coach.domain.SelectedExercise.repository;

import com.inti.nosily_coach.domain.SelectedExercise.model.SelectedExercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SelectedExerciseRepository extends JpaRepository<SelectedExercise, Long>, SelectedExerciseRepositoryCustom {
}
