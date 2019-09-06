package com.jas.ioc.beans;

import lombok.Data;

/**
 * BeanReference
 *
 * @author lanxiang
 * @since 2019-07-24
 */
@Data
public class BeanReference {

    private String name;

    private Object bean;

    public BeanReference() {}

    public BeanReference(String name) {
        this.name = name;
    }
}
