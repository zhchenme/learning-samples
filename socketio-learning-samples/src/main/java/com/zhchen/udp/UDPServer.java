package com.zhchen.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/25
 */
public class UDPServer {

    public static void main(String[] args) throws IOException {

        DatagramSocket ds = new DatagramSocket(8080);
        byte[] bytes = new byte[1024];
        while (true) {
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
            ds.receive(dp);
            byte[] readData = dp.getData();
            System.out.println(new String(readData, 0, readData.length));
        }
    }

}
