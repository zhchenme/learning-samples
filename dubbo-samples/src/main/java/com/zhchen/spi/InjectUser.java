package com.zhchen.spi;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/11/20
 */
@SPI(value = "injectUser")
public interface InjectUser {

    @Adaptive
    void test(URL url);
}
