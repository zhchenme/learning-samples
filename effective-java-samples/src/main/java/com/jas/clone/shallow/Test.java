package com.jas.clone.shallow;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/03/20
 */
public class Test {

    public static void main(String[] args) {

        ShallowCloneDemo demo = new ShallowCloneDemo();
        demo.setConstant(1);
        Entity entity = new Entity();
        entity.setStr("Hello World");
        demo.setEntity(entity);

        // 引用类型指向同一个内存地址，因此是同一个对象，基本数据类型拷贝的是字面量的值
        ShallowCloneDemo cloneDemo = (ShallowCloneDemo) demo.clone();

        System.out.println("cloneDemo == demo：" + (cloneDemo == demo));
        System.out.println("cloneDemo.getConstant() == demo.getConstant()：" + (cloneDemo.getConstant() == demo.getConstant()));
        System.out.println("cloneDemo.getEntity() == demo.getEntity()：" + (cloneDemo.getEntity() == demo.getEntity()));

        demo.setConstant(2);
        System.out.println("demo.getConstant()：" + demo.getConstant());
        System.out.println("cloneDemo.getConstant()：" + cloneDemo.getConstant());

        demo.getEntity().setStr("hello world");
        System.out.println("demo.getEntity().getStr()：" + demo.getEntity().getStr());
        System.out.println("demo.getEntity().getStr()：" + cloneDemo.getEntity().getStr());

    }
}
