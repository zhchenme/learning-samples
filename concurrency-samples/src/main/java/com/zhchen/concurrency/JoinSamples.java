package com.zhchen.concurrency;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/09/07
 */
public class JoinSamples {

    private static final Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {

        ThreadTask tt = new ThreadTask();
        tt.start();
        // join 底层调用 wait() 方法，因此会释放锁
        tt.join();
        synchronized (LOCK) {
            System.out.println("MainTask running...");
        }
    }

    static class ThreadTask extends Thread {

        @Override
        public void run() {
            synchronized (LOCK) {
                System.out.println("ThreadTask run...");
            }
        }
    }
}
