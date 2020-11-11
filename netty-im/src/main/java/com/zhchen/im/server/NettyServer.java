package com.zhchen.im.server;

import com.zhchen.im.protocol.Spliter;
import com.zhchen.im.protocol.codec.PacketDecoder;
import com.zhchen.im.protocol.codec.PacketEncoder;
import com.zhchen.im.server.handler.*;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/11/09
 */
public class NettyServer {

    private static final Integer PORT = 8080;

    public static void main(String[] args) {

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();
        serverBootstrap.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                // 处理启动流程逻辑
                .handler(new ChannelInitializer<NioServerSocketChannel>() {
                    @Override
                    protected void initChannel(NioServerSocketChannel ch) {
                        System.out.println("服务端启动中...");
                    }
                })
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) {
                        ch.pipeline().addLast(new Spliter())
                                .addLast(new PacketDecoder())
                                .addLast(new PacketEncoder())
                                // .addLast(new LifeCyCleTestHandler())
                                .addLast(new LoginRequestHandler())
                                .addLast(new AuthHandler())
                                .addLast(new MessageRequestHandler())
                                .addLast(new CreateGroupRequestHandler())
                                .addLast(new JoinGroupRequestHandler())
                                .addLast(new QuitGroupRequestHandler());
                    }
                })
                // 为每个连接设置自定义属性，通过 chanel.attr() 方法获取值
                .childAttr(AttributeKey.newInstance("childAttr"), "value1")
                // 为服务端的 channel 自定义属性，通过 channel.attr() 获取
                .attr(AttributeKey.newInstance("attr"), "value2")
                // 为每条 TCP 链接设置属性，SO_KEEPALIVE 开启心跳机制
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.TCP_NODELAY, true)
                // 为服务端 channel 设置属性，SO_BACKLOG 用于设置"已完成三次握手的请求的队列的最大长度"
                .option(ChannelOption.SO_BACKLOG, 1024);
        bind(serverBootstrap, PORT);
    }

    private static void bind(final ServerBootstrap serverBootstrap, final int port) {
        serverBootstrap.bind(port).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("端口[" + port + "]绑定成功!");
            } else {
                System.err.println("端口[" + port + "]绑定失败!");
                bind(serverBootstrap, port + 1);
            }
        });
    }

}
