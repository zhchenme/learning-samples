package com.zhchen.io.character;

import java.io.PrintWriter;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/24
 */
public class PrintWriterSamples {

    public static void main(String[] args) {

        PrintWriter pw = new PrintWriter(System.out);
        pw.write("Hello");
        pw.write(" world\n");
        pw.write("你好");
        pw.close();
    }

}
