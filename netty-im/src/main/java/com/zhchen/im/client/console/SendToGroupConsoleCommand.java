package com.zhchen.im.client.console;

import com.zhchen.im.protocol.request.GroupMessageRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/11/12
 */
public class SendToGroupConsoleCommand implements ConsoleCommand {
    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.print("发送消息给某个某个群组：");
        String toGroupId = scanner.next();
        String message = scanner.next();
        GroupMessageRequestPacket groupMessageRequestPacket = new GroupMessageRequestPacket();
        groupMessageRequestPacket.setMessage(message);
        groupMessageRequestPacket.setToGroupId(toGroupId);
        channel.writeAndFlush(groupMessageRequestPacket);

    }
}