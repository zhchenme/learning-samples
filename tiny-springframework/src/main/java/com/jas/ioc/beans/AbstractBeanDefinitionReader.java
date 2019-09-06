package com.jas.ioc.beans;

import com.jas.ioc.beans.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * AbstractBeanDefinitionReader
 *
 * @author lanxiang
 * @since 2019-07-23
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{

    private Map<String, BeanDefinition> registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.registry = new HashMap<>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
