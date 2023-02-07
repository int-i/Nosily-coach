package com.inti.nosily_coach.domain.Exercise.repository;

import com.inti.nosily_coach.domain.Exercise.model.Exercise;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static com.inti.nosily_coach.domain.Exercise.model.QExercise.exercise;

@RequiredArgsConstructor
public class ExerciseRepositoryCustomImpl implements ExerciseRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    // # 운동법 전체 조회
    @Override
    public List<Exercise> findAllWithPaging(Pageable pageable) {
        return queryFactory.selectFrom(exercise)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(exercise.createdAt.desc())
                .fetch();
    }
}
