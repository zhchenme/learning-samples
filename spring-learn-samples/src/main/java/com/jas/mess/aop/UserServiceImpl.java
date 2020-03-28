package com.jas.mess.aop;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/03/28
 */
public class UserServiceImpl implements UserService {

    @Override
    public void sayHello() {
            System.out.println("hello world");
    }
}
