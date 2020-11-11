package com.zhchen.im.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/11/10
 */
public class Spliter extends LengthFieldBasedFrameDecoder {

    /**
     * 数据包长度协议偏移量
     */
    private static final int LENGTH_FIELD_OFFSET = 7;
    /**
     * 数据包长度协议字节数
     */
    private static final int LENGTH_FIELD_LENGTH = 4;

    public Spliter() {
        super(Integer.MAX_VALUE, LENGTH_FIELD_OFFSET, LENGTH_FIELD_LENGTH);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        // 魔数校验，过滤非协议版本请求
        if (in.getInt(in.readerIndex()) != PacketCodeC.MAGIC_NUMBER) {
            ctx.channel().close();
            System.out.println("==============");
            return null;
        }
        return super.decode(ctx, in);
    }
}
