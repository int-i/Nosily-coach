package com.inti.nosily_coach.domain.BodyRecord.repository;

import com.inti.nosily_coach.domain.BodyRecord.model.BodyRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BodyRecordRepository extends JpaRepository<BodyRecord, Long>, BodyRecordRepositoryCustom {
}
