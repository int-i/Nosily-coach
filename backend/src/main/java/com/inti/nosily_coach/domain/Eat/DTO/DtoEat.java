package com.inti.nosily_coach.domain.Eat.DTO;

import com.inti.nosily_coach.domain.DietRecord.model.DietRecord;
import com.inti.nosily_coach.domain.food.model.Food;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoEat {
    private Long FoodId;
    private String foodName;
    private String time;
    private Long intake;

    public static DtoEat of(Long foodId, String foodName, String time, Long intake) {
        return new DtoEat(foodId, foodName, time, intake);
    }
}
