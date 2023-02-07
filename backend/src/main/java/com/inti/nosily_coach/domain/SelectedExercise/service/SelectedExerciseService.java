package com.inti.nosily_coach.domain.SelectedExercise.service;

import com.inti.nosily_coach.domain.Exercise.model.Exercise;
import com.inti.nosily_coach.domain.ExerciseRecord.model.ExerciseRecord;
import com.inti.nosily_coach.domain.SelectedExercise.model.SelectedExercise;
import com.inti.nosily_coach.domain.SelectedExercise.model.dto.CreateSelectedExerciseRequest;
import com.inti.nosily_coach.domain.SelectedExercise.model.dto.DeleteSelectedExerciseRequest;
import com.inti.nosily_coach.domain.SelectedExercise.model.dto.GetSelectedExerciseResponse;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface SelectedExerciseService {
    void createSelectedExercise(Long memberId, Long exerciseId, LocalDate localDate, CreateSelectedExerciseRequest request);
    void updateSelectedExercise(SelectedExercise selectedExercise, LocalTime times, int counts, int setCnt);
    void deleteSelectedExercise(Long memberId, DeleteSelectedExerciseRequest request);
    List<GetSelectedExerciseResponse> getSelectedExercise(List<SelectedExercise> selectedExercises);
}
