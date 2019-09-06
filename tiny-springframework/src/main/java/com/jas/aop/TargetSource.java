package com.jas.aop;

import lombok.Data;

/**
 * TargetSource
 *
 * @author lanxiang
 * @since 2019-07-29
 */
@Data
public class TargetSource {

    private Class targetClass;

    private Object target;

    public TargetSource() {}

    public TargetSource(Object target, Class<?> targetClass) {
        this.target = target;
        this.targetClass = targetClass;
    }

}
