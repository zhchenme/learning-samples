package com.zhchen.io.character;

import java.io.IOException;
import java.io.StringWriter;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/24
 */
public class StringWriterSamples {

    public static void main(String[] args) throws IOException {

        StringWriter sw = new StringWriter();
        sw.write("Hello world");
        System.out.println(sw.toString());
        StringBuffer buffer = sw.getBuffer();
        System.out.println(buffer.toString());
        sw.close();
    }

}
