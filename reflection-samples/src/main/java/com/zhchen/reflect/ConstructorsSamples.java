package com.zhchen.reflect;

import com.zhchen.reflect.bean.User;

import java.lang.reflect.Constructor;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/26
 */
public class ConstructorsSamples {

    public static void main(String[] args) throws Exception {

        Constructor<?>[] constructors = User.class.getConstructors();
        for (Constructor<?> constructor : constructors) {
            User user;
            if (0 == constructor.getParameterCount()) {
                user = (User) constructor.newInstance();
            } else {
                user = (User) constructor.newInstance("zhchen");
            }
            System.out.println(user.getName());
        }
    }
}
