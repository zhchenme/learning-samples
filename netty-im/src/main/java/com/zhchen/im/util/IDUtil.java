package com.zhchen.im.util;

import java.util.UUID;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/11/11
 */
public class IDUtil {

    private IDUtil() {
    }

    public static String randomId() {
        return UUID.randomUUID().toString().split("-")[0];
    }
}