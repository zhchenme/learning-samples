package com.zhchen.reflect;

import com.zhchen.reflect.bean.User;

import java.lang.reflect.Method;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/26
 */
public class MethodsSamples {

    public static void main(String[] args) throws Exception {

        Class<User> userClass = User.class;
        Method[] declaredMethods = userClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            // System.out.println(declaredMethod.getReturnType());
            // System.out.println(declaredMethod.getName());
            if (declaredMethod.getParameterCount() ==0 && "sayHi".equals(declaredMethod.getName())) {
                declaredMethod.invoke(userClass.newInstance(), null);
            }
        }

        Method sayHiWithNameMethod = userClass.getDeclaredMethod("sayHi", String.class);
        sayHiWithNameMethod.setAccessible(true);
        // 如果 invoke 的是 static 方法，第一个参数可为 null
        sayHiWithNameMethod.invoke(userClass.newInstance(), " lanxiang");
    }

}
