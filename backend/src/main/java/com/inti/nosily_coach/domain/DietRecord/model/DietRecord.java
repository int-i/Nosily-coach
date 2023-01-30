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

    @OneToMany(mappedBy = "diet_record", cascade = CascadeType.ALL)
    private List<Eat> eats = new ArrayList<>();

    @Column(nullable = false)
    private String time; // 아침, 점심, 저녁, 간식

    @Column(length = 300)
    private String memo;

    @Builder(access = AccessLevel.PRIVATE)
    private DietRecord(Member member, String time, String memo) {
        this.member = member;
        this.time = time;
        this.memo = memo;
    }

    public static DietRecord newDietRecord(Member member, String time, String memo) {
        return DietRecord.builder()
                .member(member)
                .time(time)
                .memo(memo)
                .build();
    }
}
