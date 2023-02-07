package com.inti.nosily_coach.domain.Exercise.model.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetExerciseResponse {
    private String name;
    private String type; // 스트레칭, 유산소, 무산소
    private String position;  // 팔, 허벅지 등
    private String description;
    private String url;
    private Long rec_count;
    private Long rec_set;

    public static GetExerciseResponse of(String name, String type, String pos, String desc, String url, Long rec_count, Long rec_set) {
        return new GetExerciseResponse(name, type, pos, desc, url, rec_count, rec_set);
    }
}
