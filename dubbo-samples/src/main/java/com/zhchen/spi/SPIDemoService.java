package com.zhchen.spi;

import org.apache.dubbo.common.extension.SPI;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/11/19
 */
@SPI
public interface SPIDemoService {

    void sayHello();
}
