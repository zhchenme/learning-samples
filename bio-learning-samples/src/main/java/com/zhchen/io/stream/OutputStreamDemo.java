package com.zhchen.io.stream;

import java.io.*;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/17
 */
public class OutputStreamDemo {

    public static final String OVER = "over";

    public static void main(String[] args) throws Exception {

        outputStreamDemo1();
    }

    private static void outputStreamDemo2() throws Exception {
        // OutputStream to Writer
        OutputStream os = new FileOutputStream("");
        Writer writer = new OutputStreamWriter(os);
    }

    public static void outputStreamDemo1() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        OutputStream os = new FileOutputStream("/Users/zhangchen/document/test.md");
        String str;
        while (!OVER.equals(str = reader.readLine())) {
            os.write(str.getBytes());
            os.flush();
        }
        reader.close();
        os.close();
    }
}
