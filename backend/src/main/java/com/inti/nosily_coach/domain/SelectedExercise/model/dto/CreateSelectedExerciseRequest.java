package com.inti.nosily_coach.domain.SelectedExercise.model.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateSelectedExerciseRequest {
    private LocalTime times;
    private int counts; // 1회 횟수
    private int setCnt; // set 횟수
}