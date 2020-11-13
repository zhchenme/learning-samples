package com.zhchen.im.client;

import com.zhchen.im.client.console.ConsoleCommandManager;
import com.zhchen.im.client.console.LoginConsoleCommand;
import com.zhchen.im.client.handler.*;
import com.zhchen.im.codec.PacketDecoder;
import com.zhchen.im.codec.PacketEncoder;
import com.zhchen.im.handler.IMIdleStateHandler;
import com.zhchen.im.protocol.Spliter;
import com.zhchen.im.util.SessionUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/11/09
 */
public class NettyClient {

    private static final Integer MAX_RETRY = 5;
    private static final String HOST = "localhost";
    private static final Integer PORT = 8080;

    public static void main(String[] args) {

        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();
        bootstrap.group(group).channel(NioSocketChannel.class)
                // 为客户端的 TCP 设置相关属性，CONNECT_TIMEOUT_MILLIS 设置超时时间，超时连接失败
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                // 为客户端 channel 设置属性
                .attr(AttributeKey.newInstance("clientAttr"), "clientValue")
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) {
                        // LengthFieldBasedFrameDecoder 包解析器，防止数据出现粘连
                        ch.pipeline().addLast(new IMIdleStateHandler())
                                .addLast(new Spliter())
                                .addLast(new PacketDecoder())
                                .addLast(new PacketEncoder())
                                .addLast(new LoginResponseHandler())
                                .addLast(new MessageResponseHandler())
                                .addLast(new CreateGroupResponseHandler())
                                .addLast(new JoinGroupResponseHandler())
                                .addLast(new QuitGroupResponseHandler())
                                .addLast(new ListGroupMembersResponseHandler())
                                .addLast(new GroupMessageResponseHandler())
                                .addLast(new HeartBeatTimerHandler());
                    }
                });
        connect(bootstrap, MAX_RETRY);
    }

    private static void connect(Bootstrap bootstrap, int retry) {
        bootstrap.connect(HOST, PORT).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("连接成功!");
                Channel channel = ((ChannelFuture) future).channel();
                startConsoleThread(channel);
            } else if (retry == 0) {
                System.err.println("重试次数已用完，放弃连接！");
            } else {
                int order = (MAX_RETRY - retry) + 1;
                System.err.println("第 " + order + " 连接失败！");
                int delay = 1 << order;
                System.err.println(new Date() + ": 连接失败，第" + order + "次重连……");
                bootstrap.config().group().schedule(() -> connect(bootstrap, retry - 1), delay, TimeUnit.SECONDS);
            }
        });
    }

    private static void startConsoleThread(Channel channel) {
        ConsoleCommandManager consoleCommandManager = new ConsoleCommandManager();
        LoginConsoleCommand loginConsoleCommand = new LoginConsoleCommand();
        Scanner scanner = new Scanner(System.in);
        new Thread(() -> {
            while (!Thread.interrupted()) {
                if (!SessionUtil.hasLogin(channel)) {
                    loginConsoleCommand.exec(scanner, channel);
                } else {
                    consoleCommandManager.exec(scanner, channel);
                }
            }
        }).start();
    }
}
