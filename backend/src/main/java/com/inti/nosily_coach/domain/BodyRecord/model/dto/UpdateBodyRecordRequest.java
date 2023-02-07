package com.inti.nosily_coach.domain.BodyRecord.model.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UpdateBodyRecordRequest {
    private Float height;

    @NotNull
    private Float weight;

    private Float bodyFatPercentage;

    private Float muscle;
}
