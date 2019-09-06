package com.jas.staticcodeblock;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Person
 *
 * @author lanxiang
 * @since 2019-09-02
 */
public class Person {

    /**
     * final 标识字段为常量
     */
    private final Date birthDate = new Date();

    private static final Date BOOM_START;

    private static final Date BOOM_END;

    static {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1996, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_START = gmtCal.getTime();
        gmtCal.set(2020, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_END = gmtCal.getTime();
    }

    /**
     * 检验一个人是否出生于 1996～2020
     * @return
     */
    public boolean isBabyBoomer() {
        return birthDate.compareTo(BOOM_START) >= 0 &&
                birthDate.compareTo(BOOM_END) < 0;
    }

    public static void main(String[] args) {
        Person p = new Person();
        System.out.println(p.birthDate);
        System.out.println(p.birthDate);
        System.out.println(p.isBabyBoomer());
    }

}
