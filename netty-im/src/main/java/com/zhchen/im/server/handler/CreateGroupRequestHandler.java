package com.zhchen.im.server.handler;

import com.zhchen.im.protocol.request.CreateGroupRequestPacket;
import com.zhchen.im.protocol.response.CreateGroupResponsePacket;
import com.zhchen.im.util.IDUtil;
import com.zhchen.im.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/11/11
 */
public class CreateGroupRequestHandler extends SimpleChannelInboundHandler<CreateGroupRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupRequestPacket createGroupRequestPacket) {
        List<String> userIdList = createGroupRequestPacket.getUserIdList();
        List<String> userNameList = new ArrayList<>(userIdList.size());
        ChannelGroup channelGroup = new DefaultChannelGroup(ctx.executor());
        for (String userId : userIdList) {
            Channel channel = SessionUtil.getChannel(userId);
            if (null != channel) {
                channelGroup.add(channel);
                userNameList.add(SessionUtil.getSession(channel).getUserName());
            }
        }
        CreateGroupResponsePacket createGroupResponsePacket = new CreateGroupResponsePacket();
        createGroupResponsePacket.setSuccess(true);
        createGroupResponsePacket.setGroupId(IDUtil.randomId());
        createGroupResponsePacket.setUserNameList(userNameList);
        channelGroup.writeAndFlush(createGroupResponsePacket);
        System.out.print("群创建成功，id 为[" + createGroupResponsePacket.getGroupId() + "], ");
        System.out.println("群里面有：" + createGroupResponsePacket.getUserNameList());
    }
}
