package com.zhchen.im.protocol.response;

import com.zhchen.im.protocol.Packet;
import com.zhchen.im.protocol.command.Command;
import lombok.Data;

import java.util.List;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/11/11
 */
@Data
public class CreateGroupResponsePacket extends Packet {

    private Boolean success;

    private String groupId;

    private List<String> userNameList;

    @Override
    public Byte getCommand() {

        return Command.CREATE_GROUP_RESPONSE;
    }
}
