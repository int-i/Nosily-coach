package com.inti.nosily_coach.domain.ExerciseRecord.model.dto;

import com.inti.nosily_coach.domain.ExerciseRecord.model.ExerciseRecord;
import com.inti.nosily_coach.domain.Member.model.Member;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateExerciseRecordRequest {
    private String memo;

    public ExerciseRecord toEntity(Member member, String memo) {
        return ExerciseRecord.newExerciseRecord(member, memo);
    }

    public  static CreateExerciseRecordRequest withEmpty() {
        return new CreateExerciseRecordRequest();
    }
}
