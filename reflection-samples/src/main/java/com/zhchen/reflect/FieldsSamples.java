package com.zhchen.reflect;

import com.zhchen.reflect.bean.User;

import java.lang.reflect.Field;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/26
 */
public class FieldsSamples {

    public static void main(String[] args) throws Exception {

        Class<User> userClass = User.class;
        Field[] fields = userClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            User user = userClass.newInstance();
            // get field value by user object
            System.out.println(field.get(user));
            // set field value by user object
            field.set(user, "zhchen");
            System.out.println(field.get(user));
            // System.out.println(user.getName());
        }
    }

}
