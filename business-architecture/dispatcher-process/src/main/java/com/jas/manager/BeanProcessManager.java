/*
 * Copyright (C) 2009-2019 Hangzhou FanDianEr Technology Co., Ltd. All rights reserved
 */
package com.jas.manager;

import com.google.common.collect.Lists;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * BeanProcessManager
 *
 * @author lanxiang
 * @since 2019-06-27
 */
@Component
public class BeanProcessManager implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    /**
     * 根据 name 获取 bean
     *
     * @param name beanName
     * @param <T> 泛型
     * @return bean
     */
    public<T> T getBean(String name) {
        return (T) applicationContext.getBean(name);
    }

    /**
     * 根据 class 获取 beanList
     *
     * @param clazz bean class 对象
     * @param <T> 泛型
     * @return beanList
     */
    public <T> List<T> getBeanList(Class<T> clazz) {
        Map<String, T> beanMap = applicationContext.getBeansOfType(clazz);
        return Lists.newArrayList(beanMap.values());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
