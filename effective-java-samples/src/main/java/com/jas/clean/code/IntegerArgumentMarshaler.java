package com.jas.clean.code;

import java.util.Iterator;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2021/06/09
 */
public class IntegerArgumentMarshaler implements ArgumentMarshaler {

    private Integer intValue = 0;

    @Override
    public void set(Iterator<String> currentArgument) {
        String parameter = currentArgument.next();
        intValue = Integer.parseInt(parameter);
    }

    public static int getValue(ArgumentMarshaler am) {
        if (null != am && am instanceof IntegerArgumentMarshaler) {
            return ((IntegerArgumentMarshaler) am).intValue;
        } else {
            return 0;
        }
    }
}
