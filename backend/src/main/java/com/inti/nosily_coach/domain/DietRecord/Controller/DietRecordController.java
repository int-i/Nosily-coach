package com.inti.nosily_coach.domain.DietRecord.Controller;

import com.inti.nosily_coach.domain.DietRecord.DTO.DTODietRecord;
import com.inti.nosily_coach.domain.DietRecord.DTO.ModifyDietRecord;
import com.inti.nosily_coach.domain.DietRecord.DTO.ResponseDietRecord;
import com.inti.nosily_coach.domain.DietRecord.DTO.RequestDietRecord;
import com.inti.nosily_coach.domain.DietRecord.Service.DietRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/DietRecord")
@RequiredArgsConstructor
public class DietRecordController {
    private final DietRecordService dietRecordService;

    @GetMapping("/view")
    public List<DTODietRecord> viewDietRecordApi(Long memberId, @PageableDefault(size = 5) Pageable pageable) { // 식단기록 조회하는 컨트롤러
        List<DTODietRecord> dietRecord = dietRecordService.viewDietRecord(memberId, pageable);
        return dietRecord;
    }

    @PostMapping("/create")
    public ResponseDietRecord createDietRecordApi(Long memberId, @RequestBody RequestDietRecord requestDietRecord) { // 식단기록 추가하는 컨트롤러
        return dietRecordService.createDietRecord(memberId, requestDietRecord);
    }

    @PostMapping("/modify")
    public ModifyDietRecord modifyDietRecordApi(Long memberId, @PathVariable("DietRecordId") Long DietRecordId, @RequestBody String memo) { // 식단기록 수정하는 컨트롤러
        return dietRecordService.modifyDietRecord(memberId, DietRecordId, memo);
    }
}
