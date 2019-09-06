package com.jas.mess.lookup.method;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * NewsPublisherAware
 *
 * @author lanxiang
 * @since 2019-08-23
 */
public class NewsPublisherAware implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    /**
     * 每次从容器中获取的都是一个新的 bean
     */
    public News getNews() {
        return applicationContext.getBean("news", News.class);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
