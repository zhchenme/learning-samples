package com.zhchen.concurrency;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/09/04
 */
public class VolatileSamples {

    public static volatile int num = 0;

    public static void main(String[] args) {

        for (int i = 0; i < 10000; i++) {
            new Thread(() -> ++num).start();
        }
        System.out.println(num);
    }

}
