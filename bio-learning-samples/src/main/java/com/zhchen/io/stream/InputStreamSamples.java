package com.zhchen.io.stream;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/17
 */
public class InputStreamSamples {

    public static void main(String[] args) throws Exception {
        // inputStreamDemo1();
        inputStreamDemo2();
    }

    private static void inputStreamDemo2() throws Exception {
        // InputStream to Reader
        try (InputStream is = new FileInputStream("/Users/zhangchen/document/Nginx 知识点梳理.md");
             Reader reader = new InputStreamReader(is)) {
            char[] chars = new char[1024];
            int data;
            while (-1 != (data = reader.read(chars))) {
                System.out.println(new String(chars, 0, data));
            }
        }
    }

    /**
     * 一个中文汉字一般占 3 个字节，如果采用固定数组大小方式读取中文，可能会将一个中文分两次读取，出现乱码
     */
    private static void inputStreamDemo1() throws Exception {
        try (InputStream is = new FileInputStream("/Users/zhangchen/document/Nginx 知识点梳理.md")) {
            byte[] bytes = new byte[1024];
            int data;
            while (-1 != (data = is.read(bytes))) {
                System.out.println(new String(bytes, 0, data));
            }
        }
    }
}
