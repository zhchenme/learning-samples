package com.zhchen.im.server.handler;

import com.zhchen.im.protocol.request.LoginRequestPacket;
import com.zhchen.im.protocol.response.LoginResponsePacket;
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
        LoginResponsePacket loginResponsePacket = this.login(loginRequestPacket);
        ctx.channel().writeAndFlush(loginResponsePacket);
    }

    private LoginResponsePacket login(LoginRequestPacket requestPacket) {
        LoginResponsePacket responsePacket = new LoginResponsePacket();
        if (this.valid(requestPacket)) {
            responsePacket.setSuccess(true);
            System.out.println(new Date() + ": 客户端登录成功!");
        } else {
            responsePacket.setSuccess(false);
            responsePacket.setReason("用户名或密码错误");
            System.err.println(new Date() + ": 客户端登录失败!");
        }
        return responsePacket;
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }
}
