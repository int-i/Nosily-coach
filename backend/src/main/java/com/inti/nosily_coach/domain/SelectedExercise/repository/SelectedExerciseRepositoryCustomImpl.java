package com.inti.nosily_coach.domain.SelectedExercise.repository;

import com.inti.nosily_coach.domain.SelectedExercise.model.SelectedExercise;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import static com.inti.nosily_coach.domain.SelectedExercise.model.QSelectedExercise.selectedExercise;
@RequiredArgsConstructor
public class SelectedExerciseRepositoryCustomImpl implements SelectedExerciseRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public SelectedExercise findByRecordAndExercise(Long memberId, Long exerciseId, Long recordId) {
        return jpaQueryFactory.selectFrom(selectedExercise)
                .where(
                        selectedExercise.exerciseRecord.member.id.eq(memberId),
                        selectedExercise.exerciseRecord.id.eq(exerciseId),
                        selectedExercise.exercise.id.eq(exerciseId)
                ).fetchOne();
    }
}
