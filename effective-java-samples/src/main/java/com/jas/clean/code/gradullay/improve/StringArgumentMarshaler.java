package com.jas.clean.code.gradullay.improve;

import java.util.Iterator;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2021/06/09
 */
public class StringArgumentMarshaler implements ArgumentMarshaler {

    private String strValue;

    @Override
    public void set(Iterator<String> currentArgument) {
        strValue = currentArgument.next();
    }

    public static String getValue(ArgumentMarshaler am) {
        if (null != am && am instanceof StringArgumentMarshaler) {
            return ((StringArgumentMarshaler) am).strValue;
        } else {
            return "";
        }
    }
}
