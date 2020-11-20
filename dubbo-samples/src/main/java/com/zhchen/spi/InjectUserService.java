package com.zhchen.spi;

import org.apache.dubbo.common.URL;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/11/20
 */
public class InjectUserService implements InjectUser{
    @Override
    public void test(URL url) {
        System.out.println("hello inject user");
    }
}
