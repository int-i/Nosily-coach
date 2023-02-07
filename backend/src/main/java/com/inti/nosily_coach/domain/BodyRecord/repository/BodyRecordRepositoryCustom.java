package com.inti.nosily_coach.domain.BodyRecord.repository;

import com.inti.nosily_coach.domain.BodyRecord.model.BodyRecord;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface BodyRecordRepositoryCustom {
    List<BodyRecord> findAllByMemberId(Long memberId, Pageable pageable);
    BodyRecord findByDate(Long memberId, LocalDate localDate);
    Long recordNumOfDate(Long memberId, LocalDate localDate);
    BodyRecord findByRecordId (Long memberId, Long recordId);
}
