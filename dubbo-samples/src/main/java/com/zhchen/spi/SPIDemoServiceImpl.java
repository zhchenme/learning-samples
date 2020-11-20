package com.zhchen.spi;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/11/19
 */
public class SPIDemoServiceImpl implements SPIDemoService {

    @Override
    public void sayHello() {
        System.out.println("Hello world");
    }

    @Override
    public void setInjectUser(InjectUser injectUser) {
        System.out.println("injectUser = " + injectUser);
    }
}
