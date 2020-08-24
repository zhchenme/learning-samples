package com.zhchen.io.character;

import java.io.FileReader;
import java.io.PushbackReader;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/24
 */
public class PushbackReaderSamples {

    public static void main(String[] args) throws Exception {

        // 可以用于解析文件，根据读到的前缀作类型区分，从而走不通的处理逻辑
        PushbackReader reader = new PushbackReader(new FileReader("/Users/zhangchen/document/Nginx 知识点梳理.md"), 1024);
        int data;
        while (-1 != (data = reader.read())) {
            System.out.print((char)data);
        }
        System.out.println();
        reader.unread(new char[]{'H', 'e'/*, 'l', 'l', 'o'*/});
        System.out.print((char)reader.read());
        System.out.print((char)reader.read());
        System.out.print((char)reader.read());


    }

}
