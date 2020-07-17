package com.jas.nio.basic.socket;

import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/07/17
 */
public class ServerSocket {

    private final Integer port;

    public ServerSocket(Integer port) {
        this.port = port;
    }

    public static void main(String[] args) throws Exception {
        new ServerSocket(8080).start();
    }

    public void start() throws Exception {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(port));
        SocketChannel sc = ssc.accept();

        while (true) {
            System.out.println(SocketUtil.receiverMsg(sc));
        }
    }

}
