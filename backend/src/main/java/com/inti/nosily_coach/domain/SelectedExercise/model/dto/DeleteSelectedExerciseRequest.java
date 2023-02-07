package com.inti.nosily_coach.domain.SelectedExercise.model.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DeleteSelectedExerciseRequest {
    @NotNull
    private Long recordId;

    @NotNull
    private Long exerciseId;
}
