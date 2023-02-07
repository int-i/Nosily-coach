package com.inti.nosily_coach.domain.Eat.repository;

import com.inti.nosily_coach.domain.Eat.model.Eat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor; // Querydsl을 이용하기 위해 추가
import org.springframework.data.repository.query.Param;

public interface EatRepository extends JpaRepository<Eat, Long>, EatRepositoryCustom, QuerydslPredicateExecutor<Eat> {
    @Override
    Eat save(Eat eat);

    @Query("select f, r from Eat f left join f.record r where f.food =:food")
    Object getEatWithFood(@Param("food") Long food); // 음식 정보와 함께 음식 리스트 조회


}
