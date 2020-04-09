package com.jas.mess.aop.jdk;

import com.jas.mess.aop.UserService;
import com.jas.mess.aop.UserServiceImpl;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/03/28
 */
public class MainTest {

    public static void main(String[] args) {
        JdkProxyCreator jdkProxyCreator = new JdkProxyCreator(new UserServiceImpl());
        UserService proxy = (UserService) jdkProxyCreator.getProxy();
        proxy.sayHello();
    }

}
