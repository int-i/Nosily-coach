package com.inti.nosily_coach.domain.Eat.DTO;


import com.inti.nosily_coach.domain.DietRecord.model.DietRecord;
import com.inti.nosily_coach.domain.Eat.model.Eat;
import com.inti.nosily_coach.domain.food.model.Food;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestEat {
    private String time; // 시간 : 아침, 점심, 저녁, 간식
    private Long intake; // 섭취량

    public static Eat ToEntity(DietRecord dietRecord, Food food, String time, Long intake) {
        return Eat.newEat(dietRecord, food, time, intake);
    }
}
