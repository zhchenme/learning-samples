package com.zhchen.im.protocol.response;

import com.zhchen.im.protocol.command.Command;
import com.zhchen.im.protocol.Packet;
import lombok.Data;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/11/09
 */
@Data
public class LoginResponsePacket extends Packet {

    private String reason;

    private Boolean success;

    @Override
    public Byte getCommand() {
        return Command.LOGIN_RESPONSE;
    }
}
