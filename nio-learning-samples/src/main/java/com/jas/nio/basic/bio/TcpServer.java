package com.jas.nio.basic.bio;


import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/07/24
 */
public class TcpServer {

    private static final Integer PORT = 8080;

    private final Integer port;

    public TcpServer(Integer port) {
        this.port = port;
    }

    public TcpServer() {
        this(PORT);
    }

    public static void main(String[] args) throws Exception {
        new TcpServer().start();
    }

    private void start() throws Exception {
        ServerSocket ss = new ServerSocket(port);
        while (true) {
            Socket socket = ss.accept();
            try {
                System.out.println("有连接进来了");
                byte[] bytes = new byte[1024];
                InputStream is = socket.getInputStream();
                int len;
                while (-1 != (len = is.read(bytes))) {
                    System.out.println(new String(bytes, 0, len));
                }
            } catch (Exception ignored) {}
        }
    }
}
