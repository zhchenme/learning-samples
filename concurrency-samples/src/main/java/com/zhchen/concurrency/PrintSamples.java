package com.zhchen.concurrency;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/09/07
 */
public class PrintSamples {

    public static void main(String[] args) {

        PrintTask pt = new PrintTask(TaskEnum.A);
        new Thread(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    pt.printA();
                }
            } catch (InterruptedException ignored) {
            }
        }).start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    pt.printB();
                }
            } catch (InterruptedException ignored) {
            }
        }).start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    pt.printC();
                }
            } catch (InterruptedException ignored) {
            }
        }).start();
    }

    public static class PrintTask {

        private TaskEnum taskEnum;

        public PrintTask(TaskEnum taskEnum) {
            this.taskEnum = taskEnum;
        }

        public synchronized void printA() throws InterruptedException {
            while (!taskEnum.equals(TaskEnum.A)) {
                wait();
            }
            System.out.print("A");
            taskEnum = TaskEnum.B;
            notifyAll();
        }

        public synchronized void printB() throws InterruptedException {
            while (!taskEnum.equals(TaskEnum.B)) {
                wait();
            }
            System.out.print("B");
            taskEnum = TaskEnum.C;
            notifyAll();
        }

        public synchronized void printC() throws InterruptedException {
            while (!taskEnum.equals(TaskEnum.C)) {
                wait();
            }
            System.out.print("C");
            taskEnum = TaskEnum.A;
            notifyAll();
        }
    }

    public enum TaskEnum {
        A, B, C
    }
}
