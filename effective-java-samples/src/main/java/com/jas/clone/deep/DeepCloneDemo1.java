package com.jas.clone.deep;

import com.jas.clone.shallow.Entity;
import lombok.Data;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/03/23
 */
@Data
public class DeepCloneDemo1 implements Cloneable {

    private int constant;

    private Entity1 entity1;

    @Override
    protected Object clone() {
        try {
            DeepCloneDemo1 deepCloneDemo1 = (DeepCloneDemo1)super.clone();
            deepCloneDemo1.setEntity1((Entity1) deepCloneDemo1.getEntity1().clone());
            return deepCloneDemo1;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
