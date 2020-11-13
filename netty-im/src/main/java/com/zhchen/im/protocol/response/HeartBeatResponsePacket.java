package com.zhchen.im.protocol.response;

import com.zhchen.im.protocol.Packet;
import com.zhchen.im.protocol.command.Command;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/11/13
 */
public class HeartBeatResponsePacket extends Packet {

    @Override
    public Byte getCommand() {
        return Command.HEARTBEAT_RESPONSE;
    }
}
