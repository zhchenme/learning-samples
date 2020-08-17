package com.zhchen.io.file;

import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/17
 */
public class RandomAccessFileDemo {

    public static void main(String[] args) throws Exception {

        RandomAccessFile raf = new RandomAccessFile("/Users/zhangchen/document/Nginx 知识点梳理.md", "rw");
        // getFilePointer() 获取文件偏移量，可以通过 seek() 方法进行设置
        System.out.println("offset = " + raf.getFilePointer());
        byte[] bytes = new byte[1024];
        int data;
        while (-1 != (data = raf.read(bytes))) {
            System.out.println(new String(bytes, 0, data));
        }
        System.out.println("offset = " + raf.getFilePointer());
        raf.write("\nHello World".getBytes(StandardCharsets.UTF_8));
        System.out.println("offset = " + raf.getFilePointer());
        raf.close();
    }

}
