package com.zhchen.spi.activate;

import org.apache.dubbo.common.extension.Activate;

@Activate(value = {"value1"}, group = {"value"})
public class ValueActivateExtImpl implements ActivateExt {

    @Override
    public String echo(String msg) {
        return msg;
    }

}
