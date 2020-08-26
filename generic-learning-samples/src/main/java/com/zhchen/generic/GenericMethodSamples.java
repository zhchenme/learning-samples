package com.zhchen.generic;

import java.util.List;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/25
 */
public class GenericMethodSamples {

    public static <T> T createInstance(Class<T> tClass) throws IllegalAccessException, InstantiationException {
        return tClass.newInstance();
    }

    /**
     * <N extends Number> 用来约束泛型的类型
     */
    public static <N extends Number> double add(N a, N b) {
        double sum;
        sum = a.doubleValue() + b.doubleValue();
        return sum;
    }

    public static <T extends Number> void checkNumber(List<? extends Number> myList, T obj) {
        if (myList.contains(obj)) {
            System.out.println("The list " + myList + " contains the element: " + obj);
        } else {
            System.out.println("The list " + myList + " does not contain the element: " + obj);
        }
    }

}
