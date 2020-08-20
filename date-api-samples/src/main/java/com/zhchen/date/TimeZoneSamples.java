package com.zhchen.date;

import java.util.TimeZone;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/20
 */
public class TimeZoneSamples {

    public static void main(String[] args) {

        samples1();
    }

    private static void samples1() {
        TimeZone timeZone = TimeZone.getDefault();
        System.out.println(timeZone.getDisplayName());
        System.out.println(timeZone.getID());
        System.out.println(timeZone.getOffset(System.currentTimeMillis()) / 1000 / 60 / 60);
    }

}
