package com.zhchen.im.protocol.request;

import com.zhchen.im.protocol.Packet;
import com.zhchen.im.protocol.command.Command;
import lombok.Data;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/11/11
 */
@Data
public class LogoutRequestPacket extends Packet {

    @Override
    public Byte getCommand() {
        return Command.LOGOUT_REQUEST;
    }
}
