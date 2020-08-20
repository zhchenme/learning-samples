package com.zhchen.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/20
 */
public class LocalDateTimeSamples {

    public static void main(String[] args) {

        samples1();
        samples2();
    }

    // 获取今天剩余毫秒数
    private static void samples2() {
        LocalDateTime midnight = LocalDateTime.now().plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
        System.out.println(ChronoUnit.MILLIS.between(LocalDateTime.now(), midnight));;
    }

    // 获取今天开始与结束时间（+1）
    private static void samples1() {
        // LocalDateTime.now().plusDays(0).withHour(0).withMinute(0).withSecond(0).withNano(0).atOffset(ZoneOffset.of("+8")).toInstant().toEpochMilli()
        // LocalDateTime.now().plusDays(0).withHour(0).withMinute(0).withSecond(0).withNano(0).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.MAX).toInstant(ZoneOffset.ofHours(8)).toEpochMilli());
        // LocalDateTime.now().plusDays(0).withHour(23).withMinute(59).withSecond(59).withNano(59).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.MIN).plusDays(1).toInstant(ZoneOffset.ofHours(8)).toEpochMilli());
    }

}
