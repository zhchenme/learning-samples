package com.jas.mess.aop.jdk;

import com.jas.mess.aop.UserService;

import java.lang.reflect.Proxy;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/03/28
 */
public class OwnerProxy {

    public static UserService proxy(UserService userService) {
        return (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), new OwnerInvocationHandler(userService));
    }

}
