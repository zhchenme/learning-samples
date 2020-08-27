package com.zhchen.reflect;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/27
 */
public class AnnotationsSamples {

    public static void main(String[] args) throws IllegalAccessException {
        Class<TheClass> aClass = TheClass.class;
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof MyClassAnnotation) {
                MyClassAnnotation myClassAnnotation = (MyClassAnnotation) annotation;
                System.out.println("name: " + myClassAnnotation.name());
                System.out.println("value: " + myClassAnnotation.value());
            }
        }
//        Annotation annotation = aClass.getAnnotation(MyClassAnnotation.class);
//        System.out.println(annotation);

        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.get(null));
            Annotation[] annotations1 = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations1) {
                if (annotation instanceof MyParameterAnnotation) {
                    MyParameterAnnotation myParameterAnnotation = (MyParameterAnnotation) annotation;
                    System.out.println("name: " + myParameterAnnotation.name());
                    System.out.println("value: " + myParameterAnnotation.value());
                }
            }
        }
    }

    @MyClassAnnotation(name = "someName", value = "Hello World")
    public static class TheClass {
        @MyParameterAnnotation(name = "someName", value = "Hello World")
        public static String name = "zhchen";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface MyClassAnnotation {
        String name();
        String value();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface MyParameterAnnotation {
        String name();
        String value();
    }
}
