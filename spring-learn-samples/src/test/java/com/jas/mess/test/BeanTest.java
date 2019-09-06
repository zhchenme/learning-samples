package com.jas.mess.test;

import com.jas.mess.bean.User;
import com.jas.mess.factory.UserFactoryBean;
import com.jas.mess.lookup.method.NewsPublisher;
import com.jas.mess.lookup.method.NewsPublisherAware;
import org.junit.Test;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * BeanTest
 *
 * @author lanxiang
 * @since 2019-08-22
 */
public class BeanTest {

    private static final String configLocation = "applicationContext.xml";

    @Test
    public void aliasTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
        System.out.println("alias-user1 -> " + applicationContext.getBean("user1"));
        System.out.println("alias-user2 -> " + applicationContext.getBean("user2"));
    }

    @Test
    public void autowireTest() {
        User user = new ClassPathXmlApplicationContext(configLocation).getBean("user", User.class);
        System.out.println("autowire test ->" + user.getDept().getDeptName());
    }

    @Test
    public void factoryBeanTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
        System.out.println("userFactoryBean.getName ->" + applicationContext.getBean("userFactoryBean", User.class).getName());
        // & 可以用于获取 FactoryBean 本身
        UserFactoryBean userFactoryBean = applicationContext.getBean("&userFactoryBean", UserFactoryBean.class);
        System.out.println(userFactoryBean instanceof FactoryBean);
        System.out.println("&userFactoryBean -> " + userFactoryBean);
        System.out.println("userFactoryBean objectType ->" + userFactoryBean.getObjectType());
    }

    @Test
    public void helloFactoryMethodTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
        System.out.println("static factory method -> " + applicationContext.getBean("helloFactoryMethod", User.class).getName());
    }

    /**
     * 我们有一个新闻提供类（NewsProvider），这个类中有一个新闻类（News）成员变量。我们每次调用 getNews 方法都想获取一条新的新闻。
     * <p>
     * 有两种方式实现这个需求：
     * 一种方式是让 NewsProvider 类实现 ApplicationContextAware 接口（实现 BeanFactoryAware 接口也是可以的），每次调用 NewsProvider 的 getNews 方法时，
     * 都从 ApplicationContext 中获取一个新的 News 实例，返回给调用者。
     * 第二种方式就是这里的 lookup-method 了，Spring 会在运行时对 NewsProvider 进行增强，使其 getNews 可以每次都返回一个新的实例。
     */
    @Test
    public void lookupMethodTest1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
        NewsPublisher newsPublisher = applicationContext.getBean("newsPublisher", NewsPublisher.class);
        System.out.println(newsPublisher.getNews());
        System.out.println(newsPublisher.getNews());
    }

    @Test
    public void lookupMethodTest2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
        NewsPublisherAware newsPublisherAware = applicationContext.getBean("newsPublisherAware", NewsPublisherAware.class);
        System.out.println(newsPublisherAware.getNews());
        System.out.println(newsPublisherAware.getNews());
    }

    @Test
    public void dependsOnTest() {
//         depends-on="dept"
//         depends-on="user"
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
        System.out.println("depends-on -> " + applicationContext.getBean("user"));
    }
}
