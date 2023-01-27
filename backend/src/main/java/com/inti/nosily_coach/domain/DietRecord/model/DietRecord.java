package com.inti.nosily_coach.domain.DietRecord.model;

import com.inti.nosily_coach.domain.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;


@Entity
@Getter // 알아서 정보를 불러오는 함수가 만들어짐
@NoArgsConstructor // 생성자가 알아서 만들어짐
public class DietRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    @Column(updatable = false)
    private LocalDate createAt;

    @LastModifiedDate
    private LocalDate updatedAt;

    public void updateUpdatedAt(@NotNull LocalDate updatedAt)
    {
        this.updatedAt = updatedAt;
    }

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
