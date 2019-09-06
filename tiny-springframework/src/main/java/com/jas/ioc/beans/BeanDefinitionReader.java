package com.jas.ioc.beans;
/**
 * BeanDefinitionReader
 *
 * @author lanxiang
 * @since 2019-07-19
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws Exception;
}
