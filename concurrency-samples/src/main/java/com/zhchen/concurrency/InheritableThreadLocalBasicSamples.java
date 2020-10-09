package com.zhchen.concurrency;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/09/30
 */
public class InheritableThreadLocalBasicSamples {

    public static void main(String[] args) {

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        // 会将值传递给子线程
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

        new Thread(() -> {
            System.out.println("===== Thread 1 =====");
            threadLocal.set("Thread 1 - ThreadLocal");
            inheritableThreadLocal.set("Thread 1 - InheritableThreadLocal");

            System.out.println(threadLocal.get());
            System.out.println(inheritableThreadLocal.get());

            Thread childThread = new Thread(() -> {
                System.out.println("===== ChildThread =====");
                System.out.println(threadLocal.get());
                System.out.println(inheritableThreadLocal.get());
            }, "==== ChildThread ====");
            childThread.start();
        }, "==== ParentThread ====").start();

        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("===== Thread2 =====");
            System.out.println(threadLocal.get());
            System.out.println(inheritableThreadLocal.get());
        }).start();
    }

    /**
     * print result:
     * ===== Thread 1 =====
     * Thread 1 - ThreadLocal
     * Thread 1 - InheritableThreadLocal
     * ===== ChildThread =====
     * null
     * Thread 1 - InheritableThreadLocal
     * ===== Thread2 =====
     * null
     * null
     */
}