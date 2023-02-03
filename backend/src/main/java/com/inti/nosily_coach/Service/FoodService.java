package com.inti.nosily_coach.Service;

import com.inti.nosily_coach.domain.food.model.Food;
import com.inti.nosily_coach.domain.food.repository.FoodRepositoryCustom;
import com.inti.nosily_coach.domain.food.repository.FoodRepositoryCustomImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {
    private final FoodRepositoryCustom foodRepositoryCustom = new FoodRepositoryCustomImpl();

    public Long insertFood(Food food) { // 중복된 음식인지 확인하는 메서드
        validateDuplicateFood(food);
        foodRepositoryCustom.save(food);
        return food.getId();
    }

    private void validateDuplicateFood(Food food) {
        foodRepositoryCustom.findByName(food.getName())
                .ifPresent(food1 -> {
                    throw new IllegalStateException("이미 존재하는 음식입니다.");
                });
    }

    public List<Food> findFoods() { // 전체 음식 리스트를 조회하는 메서드
        return foodRepositoryCustom.findAll();
    }

    public Optional<Food> findOne(String food_name) { // 전체 음식 리스트 중 하나의 음식을 조회하는 메서드
        return foodRepositoryCustom.findByName(food_name);
    }
}
