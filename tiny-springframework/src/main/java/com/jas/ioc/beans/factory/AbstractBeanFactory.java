package com.jas.ioc.beans.factory;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jas.ioc.beans.BeanDefinition;

import java.util.List;
import java.util.Map;

/**
 * AbstractBeanFactory
 *
 * @author lanxiang
 * @since 2019-07-18
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = Maps.newConcurrentMap();

    private final List<String> beanDefinitionNames = Lists.newArrayList();

    @Override
    public Object getBean(String beanName) throws Exception{
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (null == beanDefinition) {
            throw new IllegalArgumentException("No bean named " + beanName + " is defined");
        }
        Object bean = beanDefinition.getBean();
        if (null == bean) {
            bean = this.doCreateBean(beanDefinition);
        }
        return bean;
    }

    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
        beanDefinitionNames.add(beanName);
    }

    public void preInstantiateSingletons() throws Exception {
        for (String beanDefinitionName : beanDefinitionNames) {
            this.getBean(beanDefinitionName);
        }
    }

    /**
     * 创建 bean 填充属性
     *
     * @param beanDefinition beanDefinition
     * @return bean 实例
     * @throws Exception Exception
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
}
