package com.jas.nio.basic.socket;

import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/07/17
 */
public class ClientSocket {

    private final Integer port;

    private final String host;

    public ClientSocket(Integer port, String host) {
        this.port = port;
        this.host = host;
    }

    public static void main(String[] args) throws Exception {
        new ClientSocket(8080, "127.0.0.1").start();
    }

    public void start() throws Exception {
        SocketChannel sc = SocketChannel.open();
        sc.connect(new InetSocketAddress(host, port));

        Scanner scanner = new Scanner(System.in);

        while (!sc.finishConnect()) {
            System.out.println("connect is not ok!");
        }

        String str;
        String overMsg = "over";
        while (!overMsg.equals(str = scanner.nextLine())) {
            SocketUtil.sendMsg(sc, str);
        }

        sc.close();
        scanner.close();
    }
}
