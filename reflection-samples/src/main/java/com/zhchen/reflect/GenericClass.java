package com.zhchen.reflect;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/27
 */
public class GenericClass<GT1> {

    private GT1 param1;

    public GT1 getParam1() {
        return param1;
    }

    public void setParam1(GT1 param1) {
        this.param1 = param1;
    }

    public static void main(String[] args) {
        GenericClassTest test = new GenericClassTest();
        System.out.println(test.getParam1());
    }

}

class GenericClassTest extends GenericClass<Double> {
    @Override
    public Double getParam1() {
        System.out.println(super.getParam1());
        return super.getParam1();
    }
}