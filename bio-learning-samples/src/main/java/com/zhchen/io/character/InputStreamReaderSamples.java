package com.zhchen.io.character;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/20
 */
public class InputStreamReaderSamples {

    public static void main(String[] args) throws Exception {

        InputStream is = new FileInputStream("/Users/zhangchen/document/Nginx 知识点梳理.md");
        InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        String data;
        while (null != (data = br.readLine())) {
            System.out.println(data);
        }
        is.close();
        isr.close();
        br.close();
    }

}
