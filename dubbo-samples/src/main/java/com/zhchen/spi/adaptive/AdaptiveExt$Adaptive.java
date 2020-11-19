package com.zhchen.spi.adaptive;

import org.apache.dubbo.common.extension.ExtensionLoader;

public class AdaptiveExt$Adaptive implements com.zhchen.spi.adaptive.AdaptiveExt {
    @Override
    public java.lang.String echo(java.lang.String arg0, org.apache.dubbo.common.URL arg1) {
        if (arg1 == null) throw new IllegalArgumentException("url == null");
        org.apache.dubbo.common.URL url = arg1;
        String extName = url.getParameter("param", "dubbo");
        if (extName == null)
            throw new IllegalStateException("Failed to get extension (com.zhchen.spi.adaptive.AdaptiveExt) name from url (" + url.toString() + ") use keys([param])");
        com.zhchen.spi.adaptive.AdaptiveExt extension = (com.zhchen.spi.adaptive.AdaptiveExt) ExtensionLoader.getExtensionLoader(com.zhchen.spi.adaptive.AdaptiveExt.class).getExtension(extName);
        return extension.echo(arg0, arg1);
    }
}