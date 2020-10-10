package com.zhchen.concurrency;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.stream.IntStream;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @from https://www.baeldung.com/java-unsafe
 * @since 2020/10/10
 */
public class UnsafeSamples {

    private int secretValue = 0;

    public boolean secretIsDisclosed() {
        return secretValue == 1;
    }

    public static void main(String[] args) throws Exception {
        initClass();
        alterPrivateFields();
        offHeapSamples();
        casSamples();
    }

    // Unsafe 本身是个单例
    public static Unsafe getInstanceByReflection() throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        return (Unsafe) f.get(null);
    }

    public static void initClass() throws Exception {
        // 初始化对象，不会调用构造函数
        UnsafeSamples unsafeSamples = (UnsafeSamples) getInstanceByReflection().allocateInstance(UnsafeSamples.class);
        System.out.println(unsafeSamples);
    }

    public static void alterPrivateFields() throws Exception {
        UnsafeSamples unsafeSamples = new UnsafeSamples();
        System.out.println(unsafeSamples.secretIsDisclosed());
        Field f = unsafeSamples.getClass().getDeclaredField("secretValue");
        Unsafe unsafe = getInstanceByReflection();
        // 修改字段值
        unsafe.putInt(unsafeSamples, unsafe.objectFieldOffset(f), 1);
        System.out.println(unsafeSamples.secretIsDisclosed());
    }

    public static void throwException() throws Exception {
        getInstanceByReflection().throwException(new NullPointerException());
    }

    public static void offHeapSamples() throws Exception {
        OffHeapArray array = new OffHeapArray((long) Integer.MAX_VALUE * 2);
        int sum = 0;
        // 0 - 100 求和
        for (int i = 0; i <= 100; i++) {
            // 设置的位置不能大于内存
            array.set((long) Integer.MAX_VALUE + i, (byte) i);
            sum += array.get((long) Integer.MAX_VALUE + i);
        }
        System.out.println(sum);
        array.freeMemory();
    }

    public static void casSamples() throws Exception {
        int a = 10;
        int b = 1000;
//        ExecutorService service = Executors.newFixedThreadPool(a);
        CASCounter casCounter = new CASCounter();
//        IntStream.rangeClosed(0, a - 1)
//                .forEach(i -> service.submit(() -> IntStream
//                        .rangeClosed(0, b - 1)
//                        .forEach(j -> casCounter.increment())));
        IntStream.rangeClosed(0, b - 1).forEach(i -> {
            Thread thread = new Thread(casCounter::increment);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(casCounter.getCounter());
    }

    static class OffHeapArray {
        private final static int BYTE = 1;
        private final long address;

        public OffHeapArray(long size) throws Exception {
            // 分配堆外内存
            address = getInstanceByReflection().allocateMemory(size * BYTE);
        }

        public void set(long i, byte value) throws Exception {
            getInstanceByReflection().putByte(address + i * BYTE, value);
        }

        public int get(long idx) throws Exception {
            return getInstanceByReflection().getByte(address + idx * BYTE);
        }

        public void freeMemory() throws Exception {
            getInstanceByReflection().freeMemory(address);
        }
    }

    static class CASCounter {
        private final Unsafe unsafe;
        private volatile long counter = 0;
        private final long offset;

        public CASCounter() throws Exception {
            unsafe = getInstanceByReflection();
            offset = unsafe.objectFieldOffset(CASCounter.class.getDeclaredField("counter"));
        }

        public void increment() {
            long before = counter;
            while (!unsafe.compareAndSwapLong(this, offset, before, before + 1)) {
                before = counter;
            }
        }

        public long getCounter() {
            return counter;
        }
    }

}
