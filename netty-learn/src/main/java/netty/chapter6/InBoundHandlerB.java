package netty.chapter6;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * created by cjf 21:54 2018/11/7
 */
public class InBoundHandlerB extends ChannelInboundHandlerAdapter {

    /**
     * ChannelHandlerContext 的 fireChannelRead()方法，是从当前结点开始往下一个结点开始传播
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("InBoundHandlerB: " + msg);
        ctx.fireChannelRead(msg);
    }

    /**
     * channelActive表示有新连接接入的时候触发
     *
     * PipeLine 的 fireChannelRead()方法，是从链表的头结点开始传播，head
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.pipeline().fireChannelRead("hello world");
    }
}
