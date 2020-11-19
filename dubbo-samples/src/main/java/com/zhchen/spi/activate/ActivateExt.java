package com.zhchen.spi.activate;

import org.apache.dubbo.common.extension.SPI;

@SPI
public interface ActivateExt {

    String echo(String msg);

}