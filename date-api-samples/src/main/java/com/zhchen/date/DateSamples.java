package com.zhchen.date;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/20
 */
public class DateSamples {

    public static void main(String[] args) throws Exception {

        utilDateSamples();
        sqlDateSamples();
    }

    private static void sqlDateSamples() {
        long time = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(time);
        System.out.println(date.getDate());
    }

    private static void utilDateSamples() throws Exception {
        java.util.Date date = new java.util.Date();
        System.out.println(date.getTime());
        date = new java.util.Date(System.currentTimeMillis());
        Thread.sleep(100L);
        System.out.println(date.getDate());
    }

}
