package com.jas.mess.test;

import com.jas.mess.aop.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/03/28
 */
public class AopTest {
    private static final String configLocation = "applicationContext.xml";

    @Test
    public void aopTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
        UserService bean = applicationContext.getBean("userServiceImpl", UserService.class);
        bean.sayHello();
    }
}
