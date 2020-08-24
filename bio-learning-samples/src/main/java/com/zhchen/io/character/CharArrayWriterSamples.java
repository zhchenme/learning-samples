package com.zhchen.io.character;

import java.io.CharArrayWriter;
import java.io.IOException;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/21
 */
public class CharArrayWriterSamples {

    public static void main(String[] args) throws IOException {

        CharArrayWriter car = new CharArrayWriter();
        car.write("哈Hello world");
        char[] chars = car.toCharArray();
        for (char aChar : chars) {
            System.out.print(aChar);
        }
        System.out.println();
        car.write("啊哦");
        chars = car.toCharArray();
        for (char aChar : chars) {
            System.out.print(aChar);
        }
        car.close();
    }

}
