package com.jas.mess.aop.jdk;

import com.jas.mess.aop.UserService;
import com.jas.mess.aop.UserServiceImpl;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/03/28
 */
public class MainTest {

    public static void main(String[] args) {
        UserService proxy = OwnerProxy.proxy(new UserServiceImpl());
        proxy.sayHello();
    }

}
