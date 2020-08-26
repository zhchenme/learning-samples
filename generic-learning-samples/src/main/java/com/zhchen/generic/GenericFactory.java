package com.zhchen.generic;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/25
 */
public class GenericFactory<T> {

    private final Class<T> instanceClass;

    public GenericFactory(Class<T> instanceClass) {
        this.instanceClass = instanceClass;
    }

    public T createInstance() throws IllegalAccessException, InstantiationException {
        return instanceClass.newInstance();
    }
}
