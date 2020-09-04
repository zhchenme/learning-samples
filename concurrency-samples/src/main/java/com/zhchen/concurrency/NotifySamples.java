package com.zhchen.concurrency;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/09/01
 */
public class NotifySamples {

    public static void main(String[] args) {
        final Object lock = new Object();
        ThreadA t1 = new ThreadA("sub", lock);
        synchronized (lock) {
            try {
                System.out.println(Thread.currentThread().getName() + " start t1");
                t1.start();
                System.out.println(Thread.currentThread().getName() + " wait()");
                lock.wait();
                System.out.println(Thread.currentThread().getName() + " continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadA extends Thread {

        private final Object lock;

        public ThreadA(String name, Object lock) {
            super(name);
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " call notify()");
                lock.notify();
            }
        }
    }
}