package com.jas.clone.shallow;

import lombok.Data;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/03/20
 */
@Data
public class ShallowCloneDemo implements Cloneable {

    private int constant;

    private Entity entity;

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
