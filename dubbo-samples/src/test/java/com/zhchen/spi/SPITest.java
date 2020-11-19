package com.zhchen.spi;

import com.zhchen.spi.activate.ActivateExt;
import com.zhchen.spi.adaptive.AdaptiveExt;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/11/19
 */
public class SPITest {

    @Test
    public void spiTest() {
        ExtensionLoader<SPIDemoService> loader = ExtensionLoader.getExtensionLoader(SPIDemoService.class);
        SPIDemoService spiDemoService = loader.getExtension("spi");
        spiDemoService.sayHello();
    }

    @Test
    public void adaptiveSPITest() {
        /**
         * 例子来源：https://www.jianshu.com/p/dc616814ce98
         * 编译后的类文件
         * @see com.zhchen.spi.adaptive.AdaptiveExt$Adaptive
         */
        ExtensionLoader<AdaptiveExt> loader = ExtensionLoader.getExtensionLoader(AdaptiveExt.class);
        AdaptiveExt adaptiveExtension = loader.getAdaptiveExtension();
        URL url = URL.valueOf("test://localhost/adaptive.ext?test=thrift");
        url.getParameter("");
        System.out.println(adaptiveExtension.echo("d", url));
    }

    @Test
    public void activateDefaultGroupTest() {
        ExtensionLoader<ActivateExt> loader = ExtensionLoader.getExtensionLoader(ActivateExt.class);
        URL url = URL.valueOf("test://localhost/test");
        // 查询组为 default_group 的 ActivateExt 的实现
        List<ActivateExt> list = loader.getActivateExtension(url, new String[]{}, "default_group");
        System.out.println(list.size());
        System.out.println(list.get(0).getClass());
    }

    @Test
    public void activateGroup2Test() {
        URL url = URL.valueOf("test://localhost/test");
        // 查询组为 group2 的 ActivateExt 的实现
        List<ActivateExt> list = ExtensionLoader.getExtensionLoader(ActivateExt.class).getActivateExtension(url, new String[]{}, "group2");
        System.out.println(list.size());
        System.out.println(list.get(0).getClass());
    }

    @Test
    public void activateGroupValueTest() {
        URL url = URL.valueOf("test://localhost/test");
        // 根据   key = value1，group = value 进行激活
        // @Activate(value = {"value1"}, group = {"value"})
        url = url.addParameter("value1", "value");
        List<ActivateExt> list = ExtensionLoader.getExtensionLoader(ActivateExt.class).getActivateExtension(url, new String[]{}, "value");
        System.out.println(list.size());
        System.out.println(list.get(0).getClass());
    }

    @Test
    public void activateGroupOrderTest() {
        URL url = URL.valueOf("test://localhost/test");
        List<ActivateExt> list = ExtensionLoader.getExtensionLoader(ActivateExt.class).getActivateExtension(url, new String[]{"value"}, "order");
        System.out.println(list.size());
        System.out.println(list.get(0).getClass());
        System.out.println(list.get(1).getClass());
    }
}
