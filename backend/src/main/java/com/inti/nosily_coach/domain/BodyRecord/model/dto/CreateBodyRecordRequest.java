package com.inti.nosily_coach.domain.BodyRecord.model.dto;

import com.inti.nosily_coach.domain.BodyRecord.model.BodyRecord;
import com.inti.nosily_coach.domain.Member.model.Member;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateBodyRecordRequest {
    private Float height;

    private Float weight;

    private Float bodyFatPercentage;

    private Float muscle;

    public BodyRecord toEntity(Member member, Float height, Float weight, Float bodyFatPercentage, Float muscle) {
        return BodyRecord.newBodyRecord(member, height, weight, bodyFatPercentage, muscle);
    }
}
