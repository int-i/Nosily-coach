package com.inti.nosily_coach.domain.Eat.Controller;

import com.inti.nosily_coach.domain.DietRecord.Service.DietRecordService;
import com.inti.nosily_coach.domain.DietRecord.model.DietRecord;
import com.inti.nosily_coach.domain.DietRecord.repository.DietRecordRepository;
import com.inti.nosily_coach.domain.Eat.DTO.DtoEat;
import com.inti.nosily_coach.domain.Eat.DTO.ModifyEat;
import com.inti.nosily_coach.domain.Eat.DTO.RequestEat;
import com.inti.nosily_coach.domain.Eat.DTO.ResponseEat;
import com.inti.nosily_coach.domain.Eat.Service.EatService;
import com.inti.nosily_coach.domain.food.model.Food;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/Eat")
@RequiredArgsConstructor
public class EatController {
    private final EatService eatService;
    private final DietRecordService dietRecordService;
    private final DietRecordRepository dietRecordRepository;

    @GetMapping("/view")
    public List<DtoEat> viewEatApi(Long foodId, @PageableDefault(size = 5) Pageable pageable) {
        List<DtoEat> eat = eatService.viewEat(foodId, pageable);
        return eat;
    }

    @PostMapping("/create")
    public ResponseEat createEatApi(DietRecord dietRecord, Food food, @RequestBody RequestEat requestEat) {
        return eatService.createEat(dietRecord, food, requestEat);
    }

    @PostMapping("/modify")
    public ModifyEat modifyEat(Long memberId, @PathVariable("food") Food food, @PathVariable("DietRecord") Long DietRecordId, @RequestBody RequestEat requestEat) {
        return eatService.modifyEat(memberId, food, DietRecordId, requestEat);
    }
}
