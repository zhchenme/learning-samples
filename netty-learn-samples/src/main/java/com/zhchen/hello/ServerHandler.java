package com.zhchen.hello;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @author <a href="mailto:chen.zhang@yunhuyj.com">lanxiang</a>
 * @since 2020/07/24
 */
@ChannelHandler.Sharable
public class ServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 当 Channel 已经注册到它的 EventLoop 并且能够处理 I/O 时被调
     */
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
    }

    /**
     * 当 Channel 从它的 EventLoop 注销并且无法处理任何 I/O 时被调用
     */
    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        super.channelUnregistered(ctx);
    }

    /**
     * 当 Channel 离开活动状态并且不再连接它的远程节点时被调用
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }

    /**
     * 当 ChannelnboundHandler.fireUserEventTriggered() 方法被调 用时被调用，因为一个 POJO 被传经了 ChannelPipeline
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
    }

    /**
     * 当Channel的可写状态发生改变时被调用
     */
    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        super.channelWritabilityChanged(ctx);
    }

    /**
     * 当从 Channel 读取数据时被调用
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf inBuffer = (ByteBuf) msg;
        String received = inBuffer.toString(CharsetUtil.UTF_8);
        System.out.println("Server received: " + received);
        ctx.write(Unpooled.copiedBuffer("Hello " + received, CharsetUtil.UTF_8));
        /**
         * ChannelPipeline.fireChannelRead：从当前 channelHandler 执行
         * ChannelHandlerContext.fireChannelRead：从下一个 channelHandler 执行
         */
        ctx.fireChannelRead(msg);
        // 丢弃已接收到的消息，SimpleChannelInboundHandler 不需要显示释放任何资源
        // ReferenceCountUtil.release(msg);
    }

    /**
     *  当 Channel 上的一个读操作完成时被调用
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * 当 Channel 处于活动状态时被调用;Channel 已经连接/绑定并且已经就绪
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("Client " + ctx.channel().remoteAddress() + " connected");
    }
}
