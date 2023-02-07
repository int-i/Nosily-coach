package com.inti.nosily_coach.domain.DietRecord.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ModifyDietRecord {
    private Long DietRecordId; // 식단기록 id

    public static ModifyDietRecord of(@NotNull Long DietRecordId) { // 식단기록 수정
        return new ModifyDietRecord(DietRecordId);
    }
}
