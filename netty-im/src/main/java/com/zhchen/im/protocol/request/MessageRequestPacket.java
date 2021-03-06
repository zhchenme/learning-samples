package com.zhchen.im.protocol.request;

import com.zhchen.im.protocol.Packet;
import com.zhchen.im.protocol.command.Command;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/11/09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequestPacket extends Packet {

    private String message;

    private String toUserId;

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_REQUEST;
    }
}
