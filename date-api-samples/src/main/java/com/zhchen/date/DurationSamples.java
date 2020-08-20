package com.zhchen.date;

import java.time.Duration;
import java.time.Instant;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/20
 */
public class DurationSamples {

    public static void main(String[] args) throws InterruptedException {

        Instant first = Instant.now();
        Thread.sleep(1000);
        Instant second = Instant.now();
        Duration duration = Duration.between(first, second);
        System.out.println(duration.toMillis());
    }

}
