package com.zhchen.hello;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/07/24
 */
public class NettyTcpServer {

    public static void main(String[] args) throws Exception {

        /**
         * NioEventLoopGroup：进行事件处理，比如：接受新连接和读写数据
         * ServerBootstrap：引导和绑定服务器
         * ServerHandler：实现业务逻辑
         * ServerBootstrap.bind()：绑定服务器
         */
        EventLoopGroup group = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(group)
                .channel(NioServerSocketChannel.class)
                .localAddress(new InetSocketAddress("localhost", 8080))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) {
                        ch.pipeline().addLast(new ServerHandler()).addLast(new SecondServerHandler());
                    }
                });
        ChannelFuture channelFuture = bootstrap.bind().sync();
        channelFuture.channel().closeFuture().sync();
        group.shutdownGracefully().sync();
    }

}
