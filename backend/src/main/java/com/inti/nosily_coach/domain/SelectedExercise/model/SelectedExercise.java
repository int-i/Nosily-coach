package com.inti.nosily_coach.domain.SelectedExercise.model;

import com.inti.nosily_coach.domain.Exercise.model.Exercise;
import com.inti.nosily_coach.domain.ExerciseRecord.model.ExerciseRecord;
import com.inti.nosily_coach.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Getter
@NoArgsConstructor
public class SelectedExercise extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exerciseRecord_id")
    private ExerciseRecord exerciseRecord;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    @Column(nullable = false)
    private LocalTime times; // 운동시간

    @Column(nullable = false)
    private int counts; // 1회 횟수

    @Column(nullable = false)
    private int setCnt; // set 횟수

    @Builder(access = AccessLevel.PRIVATE)
    private SelectedExercise(ExerciseRecord exerciseRecord, Exercise exercise, LocalTime times, int counts, int setCnt) {
        this.exerciseRecord = exerciseRecord;
        this.exercise = exercise;
        this.times = times;
        this.counts = counts;
        this.setCnt = setCnt;
    }

    public static SelectedExercise newSelectedExercise(ExerciseRecord exerciseRecord, Exercise exercise, LocalTime times, int counts, int setCnt) {
        return SelectedExercise.builder()
                .exerciseRecord(exerciseRecord)
                .exercise(exercise)
                .times(times)
                .counts(counts)
                .setCnt(setCnt)
                .build();
    }

    public void update(LocalTime times, int counts, int setCnt) {
        this.times = times;
        this.counts = counts;
        this.setCnt = setCnt;
    }
}
