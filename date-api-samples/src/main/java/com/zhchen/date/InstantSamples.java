package com.zhchen.date;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/20
 */
public class InstantSamples {

    public static void main(String[] args) {

        Instant now = Instant.now();
        System.out.println(now.getNano());
        System.out.println(now.toEpochMilli());
        // plus one day
        System.out.println(now.plus(1, ChronoUnit.DAYS).toEpochMilli());
    }

}
