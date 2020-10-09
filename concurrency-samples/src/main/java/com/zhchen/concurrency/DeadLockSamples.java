package com.zhchen.concurrency;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/10/09
 */
public class DeadLockSamples {
    /**
     * 死锁必要条件：
     * 1.互斥条件：一个资源每次只能被一个线程占用
     * 2.请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放
     * 3.不剥夺条件：进程已获得的资源，在未使用完之前，不能强行剥夺
     * 4.循环等待条件：若干进程之间形成一种头尾相接的循环等待资源关系
     * <p>
     * 解决死锁的方式（只要破坏生面任何一种条件即可解决死锁问题）：
     * 1.以同样的顺序获取锁，避免出现 A -> B，B -> A 的情况
     * 2.超时放弃
     */
    final static Object A = new Object();
    final static Object B = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (A) {
                try {
                    System.out.println("thread1 locked");
                    Thread.sleep(100L);
                    synchronized (B) {
                        System.out.println("B locked by thread1");
                    }
                } catch (Exception ignored) {
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (B) {
                try {
                    System.out.println("thread2 locked");
                    Thread.sleep(100L);
                    synchronized (A) {
                        System.out.println("A locked by thread2");
                    }
                } catch (Exception ignored) {
                }
            }
        }).start();
    }
}