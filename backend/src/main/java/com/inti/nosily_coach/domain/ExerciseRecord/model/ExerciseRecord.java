package com.inti.nosily_coach.domain.ExerciseRecord.model;

import com.inti.nosily_coach.domain.Member.model.Member;
import com.inti.nosily_coach.domain.SelectedExercise.model.SelectedExercise;
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
public class ExerciseRecord extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member; // 회원 table과 매핑

    @OneToMany(mappedBy = "exerciseRecord", cascade = CascadeType.ALL)
    private List<SelectedExercise> selectedExercises = new ArrayList<>();

    @Column(length = 300)
    private String memo;

    @Builder(access = AccessLevel.PRIVATE)
    private ExerciseRecord(Member member, String memo) {
        this.member = member;
        this.memo = memo;
    }

    public static ExerciseRecord newExerciseRecord(Member member, String memo) {
        return ExerciseRecord.builder()
                .member(member)
                .memo(memo)
                .build();
    }

    public void update(String memo) {
        this.memo = memo;
    }
}
