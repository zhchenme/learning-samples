package com.zhchen.io.array;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/14
 */
public class ReadingAndWritingArray {

    public static void main(String[] args) throws IOException {

        // 输入流读取数组
        byte[] bytes = {'a', 'b', 'c'};
        InputStream inputStream = new ByteArrayInputStream(bytes);
        int data;
        while (-1 != (data = inputStream.read())) {
            System.out.print((char)data);
        }

        System.out.println();

        // 输出流写入数组
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write("Hello world!".getBytes(StandardCharsets.UTF_8));
        byte[] writeBytes = outputStream.toByteArray();
        for (byte writeByte : writeBytes) {
            System.out.print((char)writeByte);
        }
    }
}
