package com.inti.nosily_coach.domain.Exercise.repository;

import com.inti.nosily_coach.domain.Exercise.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long>, ExerciseRepositoryCustom {

}
