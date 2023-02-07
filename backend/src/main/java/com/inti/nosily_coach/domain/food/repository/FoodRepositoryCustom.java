package com.inti.nosily_coach.domain.food.repository;

import com.inti.nosily_coach.domain.food.model.Food;

import java.util.List;
import java.util.Optional;
public interface FoodRepositoryCustom {
    Food save(Food food); // 새로운 음식을 DB에 추가하는 메서드
    Optional<Food> findByName(String name); // 음식 이름으로 Food 객체를 찾는 메서드
    List<Food> findAll(); // 모든 음식 리스트를 다 반환하는 메서드
}
