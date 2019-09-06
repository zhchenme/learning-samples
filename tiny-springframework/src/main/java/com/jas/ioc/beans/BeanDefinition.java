package com.jas.ioc.beans;

import lombok.Data;

/**
 * BeanDefinition
 *
 * @author lanxiang
 * @since 2019-07-18
 */
@Data
public class BeanDefinition {

    private Object bean;

    private Class beanClass;

    private String beanClassName;

    private PropertyValues propertyValues = new PropertyValues();

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
