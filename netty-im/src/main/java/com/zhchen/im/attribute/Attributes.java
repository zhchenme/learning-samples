package com.zhchen.im.attribute;

import com.zhchen.im.protocol.Session;
import io.netty.util.AttributeKey;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/11/09
 */
public interface Attributes {

    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");

    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");

}
