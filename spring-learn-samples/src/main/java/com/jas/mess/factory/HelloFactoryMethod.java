package com.jas.mess.factory;

import com.jas.mess.bean.User;

/**
 * HelloFactoryMethod
 *
 * @author lanxiang
 * @since 2019-08-23
 */
public class HelloFactoryMethod {

    public static User getUser() {
        return User.builder()
                .name("jas")
                .build();
    }
}
