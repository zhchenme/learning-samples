package com.jas.ioc.beans.factory;

/**
 * BeanFactory
 *
 * @author lanxiang
 * @since 2019-07-18
 */
public interface BeanFactory {

    Object getBean(String beanName) throws Exception;
}
