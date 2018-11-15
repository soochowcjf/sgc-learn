package com.cjf.netty.chapter6;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

import java.util.concurrent.TimeUnit;

/**
 * created by cjf 22:48 2018/11/7
 */
public class OutBoundHandlerB extends ChannelOutboundHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println("OutBoundHandlerB: " + msg);
        ctx.write(msg, promise);
    }

    /**
     * Channel 中的 write()方法 是从尾结点往头结点传播的
     *
     * ChannelHandlerContext 中的 write()方法，是从当前结点往前传播的
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        ctx.executor().schedule(() -> {
            ctx.channel().write("hello world");
//            ctx.write("hello world");
        }, 3, TimeUnit.SECONDS);
    }
}
