package com.zhchen.im.protocol.response;

import com.zhchen.im.protocol.Packet;
import com.zhchen.im.protocol.Session;
import com.zhchen.im.protocol.command.Command;
import lombok.Data;

import java.util.List;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/11/12
 */
@Data
public class ListGroupMembersResponsePacket extends Packet {

    private String groupId;

    private List<Session> sessionList;

    @Override
    public Byte getCommand() {
        return Command.LIST_GROUP_MEMBERS_RESPONSE;
    }
}
