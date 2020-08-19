package com.zhchen.io.stream;

import java.io.*;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/19
 */
public class DataInputStreamSamples {

    public static void main(String[] args) throws IOException {
        samples1();
    }

    private static void samples1() throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("/Users/zhangchen/document/test.md"));
        dataOutputStream.writeInt(123);
        dataOutputStream.writeFloat(123.45F);
        dataOutputStream.writeLong(789);
        dataOutputStream.writeLong(789);
        dataOutputStream.writeBoolean(true);
        dataOutputStream.close();
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("/Users/zhangchen/document/test.md"));
        int   int123     = dataInputStream.readInt();
        float float12345 = dataInputStream.readFloat();
        long  long789    = dataInputStream.readLong();
        dataInputStream.close();
        System.out.println("int123     = " + int123);
        System.out.println("float12345 = " + float12345);
        System.out.println("long789    = " + long789);
    }

}
