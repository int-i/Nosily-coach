package com.inti.nosily_coach.domain.Exercise.model;

import com.inti.nosily_coach.domain.SelectedExercise.model.SelectedExercise;
import com.inti.nosily_coach.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Exercise extends BaseEntity {
    @Column(length = 20)
    private String name; // 운동명

    @Column(length = 3000)
    private String description; // 운동 설명

    @Column(nullable = false)
    private String type; // 분류 : 스트레칭, 유산소, 무산소

    @Column(nullable = false)
    private String position; // 영향 위치 : 전체, 팔, 다리 등

    @Column(nullable = false)
    private String url; // 운동영상 url

    @Column(nullable = false)
    private Long recCount; // 1회 추천 횟수

    @Column(nullable = false)
    private Long recSet; // set 추천 횟수

    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL)
    private List<SelectedExercise> selectedExercises = new ArrayList<>();
}
