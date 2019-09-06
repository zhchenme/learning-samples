package com.jas.ioc.beans.xml;

import com.alibaba.fastjson.JSON;
import com.jas.ioc.beans.BeanDefinition;
import com.jas.ioc.beans.io.ResourceLoader;
import org.junit.Test;

import java.util.Map;

/**
 * XmlBeanDefinitionReaderTest
 *
 * @author lanxiang
 * @since 2019-07-27
 */
public class XmlBeanDefinitionReaderTest {

    @Test
    public void test() throws Exception {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        beanDefinitionReader.loadBeanDefinitions("tinyioc.xml");
        Map<String, BeanDefinition> registry = beanDefinitionReader.getRegistry();
        System.out.println(JSON.toJSON(registry));
    }
}
