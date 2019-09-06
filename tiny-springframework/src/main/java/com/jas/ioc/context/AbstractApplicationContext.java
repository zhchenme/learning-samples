package com.jas.ioc.context;

import com.jas.ioc.beans.factory.AbstractBeanFactory;

/**
 * AbstractApplicationContext
 *
 * @author lanxiang
 * @since 2019-07-24
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void refresh() throws Exception {}

    @Override
    public Object getBean(String beanName) throws Exception {
        return beanFactory.getBean(beanName);
    }
}
