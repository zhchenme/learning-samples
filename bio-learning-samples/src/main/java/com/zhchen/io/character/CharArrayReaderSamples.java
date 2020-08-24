package com.zhchen.io.character;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/21
 */
public class CharArrayReaderSamples {

    public static void main(String[] args) throws IOException {
        char[] chars = {'哈', 'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'};
        Reader reader = new BufferedReader(new CharArrayReader(chars));
        reader.skip(1);
        int data;
        while (-1 != (data = reader.read())) {
            System.out.print((char)data);
        }
        reader.close();
    }

}
