package com.zhchen.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/09/08
 */
public class ProducerConsumerSamples {

    public static void main(String[] args) {

        Resource resource = new Resource(new ArrayList<>(), 2);
        new Thread(new Producer(resource)).start();
        new Thread(new Producer(resource)).start();
        new Thread(new Producer(resource)).start();
        new Thread(new Consumer(resource)).start();
        new Thread(new Consumer(resource)).start();
        new Thread(new Consumer(resource)).start();
    }

    public static class Consumer implements Runnable {

        private final Resource resource;

        public Consumer(Resource resource) {
            this.resource = resource;
        }

        @Override
        public void run() {
            try {
                resource.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Producer implements Runnable {

        private final Resource resource;

        public Producer(Resource resource) {
            this.resource = resource;
        }

        @Override
        public void run() {
            try {
                resource.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Resource {

        private final List<Integer> bufList;

        private final Integer maxBufSize;

        public Resource(List<Integer> bufList, Integer maxBufSize) {
            this.bufList = bufList;
            this.maxBufSize = maxBufSize;
        }

        public synchronized void produce() throws InterruptedException {
            while (bufList.size() >= maxBufSize) {
                System.out.println("装不下了");
                wait();
            }
            int nextInt = new Random().nextInt(100) + 1;
            bufList.add(nextInt);
            System.out.println("进货：" + nextInt);
            notifyAll();
        }

        public synchronized void consume() throws InterruptedException {
            while (bufList.isEmpty()) {
                System.out.println("没有货了");
                wait();
            }
            Integer remove = bufList.remove(0);
            System.out.println("出货：" + remove);
            notifyAll();
        }
    }
}
