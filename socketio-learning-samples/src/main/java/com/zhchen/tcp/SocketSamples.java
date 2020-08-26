package com.zhchen.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/25
 */
public class SocketSamples {
    private static final Integer PORT = 8080;
    private static final String ADDRESS = "127.0.0.1";

    private final String address;
    private final Integer port;

    public SocketSamples(String address, Integer port) {
        this.port = port;
        this.address = address;
    }

    public SocketSamples() {
        this(ADDRESS, PORT);
    }

    public static void main(String[] args) throws Exception {
        new SocketSamples().start();
    }

    private void start() throws Exception {
        Socket socket = new Socket(address, port);
        Scanner scanner = new Scanner(System.in);
        new Thread(() -> {
            int len;
            byte[] bytes = new byte[1024];
            try {
                InputStream is = socket.getInputStream();
                while ((-1 != (len = is.read(bytes)))) {
                    System.out.println(new String(bytes, 0, len));
                }
                System.out.println("服务端下线");
                is.close();
            } catch (IOException ignored) {
            }
        }).start();
        OutputStream os = socket.getOutputStream();
        String str;
        while (!"over".equals(str = scanner.nextLine())) {
            os.write(str.getBytes());
            os.flush();
        }
        os.close();
        socket.close();
    }
}
