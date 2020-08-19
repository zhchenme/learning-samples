package com.zhchen.io.stream;

import java.io.PrintStream;
import java.util.Locale;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/19
 */
public class PrintStreamSamples {

    public static void main(String[] args) {

        PrintStream printStream = System.out;

        printStream.println(true);
        printStream.println(123);
        printStream.println((float) 123.456);
        printStream.printf(Locale.CHINA, "Text + data: %d$", 123);

        printStream.close();
    }

}
