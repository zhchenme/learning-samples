package com.zhchen.concurrency;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/09/07
 */
public class YieldSamples {

    public static void main(String[] args) {
        YieldTask t1 = new YieldTask("t1");
        YieldTask t2 = new YieldTask("t2");
        t1.setPriority(4);
        t1.start();
        t2.start();
    }

    static class YieldTask extends Thread {

        public YieldTask(String name) {
            super(name);
        }

        @Override
        public synchronized void run() {
            for (int i = 1; i < 5; i++) {
                System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i);
                if (i % 2 == 0) {
                    Thread.yield();
                }
            }
        }
    }
}