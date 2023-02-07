package com.inti.nosily_coach.domain.Eat.repository;

import com.inti.nosily_coach.domain.Eat.model.Eat;
import com.inti.nosily_coach.domain.food.model.Food;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EatRepositoryCustom {
    Eat findEatByfoodName(Long memberId, Food food, Long DietRecordId);
    List<Eat> pageEat(Long foodId, Pageable pageable);
}
