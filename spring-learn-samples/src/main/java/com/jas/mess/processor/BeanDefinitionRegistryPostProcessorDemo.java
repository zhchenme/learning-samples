package com.jas.mess.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/03/06
 */
public class BeanDefinitionRegistryPostProcessorDemo implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        // 获取所有 beanDefinitionNames
        String[] beanDefinitionNames = registry.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            // 根据 beanDefinitionName 获取到 beanDefinition
            BeanDefinition beanDefinition = registry.getBeanDefinition(beanDefinitionName);
            System.out.println(beanDefinitionName + " is singleton:" + beanDefinition.isSingleton());
        }
        System.out.println("------------BeanDefinitionRegistryPostProcessor start-------------");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("------------BeanDefinitionRegistryPostProcessor end-------------");
    }
}
