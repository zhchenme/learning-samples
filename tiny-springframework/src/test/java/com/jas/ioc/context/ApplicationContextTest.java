package com.jas.ioc.context;

import com.jas.ioc.HelloWorldService;
import org.junit.Test;

/**
 * ApplicationContext
 *
 * @author lanxiang
 * @since 2019-07-29
 */
public class ApplicationContextTest {

    @Test
    public void test() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }

}
