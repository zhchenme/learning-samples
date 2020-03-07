package com.jas.mess.bean;

import org.springframework.beans.factory.SmartInitializingSingleton;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/03/07
 */
public class SmartInitializingSingletonLogger implements SmartInitializingSingleton {
    public void afterSingletonsInstantiated() {
        System.out.println("singleton created");
    }
}
