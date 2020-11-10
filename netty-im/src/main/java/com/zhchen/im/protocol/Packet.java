package com.zhchen.im.protocol;

import lombok.Data;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/11/06
 */
@Data
public abstract class Packet {

    private Byte version = 1;

    public abstract Byte getCommand();

}
