package com.jas.hashcode;

import java.util.HashMap;
import java.util.Map;

/**
 * PhoneNumber
 *
 * @author lanxiang
 * @since 2019-09-09
 */
public class PhoneNumber {

    private short areaCode;

    private short prefix;

    private short lineNumber;

    public PhoneNumber(short areaCode, short prefix, short lineNumber) {
        this.rangeCheck(areaCode, 999, "area code");
        this.rangeCheck(prefix, 999, "prefix");
        this.rangeCheck(lineNumber, 999, "line number");
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNumber = lineNumber;
    }

    private void rangeCheck(int arg, int max, String name) {
        if (arg < 0 || arg > max) {
            throw new IllegalArgumentException(name + ":" + arg);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        // getClass() != o.getClass() -> o instanceof PhoneNumber
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PhoneNumber that = (PhoneNumber) o;
        return areaCode == that.areaCode &&
                prefix == that.prefix &&
                lineNumber == that.lineNumber;
    }

    /**
     * boolean	                          c = (f ? 0 : 1)
     * byte char short 或int	              c = (int)f
     * long	                              c = (int)(f ^ (f >>> 32))
     * float	                          c = Float.floatToIntBits(f)
     * double	                          long l = Double.doubleToLongBits(f) || c = (int)(l ^ (l >>> 32))
     * Object           	              c = f.hashCode()
     * 数组	                              对每个元素进行上述操作
     */
    @Override
    public int hashCode() {
        // 1.定义一个非零常量值
        int result = 17;
        // 对象引用递归调用 hashCode 方法
        result = 31 * result + areaCode;
        result = 31 * result + prefix;
        result = 31 * result + lineNumber;
        return result;
    }

    public static void main(String[] args) {
        Map<PhoneNumber, String> map = new HashMap<PhoneNumber, String>(16);
        map.put(new PhoneNumber((short) 1, (short) 2, (short) 3), "yes");
        System.out.println(map.get(new PhoneNumber((short) 1, (short) 2, (short) 3)));
    }
}