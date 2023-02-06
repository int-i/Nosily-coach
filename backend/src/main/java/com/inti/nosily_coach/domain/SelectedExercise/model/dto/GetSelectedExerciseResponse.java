package com.inti.nosily_coach.domain.SelectedExercise.model.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetSelectedExerciseResponse {
    private String exerciseName; // 운동법 이름
    private int counts;
    private int setCnt;

    public static GetSelectedExerciseResponse of(String exerciseName, int counts, int setCnt) {
        return new GetSelectedExerciseResponse(exerciseName, counts, setCnt);
    }
}