package com.jas.ioc.beans.factory;

import com.jas.ioc.beans.BeanDefinition;
import com.jas.ioc.beans.BeanReference;
import com.jas.ioc.beans.PropertyValue;

import java.lang.reflect.Field;

/**
 * AutowireCapableBeanFactory
 *
 * @author lanxiang
 * @since 2019-07-18
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        beanDefinition.setBean(bean);
        this.applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

    /**
     * 为 bean 实例填充属性值
     *
     * @param bean bean
     * @param mbd  beanDefinition
     */
    protected void applyPropertyValues(Object bean, BeanDefinition mbd) {
        mbd.getPropertyValues().getPropertyValues().forEach(propertyValue -> {
            try {
                Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
                declaredField.setAccessible(true);
                Object value = propertyValue.getValue();
                // TODO 循环依赖，缓存？
                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = super.getBean(beanReference.getName());
                }
                declaredField.set(bean, value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
