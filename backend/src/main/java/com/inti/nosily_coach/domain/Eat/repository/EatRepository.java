package com.inti.nosily_coach.domain.Eat.repository;

import com.inti.nosily_coach.domain.Eat.model.Eat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EatRepository extends JpaRepository<Eat, Long>, EatRepositoryCustom {
}
