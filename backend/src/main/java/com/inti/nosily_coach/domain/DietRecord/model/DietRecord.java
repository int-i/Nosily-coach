package com.inti.nosily_coach.domain.DietRecord.model;

import com.inti.nosily_coach.domain.Eat.model.Eat;
import com.inti.nosily_coach.domain.Member.model.Member;
import com.inti.nosily_coach.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class DietRecord extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member; // 회원 아이디

    @OneToMany(mappedBy = "dietRecord", cascade = CascadeType.ALL)
    private List<Eat> eats = new ArrayList<>(); // 식단 기록

    @Column(length = 300)
    private String memo; // 메모

    @Builder(access = AccessLevel.PRIVATE)
    private DietRecord(Member member, String memo) {
        this.member = member;
        this.memo = memo;
    }

    public static DietRecord newDietRecord(Member member, String memo) {
        return DietRecord.builder()
                .member(member)
                .memo(memo)
                .build();
    }

    public void updateMemo(String memo) { // 메모 수정하는 메서드
        this.memo = memo;
    }
}
