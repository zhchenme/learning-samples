package com.zhchen.im.server.handler;

import com.zhchen.im.protocol.request.JoinGroupRequestPacket;
import com.zhchen.im.protocol.response.JoinGroupResponsePacket;
import com.zhchen.im.util.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/11/11
 */
@ChannelHandler.Sharable
public class JoinGroupRequestHandler extends SimpleChannelInboundHandler<JoinGroupRequestPacket> {

    public static final SimpleChannelInboundHandler<JoinGroupRequestPacket> INSTANCE = new JoinGroupRequestHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, JoinGroupRequestPacket joinGroupRequestPacket) {
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(joinGroupRequestPacket.getGroupId());
        channelGroup.add(ctx.channel());
        JoinGroupResponsePacket joinGroupResponsePacket = new JoinGroupResponsePacket();
        joinGroupResponsePacket.setSuccess(true);
        joinGroupResponsePacket.setGroupId(joinGroupRequestPacket.getGroupId());
        ctx.channel().writeAndFlush(joinGroupResponsePacket);
    }
}
