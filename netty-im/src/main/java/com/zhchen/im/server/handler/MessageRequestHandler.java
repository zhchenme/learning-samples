package com.zhchen.im.server.handler;

import com.zhchen.im.protocol.PacketCodeC;
import com.zhchen.im.protocol.request.MessageRequestPacket;
import com.zhchen.im.protocol.response.MessageResponsePacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/11/10
 */
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket messageRequestPacket) {
        MessageResponsePacket messageResponsePacket = this.receiveMessage(messageRequestPacket);
        ByteBuf responseByteBuf = PacketCodeC.INSTANCE.encode(ctx.alloc().ioBuffer(), messageResponsePacket);
        ctx.channel().writeAndFlush(responseByteBuf);
    }

    private MessageResponsePacket receiveMessage(MessageRequestPacket messageRequestPacket) {
        System.out.println(new Date() + ": 收到客户端消息: " + messageRequestPacket.getMessage());
        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        messageResponsePacket.setMessage("服务端回复【" + messageRequestPacket.getMessage() + "】");
        return messageResponsePacket;
    }
}
