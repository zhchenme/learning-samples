package com.zhchen.io.character;

import java.io.CharArrayReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/24
 */
public class StringReaderSamples {

    public static void main(String[] args) throws IOException {

        samples1();
        samples2();
    }

    private static void samples2() {
        CharArrayReader car = new CharArrayReader(new char[]{'H'});
    }

    private static void samples1() throws IOException {
        String s = "Hello world";
        StringReader sr = new StringReader(s);
        int data;
        while (-1 != (data = sr.read())) {
            System.out.print((char)data);
        }
        sr.close();
    }
}
