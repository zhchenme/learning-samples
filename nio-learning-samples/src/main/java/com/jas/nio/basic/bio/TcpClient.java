package com.jas.nio.basic.bio;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/07/24
 */
public class TcpClient {

    private static final Integer PORT = 8080;
    private static final String ADDRESS = "127.0.0.1";

    private final String address;
    private final Integer port;

    public TcpClient(String address, Integer port) {
        this.port = port;
        this.address = address;
    }

    public TcpClient() {
        this(ADDRESS, PORT);
    }

    public static void main(String[] args) throws Exception {
        new TcpClient().start();
    }

    private void start() throws Exception {
        Socket socket = new Socket(address, port);
        OutputStream os = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        String str;
        while (!"over".equals(str = scanner.nextLine())) {
            os.write(str.getBytes());
            os.flush();
        }
        os.close();
        socket.close();
    }
}
