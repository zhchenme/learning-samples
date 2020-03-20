package com.jas.mess.supplier;

import com.jas.mess.bean.User;

import java.util.function.Supplier;


/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/03/20
 */
public class SupplierDemo implements Supplier<User> {

    @Override
    public User get() {
        return new User();
    }
}
