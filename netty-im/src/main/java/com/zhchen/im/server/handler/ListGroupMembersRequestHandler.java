package com.zhchen.im.server.handler;

import com.zhchen.im.protocol.Session;
import com.zhchen.im.protocol.request.ListGroupMembersRequestPacket;
import com.zhchen.im.protocol.response.ListGroupMembersResponsePacket;
import com.zhchen.im.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/11/12
 */
@ChannelHandler.Sharable
public class ListGroupMembersRequestHandler extends SimpleChannelInboundHandler<ListGroupMembersRequestPacket> {

    public static final SimpleChannelInboundHandler<ListGroupMembersRequestPacket> INSTANCE = new ListGroupMembersRequestHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ListGroupMembersRequestPacket listGroupMembersRequestPacket) {
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(listGroupMembersRequestPacket.getGroupId());
        List<Session> sessionList = new ArrayList<>();
        for (Channel channel : channelGroup) {
            Session session = SessionUtil.getSession(channel);
            sessionList.add(session);
        }
        ListGroupMembersResponsePacket responsePacket = new ListGroupMembersResponsePacket();
        responsePacket.setGroupId(listGroupMembersRequestPacket.getGroupId());
        responsePacket.setSessionList(sessionList);
        ctx.channel().writeAndFlush(responsePacket);
    }
}
