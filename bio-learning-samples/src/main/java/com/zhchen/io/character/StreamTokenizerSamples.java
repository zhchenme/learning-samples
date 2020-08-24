package com.zhchen.io.character;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/24
 * @see https://doc.yonyoucloud.com/doc/jdk6-api-zh/java/io/StreamTokenizer.html
 */
public class StreamTokenizerSamples {

    public static void main(String[] args) throws IOException {

        // 类似一个分词 API
        StreamTokenizer streamTokenizer = new StreamTokenizer(
                new StringReader("Mary had 1 little lamb..."));

        while(streamTokenizer.nextToken() != StreamTokenizer.TT_EOF){
            if(streamTokenizer.ttype == StreamTokenizer.TT_WORD) {
                System.out.println(streamTokenizer.sval);
            } else if(streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                System.out.println(streamTokenizer.nval);
            } else if(streamTokenizer.ttype == StreamTokenizer.TT_EOL) {
                System.out.println();
            }

        }
    }

}
