package com.zhchen.spi.activate;

import org.apache.dubbo.common.extension.Activate;

@Activate(group = {"default_group"})
public class ActivateExt1Impl implements ActivateExt {

    @Override
    public String echo(String msg) {
        return msg;
    }
}
