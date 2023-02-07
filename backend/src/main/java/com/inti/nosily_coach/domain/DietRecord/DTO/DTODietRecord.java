package com.inti.nosily_coach.domain.DietRecord.DTO;

import com.inti.nosily_coach.domain.Eat.model.Eat;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DTODietRecord {
    private Long DietRecordId; // 식단기록 id
    private String createAt; // 생성날짜
    private String memo; // 메모
    private List<Eat> eats; // 식단기록 리스트

    public static DTODietRecord of(Long DietRecordId, String createAt, String memo, List<Eat> eats) {
        return new DTODietRecord(DietRecordId, createAt, memo, eats);
    }
}