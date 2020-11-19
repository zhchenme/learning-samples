package com.zhchen.spi.adaptive;

import org.apache.dubbo.common.URL;

public class DubboAdaptiveExt implements AdaptiveExt {

    @Override
    public String echo(String msg, URL url) {
        return "dubbo";
    }
}