package com.zhchen.io.file;

import java.io.File;
import java.util.Arrays;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/17
 */
public class FileSamples {

    public static void main(String[] args) {

        loopPrintFile(new File("/Users/zhangchen/workspace"));
    }

    private static void loopPrintFile(File file) {
        if (!file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (null != files) {
                Arrays.stream(files).forEach(FileSamples::loopPrintFile);
            }
        } else {
            System.out.println(file.getAbsolutePath());
        }
    }
}
