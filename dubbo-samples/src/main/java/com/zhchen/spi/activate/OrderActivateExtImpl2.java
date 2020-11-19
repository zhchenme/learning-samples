package com.zhchen.spi.activate;

import org.apache.dubbo.common.extension.Activate;

@Activate(order = 1, group = {"order"})
public class OrderActivateExtImpl2 implements ActivateExt {

    @Override
    public String echo(String msg) {
        return msg;
    }
}