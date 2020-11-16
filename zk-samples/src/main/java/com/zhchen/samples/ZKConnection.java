package com.zhchen.samples;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/11/16
 */
public class ZKConnection {
    private ZooKeeper zoo;
    CountDownLatch connectionLatch = new CountDownLatch(1);

    public ZooKeeper connect(String host) {
        try {
            zoo = new ZooKeeper(host, 2000, we -> {
                if (we.getState() == Watcher.Event.KeeperState.SyncConnected) {
                    connectionLatch.countDown();
                }
            });
            connectionLatch.await();
            return zoo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
 
    public void close() throws InterruptedException {
        zoo.close();
    }
}