package com.zhchen.io.stream;

import java.io.*;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/19
 */
public class ObjectInputStreamSamples {

    public static class Person implements Serializable {
        private static final long serialVersionUID = 7426083937450492618L;
        public String name = null;
        public int    age  =   0;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/Users/zhangchen/document/test.md"));
        Person person = new Person();
        person.name = "zhchen";
        person.age  = 18;
        // 写入的对象必须序列化
        objectOutputStream.writeObject(person);
        objectOutputStream.close();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/Users/zhangchen/document/test.md"));
        Person personRead = (Person) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(personRead.name);
        System.out.println(personRead.age);
    }

}
