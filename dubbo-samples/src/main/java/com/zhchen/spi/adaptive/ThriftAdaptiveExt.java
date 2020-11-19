package com.zhchen.spi.adaptive;

import org.apache.dubbo.common.URL;

public class ThriftAdaptiveExt implements AdaptiveExt {

    @Override
    public String echo(String msg, URL url) {
        return "thrift";
    }
}