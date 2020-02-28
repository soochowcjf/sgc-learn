package com.netty.chapter12.thread;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 优化方式一，将耗时操作交给线程池去做
 */
@ChannelHandler.Sharable
public class ServerBusinessThreadPoolHandler extends ServerBusinessHandler {
    public static final ChannelHandler INSTANCE = new ServerBusinessThreadPoolHandler();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(20);


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) {
        ByteBuf data = Unpooled.directBuffer();
        data.writeBytes(msg);

        //耗时的操作交给线程池
        threadPool.submit(() -> {
            Object result = getResult(data);
            ctx.channel().writeAndFlush(result);
        });

    }
}
