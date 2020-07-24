package com.jas.nio.basic.chat;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/07/17
 */
public class SocketUtil {

    private static final Integer BUFFER_SIZE = 48;

    public static void sendMsg(SocketChannel sc, String msg) throws Exception {
        ByteBuffer bf = ByteBuffer.allocate(BUFFER_SIZE);
        bf.put(msg.getBytes());
        bf.flip();
        sc.write(bf);
        bf.clear();
    }

    public static String receiverMsg(SocketChannel sc) throws Exception {
        ByteBuffer bf = ByteBuffer.allocate(BUFFER_SIZE);
        if (-1 != sc.read(bf)) {
            bf.flip();
            byte[] bytes = new byte[bf.limit()];
            bf.get(bytes);
            String msg = new String(bytes);
            bf.clear();
            return msg;
        }
        return "noMsg";
    }

}
