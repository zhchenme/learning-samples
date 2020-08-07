package com.jas.nio.basic.reactor;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/07
 * @link https://blog.genuine.com/2013/07/nio-based-reactor/
 */
public class Reactor implements Runnable{

    private final Selector selector;
    private final ServerSocketChannel serverChannel;
    private static final int WORKED_POOL_SIZE = 10;
    public static ExecutorService workerPool;

    public Reactor(int port) throws Exception {
        selector = Selector.open();
        serverChannel = ServerSocketChannel.open();
        serverChannel.socket().bind(new InetSocketAddress(port));
        serverChannel.configureBlocking(false);
        SelectionKey sk = serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        sk.attach(new Acceptor());
    }

    @Override
    public void run() {
        try {
            while (true) {
                int select = selector.select();
                if (select > 0) {
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey sk = iterator.next();
                        iterator.remove();
                        Runnable run = (Runnable) sk.attachment();
                        if (null != run) {
                            run.run();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        workerPool = Executors.newFixedThreadPool(WORKED_POOL_SIZE);
        workerPool.execute(new Reactor(8080));
    }

    public class Acceptor implements Runnable {
        @Override
        public void run() {
            try {
                SocketChannel channel = serverChannel.accept();
                if (null != channel) {
                    new Handler(selector, channel);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
