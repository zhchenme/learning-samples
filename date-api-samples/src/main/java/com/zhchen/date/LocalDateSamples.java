package com.zhchen.date;

import java.time.LocalDate;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/20
 */
public class LocalDateSamples {

    public static void main(String[] args) {
        samples1();
    }

    private static void samples1() {

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonth()); // enum
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getDayOfWeek()); // enum
        System.out.println(localDate.getDayOfYear());

        System.out.println(localDate.plusDays(2));
    }
}
