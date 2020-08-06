package com.jas.ext;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/08/06
 */
public class ExtTest {

    public static void main(String[] args) {
        User user = new User();
        user.setName("zhchen");
        user.setAge(18);
        user.setRemark("这时一条说明");
        user.setRemark1("这时一条说明1");
        System.out.println(user.getRemark());
        System.out.println(user.getRemark1());
        System.out.println(user.getExt());
    }

}
