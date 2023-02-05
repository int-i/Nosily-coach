package com.inti.nosily_coach.domain.Eat.repository;

import com.inti.nosily_coach.domain.Eat.model.Eat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor; // Querydsl을 이용하기 위해 추가

public interface EatRepository extends JpaRepository<Eat, Long>, EatRepositoryCustom, QuerydslPredicateExecutor<Eat> {
    @Override
    Eat save(Eat eat);

    
}
