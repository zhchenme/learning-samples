package com.zhchen.date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/20
 */
public class DateTimeFormatterSamples {

    public static void main(String[] args) {

        samples1();
        samples2();

    }

    // time parse
    private static void samples2() {
        String str = "2008年08月23日 23:59:59";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        LocalDateTime time = LocalDateTime.parse(str, formatter);
        System.out.println(time.getDayOfMonth());
    }

    // time format
    private static void samples1() {
        long stamp = System.currentTimeMillis();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        LocalDateTime time = LocalDateTime.ofInstant(Instant.ofEpochMilli(stamp), ZoneId.systemDefault());
        System.out.println(formatter.format(time));
    }

}
