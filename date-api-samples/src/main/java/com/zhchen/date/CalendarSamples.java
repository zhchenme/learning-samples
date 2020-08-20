package com.zhchen.date;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/20
 */
public class CalendarSamples {

    public static void main(String[] args) {

        samples1();
    }

    private static void samples1() {
        Calendar calendar = new GregorianCalendar();

        calendar.add(Calendar.YEAR, 1);

        int year       = calendar.get(Calendar.YEAR);
        int month      = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH); // Jan = 0, not 1, 0-11
        int dayOfWeek  = calendar.get(Calendar.DAY_OF_WEEK);  // Sunday = 1, Saturday = 6
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        int weekOfMonth= calendar.get(Calendar.WEEK_OF_MONTH);

        int hour       = calendar.get(Calendar.HOUR);        // 12 hour clock
        int hourOfDay  = calendar.get(Calendar.HOUR_OF_DAY); // 24 hour clock
        int minute     = calendar.get(Calendar.MINUTE);
        int second     = calendar.get(Calendar.SECOND);
        int millisecond= calendar.get(Calendar.MILLISECOND);

        System.out.println(year);
        System.out.println(month);
        System.out.println(dayOfMonth);
        System.out.println(dayOfWeek);
    }

}