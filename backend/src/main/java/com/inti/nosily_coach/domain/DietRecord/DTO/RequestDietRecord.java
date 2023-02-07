package com.inti.nosily_coach.domain.DietRecord.DTO;

import com.inti.nosily_coach.domain.DietRecord.model.DietRecord;
import com.inti.nosily_coach.domain.Member.model.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestDietRecord {
    private String memo; // 메모

    public static DietRecord ToEntity(Member member, String memo) {
        return DietRecord.newDietRecord(member, memo);
    }
}
