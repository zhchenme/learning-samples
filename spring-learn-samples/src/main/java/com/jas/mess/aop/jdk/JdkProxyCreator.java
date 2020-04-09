package com.jas.mess.aop.jdk;

import com.jas.mess.aop.ProxyCreator;
import com.jas.mess.aop.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/04/09
 */
public class JdkProxyCreator implements ProxyCreator, InvocationHandler {

    private Object proxyTarget;

    public JdkProxyCreator(UserService proxyTarget) {
        this.proxyTarget = proxyTarget;
    }

    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(proxyTarget.getClass().getClassLoader(), proxyTarget.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("sayHello")) {
            System.out.println("record log");
        }
        return method.invoke(proxyTarget, args);
    }

}
