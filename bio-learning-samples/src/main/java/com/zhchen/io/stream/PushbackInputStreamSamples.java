package com.zhchen.io.stream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/19
 */
public class PushbackInputStreamSamples {

    public static void main(String[] args) throws IOException {
        byte[] bytes = "hello world!".getBytes();
        PushbackInputStream pis = new PushbackInputStream(new ByteArrayInputStream(bytes), 1);
        int data;
        data = pis.read();
        System.out.println((char)data);

        // push back and read again
        pis.unread(data);
        data = pis.read();
        System.out.println((char)data);

        pis.unread(data);
        System.out.println((char)data);
//        while (-1 != (data = pis.read())) {
//
//        }
    }

}
