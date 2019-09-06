package com.jas.ioc.context;

import com.jas.ioc.beans.factory.AbstractBeanFactory;
import com.jas.ioc.beans.factory.AutowireCapableBeanFactory;
import com.jas.ioc.beans.io.ResourceLoader;
import com.jas.ioc.beans.xml.XmlBeanDefinitionReader;

/**
 * ClassPathXmlApplicationContext
 *
 * @author lanxiang
 * @since 2019-07-24
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext{

    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        this(configLocation, new AutowireCapableBeanFactory());
    }

    public ClassPathXmlApplicationContext(String configLocation, AbstractBeanFactory beanFactory) throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    @Override
    public void refresh() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
        xmlBeanDefinitionReader.getRegistry().forEach((key, value) -> beanFactory.registerBeanDefinition(key, value));
    }
}
