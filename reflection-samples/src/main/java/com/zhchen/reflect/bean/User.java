package com.zhchen.reflect.bean;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/26
 */
public class User {

    private String name = "zc";

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void sayHi() {
        System.out.println("Hi~");
    }

    private void sayHi(String name) {
        System.out.println("Hi~" + name);
    }
}
