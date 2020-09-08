package com.zhchen.concurrency;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/09/08
 */
public class InterruptSamples {

    public static void main(String[] args) throws InterruptedException {

        Task task = new Task("t1");
        task.start();
        Thread.sleep(100);
        task.interrupt();
    }

    static class Task extends Thread {

        public Task(String name) {
            super(name);
        }

        @Override
        public void run() {
            int i = 0;
            try {
                while (!isInterrupted()) {
                    i++;
                    System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") loop " + i);
                    sleep(100);
                }
            } catch (InterruptedException e) {
                // 中断异常被捕获时，会清除中断状态
                System.out.println("isInterrupted: " + isInterrupted());
            }

        }
    }
}