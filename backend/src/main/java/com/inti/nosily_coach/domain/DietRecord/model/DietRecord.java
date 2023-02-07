package com.inti.nosily_coach.domain.DietRecord.model;

import com.inti.nosily_coach.domain.Eat.model.Eat;
import com.inti.nosily_coach.domain.Member.model.Member;
import com.inti.nosily_coach.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class DietRecord extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(length = 30)
    private String foodName; // 음식이름

    @Column(nullable = false)
    private Long intake; // 섭취량

    @Column(nullable = false)
    private Long kcal; // 칼로리

    @Column(length = 1000)
    private String memo; // 메모

    @Builder(access = AccessLevel.PRIVATE)
    private DietRecord(Member member, String foodName, Long intake, Long kcal, String memo) {
        this.member = member;
        this.foodName = foodName;
        this.intake = intake;
        this.kcal = kcal;
        this.memo = memo;
    }

    // build()를 호출하는 메서드
    public static DietRecord newDietRecord(Member member, String foodName, Long intake, Long kcal, String memo) {
        return DietRecord.builder().member(member)
                .foodName(foodName)
                .intake(intake)
                .kcal(kcal)
                .memo(memo)
                .build();
    }
}
