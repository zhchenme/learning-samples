package com.zhchen.concurrency;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/09/08
 */
public class DaemonThreadSamples {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
        // 守护线程不会按照逻辑执行完成，当所有非守护线程执行完成后，随着 JVM 退出而退出
        DaemonTask dt = new DaemonTask();
        dt.setDaemon(true);
        dt.start();
    }

    public static class DaemonTask extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }

}
