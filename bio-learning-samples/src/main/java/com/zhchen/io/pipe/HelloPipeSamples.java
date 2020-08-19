package com.zhchen.io.pipe;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/14
 */
public class HelloPipeSamples {

    public static void main(String[] args) throws IOException {

        /**
         * Java piped 必须在同一个进程不同线程中使用
         * bio 的 read() 与 write() 方法是阻塞的，如果在统一线程中执行会造成线程死锁
         */
        PipedOutputStream outputStream = new PipedOutputStream();
        PipedInputStream inputStream = new PipedInputStream(outputStream);
        new Thread(() -> {
            try {
                outputStream.write("Hello world, pipe!".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            int data;
            try {
                while (-1 != (data = inputStream.read())) {
                    System.out.print((char) data);
                }
            } catch (IOException ignored) {
            }
        }).start();
    }

}
