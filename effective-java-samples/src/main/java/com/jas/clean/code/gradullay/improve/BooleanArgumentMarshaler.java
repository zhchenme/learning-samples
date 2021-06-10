package com.jas.clean.code.gradullay.improve;

import java.util.Iterator;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2021/06/09
 */
public class BooleanArgumentMarshaler implements ArgumentMarshaler {

    private boolean booleanValue = false;

    @Override
    public void set(Iterator<String> currentArgument) {
        booleanValue = true;
    }

    public static boolean getValue(ArgumentMarshaler am) {
        if (null != am && am instanceof BooleanArgumentMarshaler) {
            return ((BooleanArgumentMarshaler) am).booleanValue;
        } else {
            return false;
        }
    }

}
