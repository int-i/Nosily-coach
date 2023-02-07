package com.inti.nosily_coach.domain.Eat.model;

import com.inti.nosily_coach.domain.DietRecord.model.DietRecord;
import com.inti.nosily_coach.domain.common.BaseEntity;
import com.inti.nosily_coach.domain.food.model.Food;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
public class Eat extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dietRecord_id")
    private DietRecord dietRecord; // 식단기록 id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food; // 음식 id

    @Column(nullable = false)
    private String time; // 아침, 점심, 저녁, 간식

    @Column
    private Long intake; // 섭취량

    @Builder(access = AccessLevel.PRIVATE)
    private Eat(DietRecord dietRecord, Food food, String time, Long intake) {
        this.dietRecord = dietRecord;
        this.food = food;
        this.time = time;
        this.intake = intake;
    }

    public static Eat newEat(DietRecord dietRecord, Food food, String time, Long intake) {
        return Eat.builder()
                .dietRecord(dietRecord)
                .food(food)
                .time(time)
                .intake(intake)
                .build();
    }

    public void updateEat(String time, Long intake) { // 업데이트하는 메서드
        this.time = time;
        this.intake = intake;
    }
}
