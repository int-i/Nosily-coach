package com.inti.nosily_coach.domain.BodyRecord.service;

import com.inti.nosily_coach.domain.BodyRecord.repository.BodyRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BodyServiceImpl implements BodyRecordService {
    private final BodyRecordRepository bodyRecordRepository;
}
