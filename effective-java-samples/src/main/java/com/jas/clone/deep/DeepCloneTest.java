package com.jas.clone.deep;

import com.jas.clone.shallow.Entity;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/03/23
 */
public class DeepCloneTest {

    public static void main(String[] args) {
        clone1();
        clone2();
    }

    public static void clone1() {
        DeepCloneDemo1 demo = new DeepCloneDemo1();
        demo.setConstant(1);
        Entity1 entity1 = new Entity1();
        entity1.setStr("Hello World");
        demo.setEntity1(entity1);

        // 引用类型指向同一个内存地址，因此是同一个对象，基本数据类型拷贝的是字面量的值
        DeepCloneDemo1 cloneDemo = (DeepCloneDemo1) demo.clone();

        System.out.println("cloneDemo == demo：" + (cloneDemo == demo));
        System.out.println("cloneDemo.getConstant() == demo.getConstant()：" + (cloneDemo.getConstant() == demo.getConstant()));
        System.out.println("cloneDemo.getEntity() == demo.getEntity()：" + (cloneDemo.getEntity1() == demo.getEntity1()));

        demo.setConstant(2);
        System.out.println("demo.getConstant()：" + demo.getConstant());
        System.out.println("cloneDemo.getConstant()：" + cloneDemo.getConstant());

        demo.getEntity1().setStr("hello world");
        System.out.println("demo.getEntity().getStr()：" + demo.getEntity1().getStr());
        System.out.println("demo.getEntity().getStr()：" + cloneDemo.getEntity1().getStr());
    }

    public static void clone2() {
        DeepCloneDemo2 demo = new DeepCloneDemo2();
        demo.setConstant(1);
        Entity2 entity2 = new Entity2();
        entity2.setStr("Hello World");
        demo.setEntity2(entity2);

        // 引用类型指向同一个内存地址，因此是同一个对象，基本数据类型拷贝的是字面量的值
        DeepCloneDemo2 cloneDemo = demo.deepCopy();

        System.out.println("cloneDemo == demo：" + (cloneDemo == demo));
        System.out.println("cloneDemo.getConstant() == demo.getConstant()：" + (cloneDemo.getConstant() == demo.getConstant()));
        System.out.println("cloneDemo.getEntity() == demo.getEntity()：" + (cloneDemo.getEntity2() == demo.getEntity2()));

        demo.setConstant(2);
        System.out.println("demo.getConstant()：" + demo.getConstant());
        System.out.println("cloneDemo.getConstant()：" + cloneDemo.getConstant());

        demo.getEntity2().setStr("hello world");
        System.out.println("demo.getEntity().getStr()：" + demo.getEntity2().getStr());
        System.out.println("demo.getEntity().getStr()：" + cloneDemo.getEntity2().getStr());
    }
}
