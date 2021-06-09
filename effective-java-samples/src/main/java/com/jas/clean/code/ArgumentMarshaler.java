package com.jas.clean.code;

import java.util.Iterator;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2021/06/09
 */
public interface ArgumentMarshaler {

    void set(Iterator<String> currentArgument);

}
