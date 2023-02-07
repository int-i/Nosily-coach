package com.inti.nosily_coach.domain.Eat.repository;

import com.inti.nosily_coach.domain.Eat.model.Eat;
import com.inti.nosily_coach.domain.food.model.Food;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.inti.nosily_coach.domain.Eat.model.QEat.eat;
import static com.querydsl.core.types.dsl.Expressions.numberOperation;

@RequiredArgsConstructor
public class EatRepositoryCustomImpl implements EatRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    @Transactional
    public Eat findEatByfoodName(Long memberId, Food food, Long DietRecordId) {
        return jpaQueryFactory.selectFrom(eat)
                .where(
                        eat.dietRecord.member.id.eq(memberId),
                        eat.dietRecord.id.eq(DietRecordId),
                        eat.food.name.eq(food.getName())
                ).fetchOne();
    }

    @Override
    @Transactional
    public List<Eat> pageEat(Long foodId, Pageable pageable) {
        return jpaQueryFactory.selectFrom(eat)
                .where(
                        eat.food.id.eq(foodId)
                ).orderBy(eat.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }
}
