package com.inti.nosily_coach.domain.food.repository;

import com.inti.nosily_coach.domain.food.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long>, FoodRepositoryCustom {
}
