package com.cjf.netty.chapter9;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * created by cjf 21:21 2018/11/19
 */
public class BizHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        User user = new User(23,"chenjinfeng");

        ctx.channel().writeAndFlush(user);
    }
}
