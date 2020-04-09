package com.jas.mess.aop.cglib;

import com.jas.mess.aop.ProxyCreator;
import com.jas.mess.aop.UserService;
import com.jas.mess.aop.UserServiceImpl;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/04/09
 */
public class MainTest {
    public static void main(String[] args) {
        ProxyCreator proxyCreator = new CglibProxyCreator(new UserServiceImpl(), new UserServiceMethodInterceptor());
        UserService proxy = (UserService) proxyCreator.getProxy();
        proxy.sayHello();
    }
}
