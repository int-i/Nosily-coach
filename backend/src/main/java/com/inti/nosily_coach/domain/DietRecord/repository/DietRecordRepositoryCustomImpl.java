package com.inti.nosily_coach.domain.DietRecord.repository;

import com.inti.nosily_coach.domain.DietRecord.model.DietRecord;
import com.inti.nosily_coach.domain.Member.model.Member;
import com.querydsl.core.types.Ops;
import com.querydsl.core.types.dsl.NumberOperation;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static com.inti.nosily_coach.domain.DietRecord.model.QDietRecord.dietRecord;
import static com.querydsl.core.types.dsl.Expressions.numberOperation;

@Service
@RequiredArgsConstructor
public class DietRecordRepositoryCustomImpl implements DietRecordRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    @Override
    public DietRecord findDietRecordByDietRecordId(Long memberId, Long DietRecordId) { // 식단기록 id로 식단기록 조회하는 메서드
        return queryFactory.selectFrom(dietRecord)
                .where(
                        dietRecord.member.id.eq(memberId),
                        dietRecord.id.eq(DietRecordId)
                ).fetchOne();
    }

    @Override
    public List<DietRecord> pageDietRecord(Long memberId, Pageable pageable) { // 전체 식단기록 조회하는 메서드
        return queryFactory.selectFrom(dietRecord)
                .where(
                        dietRecord.member.id.eq(memberId)
                ).orderBy(dietRecord.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    @Override
    public DietRecord findDietRecordByDate(Long memberId, LocalDate localDate) { // 날짜로 식단기록 조회하는 메서드
        NumberOperation<Integer> toYear = numberOperation(Integer.class, Ops.DateTimeOps.YEAR, dietRecord.createdAt);
        NumberOperation<Integer> toMonth = numberOperation(Integer.class, Ops.DateTimeOps.MONTH, dietRecord.createdAt);
        NumberOperation<Integer> toDay = numberOperation(Integer.class, Ops.DateTimeOps.DAY_OF_MONTH, dietRecord.createdAt);
        return queryFactory.selectFrom(dietRecord)
                .where(
                        dietRecord.member.id.eq(memberId),
                        toYear.eq(localDate.getYear()),
                        toMonth.eq(localDate.getMonthValue()),
                        toDay.eq(localDate.getDayOfMonth())
                ).fetchOne();
    }
}
