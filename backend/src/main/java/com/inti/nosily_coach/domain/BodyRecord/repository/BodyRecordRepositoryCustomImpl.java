package com.inti.nosily_coach.domain.BodyRecord.repository;

import com.inti.nosily_coach.domain.BodyRecord.model.BodyRecord;
import com.querydsl.core.types.Ops;
import com.querydsl.core.types.dsl.NumberOperation;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

import static com.inti.nosily_coach.domain.BodyRecord.model.QBodyRecord.bodyRecord;
import static com.querydsl.core.types.dsl.Expressions.numberOperation;

@RequiredArgsConstructor
public class BodyRecordRepositoryCustomImpl implements BodyRecordRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    // # 몸기록 전체 조회
    @Override
    public List<BodyRecord> findAllByMemberId(Long memberId, Pageable pageable) {
        return jpaQueryFactory.selectFrom(bodyRecord)
                .where(bodyRecord.member.id.eq(memberId))
                .orderBy(bodyRecord.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    // # 몸기록 날짜 조회
    @Override
    public BodyRecord findByDate(Long memberId, LocalDate localDate) {
        NumberOperation<Integer> toYear = numberOperation(Integer.class, Ops.DateTimeOps.YEAR, bodyRecord.createdAt);
        NumberOperation<Integer> toMonth = numberOperation(Integer.class, Ops.DateTimeOps.MONTH, bodyRecord.createdAt);
        NumberOperation<Integer> toDay = numberOperation(Integer.class, Ops.DateTimeOps.DAY_OF_MONTH, bodyRecord.createdAt);
        return jpaQueryFactory.selectFrom(bodyRecord)
                .where(
                        bodyRecord.member.id.eq(memberId),
                        toYear.eq(localDate.getYear()),
                        toMonth.eq(localDate.getMonthValue()),
                        toDay.eq(localDate.getDayOfMonth())
                ).fetchOne();
    }

    // # 기록된 몸 기록이 있는지
    @Override
    public Long recordNumOfDate(Long memberId, LocalDate localDate) {
        NumberOperation<Integer> toYear = numberOperation(Integer.class, Ops.DateTimeOps.YEAR, bodyRecord.createdAt);
        NumberOperation<Integer> toMonth = numberOperation(Integer.class, Ops.DateTimeOps.MONTH, bodyRecord.createdAt);
        NumberOperation<Integer> toDay = numberOperation(Integer.class, Ops.DateTimeOps.DAY_OF_MONTH, bodyRecord.createdAt);
        return jpaQueryFactory.select(bodyRecord.count()).from(bodyRecord)
                .where(
                        bodyRecord.member.id.eq(memberId),
                        toYear.eq(localDate.getYear()),
                        toMonth.eq(localDate.getMonthValue()),
                        toDay.eq(localDate.getDayOfMonth())
                ).fetchOne();
    }

    // # 단일 조회
    @Override
    public BodyRecord findByRecordId (Long memberId, Long recordId) {
        return jpaQueryFactory.selectFrom(bodyRecord)
                .where(
                        bodyRecord.member.id.eq(memberId),
                        bodyRecord.id.eq(recordId)
                ).fetchOne();
    }
}