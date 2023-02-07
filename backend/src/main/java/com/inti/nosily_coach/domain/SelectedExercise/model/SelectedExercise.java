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
import java.util.Timer;

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

    @Column
    private LocalTime time; // 운동시간

    @Column
    private Long count; // 1회 횟수

    @Column
    private Long set; // set 횟수

    @Builder(access = AccessLevel.PRIVATE)
    private SelectedExercise(ExerciseRecord exerciseRecord, Exercise exercise, LocalTime time, Long count, Long set) {
        this.exerciseRecord = exerciseRecord;
        this.exercise = exercise;
        this.time = time;
        this.count = count;
        this.set = set;
    }

    public static SelectedExercise newSelectedExercise(ExerciseRecord exerciseRecord, Exercise exercise, LocalTime time, Long count, Long set) {
        return SelectedExercise.builder()
                .exerciseRecord(exerciseRecord)
                .exercise(exercise)
                .time(time)
                .count(count)
                .set(set)
                .build();
    }
}
