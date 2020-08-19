package com.zhchen.io.stream;

import java.io.*;
import java.util.Vector;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/19
 */
public class SequenceInputStreamSamples {

    public static void main(String[] args) throws Exception {

        Vector<FileInputStream> vector = new Vector<>();
        vector.add(new FileInputStream("/Users/zhangchen/document/Nginx 知识点梳理.md"));
        vector.add(new FileInputStream("/Users/zhangchen/document/Nginx 知识点梳理.md"));
        // Combining More Than Two InputStreams
        SequenceInputStream sip = new SequenceInputStream(vector.elements());
        String data;
        BufferedReader br = new BufferedReader(new InputStreamReader(sip));
        while (null != (data = br.readLine())) {
            System.out.println(data);
        }
        sip.close();
        br.close();
    }

}
