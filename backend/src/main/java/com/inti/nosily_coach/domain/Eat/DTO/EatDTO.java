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
public class EatDTO {
    private Long id;
    private DietRecord dietRecord;
    private Food food;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private Long intake;
}
