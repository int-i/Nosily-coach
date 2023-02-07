package com.inti.nosily_coach.domain.Eat.model;

import com.inti.nosily_coach.domain.DietRecord.model.DietRecord;
import com.inti.nosily_coach.domain.common.BaseEntity;
import com.inti.nosily_coach.domain.food.model.Food;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Eat extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dietRecord_id")
    private DietRecord dietRecord;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food;

    @Builder(access = AccessLevel.PRIVATE)
    private Eat(DietRecord dietRecord, Food food) {
        this.dietRecord = dietRecord;
        this.food = food;
    }

    public static Eat newEat(DietRecord dietRecord, Food food) {
        return Eat.builder()
                .dietRecord(dietRecord)
                .food(food).build();
    }
}
