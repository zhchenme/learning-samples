package com.zhchen.io.stream;

import java.io.ByteArrayOutputStream;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/18
 */
public class ByteArrayOutputStreamSamples {

    public static void main(String[] args) throws Exception {

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        os.write("aaaaaaaaassaafffffffffffffffffff".getBytes());
        byte[] bytes = os.toByteArray();
        System.out.println("bytes length：" + bytes.length);
        for (byte aByte : bytes) {
            System.out.print((char)aByte);
        }
        os.close();
    }

}
