package com.inti.nosily_coach.domain.DietRecord.repository;

import com.inti.nosily_coach.domain.DietRecord.model.DietRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DietRecordRepository extends JpaRepository<DietRecord, Long>, DietRecordRepositoryCustom {
}
