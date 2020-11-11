package com.zhchen.im.protocol.request;

import com.zhchen.im.protocol.Packet;
import com.zhchen.im.protocol.command.Command;
import lombok.Data;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/11/11
 */
@Data
public class QuitGroupRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {
        return Command.QUIT_GROUP_REQUEST;
    }
}