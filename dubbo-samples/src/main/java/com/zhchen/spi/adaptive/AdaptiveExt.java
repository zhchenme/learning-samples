package com.zhchen.spi.adaptive;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

@SPI(value = "dubbo")
public interface AdaptiveExt {

    @Adaptive
    String echo(String msg, URL url);
}
