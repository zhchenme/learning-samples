package com.zhchen.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/25
 */
public class ServerSocketSamples {

    private static final Integer PORT = 8080;

    private final Integer port;

    public ServerSocketSamples(Integer port) {
        this.port = port;
    }

    public ServerSocketSamples() {
        this(PORT);
    }

    public static void main(String[] args) throws Exception {
        new ServerSocketSamples().start();
    }

    private void start() throws Exception {
        ServerSocket ss = new ServerSocket(port);
        while (true) {
            Socket socket = ss.accept();
            System.out.println("有连接进来了");
            new Thread(() -> {
                try {
                    byte[] bytes = new byte[1024];
                    InputStream is = socket.getInputStream();
                    OutputStream os = socket.getOutputStream();
                    int len;
                    // -1 表示客户端或服务端下线
                    while (-1 != (len = is.read(bytes))) {
                        System.out.println(new String(bytes, 0, len));
                        os.write("copy that.".getBytes());
                        os.flush();
                    }
                    System.out.println("客户端下线");
                    is.close();
                    os.close();
                    socket.close();
                } catch (Exception ignored) {}
            }).start();
        }
    }

}
