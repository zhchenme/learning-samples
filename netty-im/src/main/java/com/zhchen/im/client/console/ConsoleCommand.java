package com.zhchen.im.client.console;

import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/11/11
 */
public interface ConsoleCommand {

    void exec(Scanner scanner, Channel channel);
}
