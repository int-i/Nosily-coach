package com.inti.nosily_coach.domain.Eat.Service;

import com.inti.nosily_coach.domain.DietRecord.model.DietRecord;
import com.inti.nosily_coach.domain.Eat.DTO.DtoEat;
import com.inti.nosily_coach.domain.Eat.DTO.ModifyEat;
import com.inti.nosily_coach.domain.Eat.DTO.RequestEat;
import com.inti.nosily_coach.domain.Eat.DTO.ResponseEat;
import com.inti.nosily_coach.domain.Eat.model.Eat;
import com.inti.nosily_coach.domain.food.model.Food;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EatService {
    List<DtoEat> viewEat(Long foodId, Pageable pageable);
    ResponseEat createEat(DietRecord dietRecord, Food food, RequestEat requestEat);
    ModifyEat modifyEat(Long memberId, Food food, Long DietRecordId, RequestEat requestEat);
    void selectEat();
}
