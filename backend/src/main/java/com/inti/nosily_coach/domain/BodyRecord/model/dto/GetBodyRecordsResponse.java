package com.inti.nosily_coach.domain.BodyRecord.model.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetBodyRecordsResponse {
    private Long recordId;
    private Float height;
    private Float weight;
    private Float bodyFatPercentage;
    private Float muscle;
    private Double bmi;
    private String createdAt;

    public static GetBodyRecordsResponse of (Long recordId, Float height, Float weight, Float bodyFatPercentage, Float muscle, String createdAt) {
        Double bmi = null;
        if (height != null && weight != null) {
            bmi = weight / ((height / 100.0) * (height / 100.0));
            bmi = Math.round(bmi * 10) / 10.0;
        }
        return new GetBodyRecordsResponse(recordId, height, weight, bodyFatPercentage, muscle, bmi, createdAt);
    }
}
