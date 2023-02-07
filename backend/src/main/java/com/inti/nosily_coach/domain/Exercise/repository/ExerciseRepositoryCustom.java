package com.inti.nosily_coach.domain.Exercise.repository;

import com.inti.nosily_coach.domain.Exercise.model.Exercise;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ExerciseRepositoryCustom {
    List<Exercise> findAllWithPaging(Pageable pageable);
}
