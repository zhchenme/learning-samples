package com.zhchen.rpc.demo;

/**
 * @from https://www.iteye.com/blog/javatar-1123915
 *
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/12/07
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {
        return "Hello" + name;
    }

}