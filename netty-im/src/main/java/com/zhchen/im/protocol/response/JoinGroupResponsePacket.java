package com.zhchen.im.protocol.response;

import com.zhchen.im.protocol.Packet;
import com.zhchen.im.protocol.command.Command;
import lombok.Data;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/11/11
 */
@Data
public class JoinGroupResponsePacket extends Packet {

    private Boolean success;

    private String groupId;

    private String reason;

    @Override
    public Byte getCommand() {
        return Command.JOIN_GROUP_RESPONSE;
    }
}
