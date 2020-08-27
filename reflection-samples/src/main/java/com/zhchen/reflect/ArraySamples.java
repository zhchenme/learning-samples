package com.zhchen.reflect;

import java.lang.reflect.Array;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/27
 */
public class ArraySamples {

    public static void main(String[] args) throws ClassNotFoundException {

        samples1();
        samples2();
    }

    private static void samples2() throws ClassNotFoundException {
        // Class<String[]> stringArrayClass = String[].class;
        Class<?> stringArrayClass = Class.forName("[Ljava.lang.String;");
        System.out.println(stringArrayClass.getTypeName());
        Class<?> intArray = Class.forName("[I");
        System.out.println(intArray.getTypeName());
    }

    private static void samples1() {
        int[] intArray = (int[]) Array.newInstance(int.class, 3);
        Array.set(intArray, 0, 123);
        Array.set(intArray, 1, 456);
        Array.set(intArray, 2, 789);
        System.out.println("intArray[0] = " + Array.get(intArray, 0));
        System.out.println("intArray[1] = " + Array.get(intArray, 1));
        System.out.println("intArray[2] = " + Array.get(intArray, 2));
    }


}
