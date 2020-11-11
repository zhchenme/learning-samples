package com.zhchen.im.server.handler;

import com.zhchen.im.protocol.Session;
import com.zhchen.im.protocol.request.LoginRequestPacket;
import com.zhchen.im.protocol.response.LoginResponsePacket;
import com.zhchen.im.util.IDUtil;
import com.zhchen.im.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/11/10
 */
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket loginRequestPacket) {
        LoginResponsePacket responsePacket = new LoginResponsePacket();
        if (this.valid(loginRequestPacket)) {
            responsePacket.setSuccess(true);
            String userId = IDUtil.randomId();
            responsePacket.setUserId(userId);
            responsePacket.setUserName(loginRequestPacket.getUsername());
            SessionUtil.bindSession(new Session(userId, loginRequestPacket.getUsername()), ctx.channel());
            System.out.println("[" + loginRequestPacket.getUsername() + "]登录成功");
        } else {
            responsePacket.setSuccess(false);
            responsePacket.setReason("用户名或密码错误");
            System.err.println(new Date() + ": 客户端登录失败!");
        }
        ctx.channel().writeAndFlush(responsePacket);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        SessionUtil.unBindSession(ctx.channel());
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }
}
