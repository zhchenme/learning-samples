package com.zhchen.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/25
 */
public class UDPClient {

    public static void main(String[] args) throws IOException {

        DatagramSocket ds = new DatagramSocket();
        String text;
        byte[] bytes;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (!"over".equals(text = br.readLine())) {
            bytes = text.getBytes();
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 8080);
            ds.send(dp);
        }
        ds.close();
    }

}
