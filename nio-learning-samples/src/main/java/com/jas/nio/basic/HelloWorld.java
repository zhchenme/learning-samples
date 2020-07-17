package com.jas.nio.basic;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/07/15
 */
public class HelloWorld {

    public static void main(String[] args) throws Exception {

        RandomAccessFile accessFile = new RandomAccessFile("/Users/zhangchen/dump.rdb", "rw");
        FileChannel fileChannel = accessFile.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        int read = fileChannel.read(byteBuffer);

        while ((read) != -1) {
            System.out.println("read = " + read);
            byteBuffer.flip();

            while (byteBuffer.hasRemaining()) {
                System.out.print((char) byteBuffer.get());
            }

            byteBuffer.clear();
            read = fileChannel.read(byteBuffer);
        }
        accessFile.close();
    }

}
