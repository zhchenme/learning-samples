package com.jas.nio.basic.reactor;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/07
 */
public class Handler implements Runnable {

    private final SocketChannel channel;
    private final SelectionKey selectionKey;
    private static final int READ_BUF_SIZE = 1024;
    private static final int WRITE_BUF_SIZE = 1024;
    private final ByteBuffer readBuf = ByteBuffer.allocate(READ_BUF_SIZE);
    private ByteBuffer writeBuf = ByteBuffer.allocate(WRITE_BUF_SIZE);

    public Handler(Selector selector, SocketChannel socketChannel) throws Exception {
        channel = socketChannel;
        channel.configureBlocking(false);
        selectionKey = channel.register(selector, SelectionKey.OP_READ);
        selectionKey.attach(this);
        selectionKey.interestOps(SelectionKey.OP_READ);
        selector.wakeup();
    }

    @Override
    public void run() {
        try {
            if (selectionKey.isReadable()) {
                read();
            } else if (selectionKey.isWritable()) {
                write();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void write() throws Exception {
        int write = channel.write(writeBuf);
        try {
            if (0 < write) {
                readBuf.clear();
                writeBuf.clear();
                selectionKey.interestOps(SelectionKey.OP_READ);
                selectionKey.selector().wakeup();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private synchronized void read() throws Exception {
        int read = channel.read(readBuf);
        System.out.println("read(): #bytes read into 'readBuf' buffer = " + read);
        if (-1 == read) {
            selectionKey.cancel();
            channel.close();
        } else {
            Reactor.workerPool.execute(this::process);
        }
    }

    private synchronized void process() {
        readBuf.flip();
        byte[] bytes = new byte[readBuf.remaining()];
        readBuf.get(bytes, 0, bytes.length);
        System.out.print("process(): " + new String(bytes, StandardCharsets.UTF_8));
        System.out.println();
        writeBuf = ByteBuffer.wrap(bytes);
        selectionKey.interestOps(SelectionKey.OP_WRITE);
        selectionKey.selector().wakeup();
    }
}
