package com.inti.nosily_coach.domain.ExerciseRecord.model.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UpdateExerciseRecordResponse {
    private Long recordId;

    public static UpdateExerciseRecordResponse of (@NotNull Long recordId) {
        return new UpdateExerciseRecordResponse(recordId);
    }
}
