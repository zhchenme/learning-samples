package com.jas.mess.aop.cglib;

import com.jas.mess.aop.ProxyCreator;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/04/09
 */
public class CglibProxyCreator implements ProxyCreator {

    private Object proxyTarget;

    private MethodInterceptor methodInterceptor;

    public CglibProxyCreator(Object proxyTarget, MethodInterceptor methodInterceptor) {
        this.proxyTarget = proxyTarget;
        this.methodInterceptor = methodInterceptor;
    }

    @Override
    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(proxyTarget.getClass());
        enhancer.setCallback(methodInterceptor);
        return enhancer.create();
    }
}
