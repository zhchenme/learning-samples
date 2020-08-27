package com.zhchen.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/27
 */
public class GenericsSamples {

    public static List<String> getStringList() {
        return new ArrayList<>();
    }

    public static void main(String[] args) throws NoSuchMethodException {

        Method method = GenericsSamples.class.getMethod("getStringList", null);
        Type returnType = method.getGenericReturnType();
        // Type[] genericParameterTypes = method.getGenericParameterTypes();
        if (returnType instanceof ParameterizedType) {
            ParameterizedType type = (ParameterizedType) returnType;
            Type[] typeArguments = type.getActualTypeArguments();
            for (Type typeArgument : typeArguments) {
                Class<?> typeArgClass = (Class<?>) typeArgument;
                System.out.println("typeArgClass = " + typeArgClass);
            }
        }
    }

}
