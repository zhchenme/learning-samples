package com.zhchen.im.server.handler;

import com.zhchen.im.protocol.response.LoginResponsePacket;
import com.zhchen.im.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/11/10
 */
public class AuthHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (!SessionUtil.hasLogin(ctx.channel())) {
            LoginResponsePacket responsePacket = new LoginResponsePacket();
            responsePacket.setSuccess(false);
            responsePacket.setReason("登陆失效，请重新登陆");
            ctx.channel().writeAndFlush(responsePacket);
            ctx.channel().close();
        } else {
            // 身份验证后删除验证，防止多次请求重复验证
            ctx.pipeline().remove(this);
            super.channelRead(ctx, msg);
        }
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) {
        if (SessionUtil.hasLogin(ctx.channel())) {
            System.out.println("当前连接登录验证完毕，无需再次验证, AuthHandler 被移除");
        } else {
            System.err.println("无登录验证，强制关闭连接!");
        }
    }
}
