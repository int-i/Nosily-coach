package com.inti.nosily_coach.domain.DietRecord.repository;

import com.inti.nosily_coach.domain.DietRecord.model.DietRecord;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface DietRecordRepositoryCustom {
    DietRecord findDietRecordByDietRecordId(Long memberId, Long DietRecordId); // 식단기록 id로 식단기록을 조회하는 메서드
    DietRecord findDietRecordByDate(Long memberId, LocalDate localDate); // 날짜로 식단기록을 조회하는 메서드
    List<DietRecord> pageDietRecord(Long member_id, Pageable pageable); // 페이징 처리 메서드
}
