package com.zhchen.io.stream;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/18
 */
public class BufferedInputStreamSamples {

    public static void main(String[] args) throws Exception {

        /**
         * BufferedInputStream 缓存默认大小 8kb
         * 具体缓存大小可以根据硬件信息进行配置，比如硬盘一次读取 4kb 数据，那缓存大小应该大于 4kb
         * 设置的缓存大小最好是 4kb 的倍数，因为硬盘擅长顺序读取数据，这意味着对相邻的数据块也有较强的读取能力
         */
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("/Users/zhangchen/document/Nginx 知识点梳理.md"));
        BufferedReader br = new BufferedReader(new InputStreamReader(bis));

        int read = bis.read();
        System.out.println(read);

        read = bis.read();
        System.out.println(read);

    }

}
