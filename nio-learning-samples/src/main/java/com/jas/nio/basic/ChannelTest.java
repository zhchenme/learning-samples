package com.jas.nio.basic;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/07/17
 */
public class ChannelTest {

    public static void main(String[] args) throws Exception {

        writeReadDemo();

        transferFile();
    }

    public static void transferFile() throws Exception {
        RandomAccessFile fromFile = new RandomAccessFile("/Users/zhangchen/aaa.text", "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("/Users/zhangchen/bbb.text", "rw");
        FileChannel toChannel = toFile.getChannel();

        fromChannel.transferTo(0, fromChannel.size(), toChannel);
        // toChannel.transferFrom(fromChannel, 0, fromChannel.size());

        fromChannel.close();
        fromFile.close();
        toChannel.close();
        toFile.close();
    }

    public static void writeReadDemo() throws Exception {
        RandomAccessFile file = new RandomAccessFile("/Users/zhangchen/aaa.text", "rw");
        FileChannel channel = file.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(48);

        Scanner scanner = new Scanner(System.in);

        String str;
        String overTag = "over";
        while (!overTag.equals(str = scanner.nextLine())) {
            buffer.put(str.getBytes());
            buffer.flip();
            channel.write(buffer);
            buffer.clear();
        }

        file = new RandomAccessFile("/Users/zhangchen/aaa.text", "rw");
        channel = file.getChannel();

        while (channel.read(buffer) != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }
            buffer.clear();
        }

        file.close();
        channel.close();
        scanner.close();
    }

}
