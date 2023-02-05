package com.inti.nosily_coach.domain.Eat.model;

import com.inti.nosily_coach.domain.DietRecord.model.DietRecord;
import com.inti.nosily_coach.domain.common.BaseEntity;
import com.inti.nosily_coach.domain.food.model.Food;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Eat extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dietRecord_id")
    private DietRecord dietRecord; // 식단기록 id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food; // 음식 id

    @Column
    private Long intake; // 섭취량

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
