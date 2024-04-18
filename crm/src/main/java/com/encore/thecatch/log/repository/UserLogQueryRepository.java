package com.encore.thecatch.log.repository;

import com.encore.thecatch.log.domain.QUserLog;
import com.encore.thecatch.log.dto.DayOfWeekLogin;
import com.encore.thecatch.log.dto.QDayOfWeekLogin;
import com.encore.thecatch.log.dto.QVisitTodayUserRes;
import com.encore.thecatch.log.dto.VisitTodayUserRes;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserLogQueryRepository {
    private final JPAQueryFactory queryFactory;

    QUserLog userLog = QUserLog.userLog;


    public Long visitTotalUser() {
        return queryFactory
                .select(
                        userLog.count())
                .from(userLog)
                .fetchCount();
    }

    public Long visitToday() {
//        x.goe(y); (x >= y)
//        x.loe(y); (x <= y)
        return queryFactory
                .select(
                        userLog.count())
                .from(userLog)
                .where(userLog.createdTime.goe(LocalDateTime.of(LocalDate.now(), LocalTime.of(0,0, 0))),
                        userLog.createdTime.loe(LocalDateTime.of(LocalDate.now(), LocalTime.of(12,59, 59))))
                .fetchCount();
    }

    public List<VisitTodayUserRes> visitTodayUser() {
        return queryFactory
                .select(new QVisitTodayUserRes(userLog.email))
                .distinct()
                .from(userLog)
                .where(userLog.createdTime.goe(LocalDateTime.of(LocalDate.now(), LocalTime.of(0,0, 0))),
                        userLog.createdTime.loe(LocalDateTime.of(LocalDate.now(), LocalTime.of(12,59, 59))))
                .fetch();
    }

    public List<DayOfWeekLogin> dayOfWeekLogin() {
        LocalDate now = LocalDate.now();
        LocalDate startOfLastWeek = now.minusWeeks(1).with(DayOfWeek.MONDAY);
        LocalDate endOfLastWeek = now.minusWeeks(1).with(DayOfWeek.SUNDAY);

        return queryFactory
                .select(new QDayOfWeekLogin(
                        userLog.createdTime.dayOfWeek().as("day").stringValue(),
                        userLog.count()))
                .from(userLog)
                .where(userLog.createdTime.between(startOfLastWeek.atStartOfDay(), endOfLastWeek.atTime(23, 59, 59)))
                .groupBy(userLog.createdTime.dayOfWeek())
                .orderBy(userLog.createdTime.dayOfWeek().asc())
                .fetch();
    }
}
