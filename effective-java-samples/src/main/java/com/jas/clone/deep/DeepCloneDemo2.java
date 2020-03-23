package com.jas.clone.deep;

import lombok.Data;

import java.io.*;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/03/23
 */
@Data
public class DeepCloneDemo2 implements Serializable {
    private static final long serialVersionUID = -626114263137398742L;

    private int constant;

    private Entity2 entity2;

    public DeepCloneDemo2 deepCopy() {
        DeepCloneDemo2 copy = new DeepCloneDemo2();
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            copy = (DeepCloneDemo2) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return copy;
    }

}
