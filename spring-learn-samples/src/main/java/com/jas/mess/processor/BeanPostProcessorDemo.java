package com.jas.mess.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * LoggerBeanPostProcessor
 *
 * @author lanxiang
 * @since 2019-08-23
 */
public class BeanPostProcessorDemo implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Before " + beanName + " Initialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("After " + beanName + " Initialization");
        return bean;
    }
}
