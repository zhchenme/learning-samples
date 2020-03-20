package com.jas.mess.factory;

import com.jas.mess.bean.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * UserFactoryBean
 *
 * @author lanxiang
 * @since 2019-08-23
 */
public class UserFactoryBean implements FactoryBean<User> {

    @Override
    public User getObject() {
        return User.builder()
                .name("jas")
                .build();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
