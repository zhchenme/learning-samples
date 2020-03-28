package com.jas.mess.aop.jdk;

import com.jas.mess.aop.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/03/28
 */
public class OwnerInvocationHandler implements InvocationHandler {


    private UserService userService;

    public OwnerInvocationHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("record log");
        return method.invoke(userService, args);
    }
}
