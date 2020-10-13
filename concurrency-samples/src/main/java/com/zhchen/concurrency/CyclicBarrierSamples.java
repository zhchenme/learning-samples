package com.zhchen.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/10/13
 */
public class CyclicBarrierSamples {

    private static final ExecutorService SERVICE = Executors.newFixedThreadPool(4);

    private static final CyclicBarrier CYCLIC_BARRIER = new CyclicBarrier(4, () -> System.out.println("4人已到齐，请系好安全带，现在出发赶往目的地!"));

    public static void main(String[] args) {

        IntStream.range(0, 8).forEach(i -> SERVICE.submit(() -> {
            try {
                System.out.println("到达指定拼车地点 !");
                CYCLIC_BARRIER.await();
                System.out.println("出发了 !");
            } catch (InterruptedException | BrokenBarrierException exception) {
                exception.printStackTrace();
            }
        }));
        SERVICE.shutdown();
    }
}
