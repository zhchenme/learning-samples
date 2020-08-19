package com.zhchen.io.stream;

import java.io.ByteArrayInputStream;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/18
 */
public class ByteArrayInputStreamSamples {

    public static void main(String[] args) throws Exception {

        byte[] bytes = "Hello world!".getBytes();
        ByteArrayInputStream is = new ByteArrayInputStream(bytes, 5, 12);
        // available 用于返回有多少字节可读，mark reset method
        System.out.println(is.available());
        is.skip(1L);
        int data;
        while (-1 != (data = is.read())) {
            System.out.print((char)data);
        }
        is.close();
    }

}
