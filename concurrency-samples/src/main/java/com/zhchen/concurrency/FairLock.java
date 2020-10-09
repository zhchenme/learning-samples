package com.zhchen.concurrency;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @from http://tutorials.jenkov.com/java-concurrency/starvation-and-fairness.html
 * @since 2020/10/09
 * <p>
 * 这并非一个按照先后顺序执行的公平锁，唤醒队列中的线程是随机的
 */
public class FairLock {

    private boolean isLocked = false;
    private Thread lockingThread = null;
    private final List<QueueObject> waitingThreadList = new ArrayList<>();

    public void lock() {
        QueueObject queueObject = new QueueObject(Thread.currentThread());
        boolean isLockedForThisThread;
        synchronized (this) {
            waitingThreadList.add(queueObject);
        }
        while (true) {
            synchronized (this) {
                isLockedForThisThread = isLocked || waitingThreadList.get(0) != queueObject;
                if (!isLockedForThisThread) {
                    isLocked = true;
                    waitingThreadList.remove(queueObject);
                    lockingThread = Thread.currentThread();
                    return;
                }
            }
            try {
                queueObject.doWait();
                while (waitingThreadList.get(0).getThread() != Thread.currentThread()) {
                    queueObject.doWait();
                }
            } catch (InterruptedException e) {
                synchronized (this) {
                    waitingThreadList.remove(queueObject);
                }
                e.printStackTrace();
            }
        }
    }

    public synchronized void unLock() {
        if (this.lockingThread != Thread.currentThread()) {
            throw new IllegalMonitorStateException("Calling thread has not locked this lock");
        }
        isLocked = false;
        lockingThread = null;
        if (waitingThreadList.size() > 0) {
            waitingThreadList.get(0).doNotify();
        }
    }

    public static void testCase(FairLock lock) {
        lock.lock();
        System.out.println(Thread.currentThread().getName());
        lock.unLock();
    }

    public static void main(String[] args) {

        FairLock lock = new FairLock();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> testCase(lock));
            thread.setName("thread-" + i);
            thread.start();
        }
    }

    private static class QueueObject {

        private boolean isNotified = false;
        private final Thread thread;

        private QueueObject(Thread thread) {
            this.thread = thread;
        }

        public Thread getThread() {
            return thread;
        }

        public synchronized void doWait() throws InterruptedException {
            while (!isNotified) {
                this.wait();
            }
            this.isNotified = false;
        }

        public synchronized void doNotify() {
            this.isNotified = true;
            this.notify();
        }
    }
}
