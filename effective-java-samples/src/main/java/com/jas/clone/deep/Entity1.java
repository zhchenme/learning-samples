package com.jas.clone.deep;

import lombok.Data;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/03/20
 */
@Data
public class Entity1 implements Cloneable{

    private String str;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
