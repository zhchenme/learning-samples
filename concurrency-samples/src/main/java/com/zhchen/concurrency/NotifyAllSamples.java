package com.zhchen.concurrency;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/09/01
 */
public class NotifyAllSamples {

    private static final Object LOCK = new Object();

    public static void main(String[] args) {

        ThreadA t1 = new ThreadA("t1");
        ThreadA t2 = new ThreadA("t2");
        ThreadA t3 = new ThreadA("t3");
        t1.start();
        t2.start();
        t3.start();

        try {
            System.out.println(Thread.currentThread().getName() + " sleep(3000)");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (LOCK) {
            System.out.println(Thread.currentThread().getName() + " notifyAll()");
            LOCK.notifyAll();
        }
    }

    static class ThreadA extends Thread {
        public ThreadA(String name) {
            super(name);
        }
        @Override
        public void run() {
            synchronized (LOCK) {
                try {
                    System.out.println(Thread.currentThread().getName() + " wait");
                    LOCK.wait();
                    System.out.println(Thread.currentThread().getName() + " continue");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}