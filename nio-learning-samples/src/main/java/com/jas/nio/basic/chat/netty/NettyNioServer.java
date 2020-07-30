package com.jas.nio.basic.chat.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.nio.charset.StandardCharsets;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/07/30
 */
public class NettyNioServer {

    public static void main(String[] args) throws Exception {
        final ByteBuf buf = Unpooled.copiedBuffer("Hi!\r\n", StandardCharsets.UTF_8);
        EventLoopGroup group = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(group)
                .channel(NioServerSocketChannel.class)
                .localAddress(8080)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) {
                        new ChannelInboundHandlerAdapter() {
                            @Override
                            public void channelActive(ChannelHandlerContext ctx) {
                                ctx.writeAndFlush(buf.duplicate()).addListener(ChannelFutureListener.CLOSE);
                            }
                        };
                    }
                });
        ChannelFuture future = bootstrap.bind().sync();
        future.channel().closeFuture().sync();
        group.shutdownGracefully().sync();
    }

}
