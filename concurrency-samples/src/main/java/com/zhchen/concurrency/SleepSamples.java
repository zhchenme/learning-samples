package com.zhchen.concurrency;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/09/07
 */
public class SleepSamples {

    public static void main(String[] args) {

        Task task = new Task();
        new Thread(task).start();
        new Thread(task).start();
    }

    public static class Task implements Runnable {

        @Override
        public void run() {
            synchronized (this) {
                System.out.println("-------------");
                try {
                    // sleep 不会释放锁
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("=============");
            }
        }
    }
}
