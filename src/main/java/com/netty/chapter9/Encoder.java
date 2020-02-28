package com.netty.chapter9;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * created by cjf 21:22 2018/11/19
 */
public class Encoder extends MessageToByteEncoder<User> {

    /**
     * ---------------------
     *|   4    |  4  |  ?   |
     * ---------------------
     *| length | age | name |
     * ---------------------
     */
    @Override
    protected void encode(ChannelHandlerContext ctx, User user, ByteBuf out) throws Exception {

        byte[] bytes = user.getName().getBytes();
        out.writeInt(4 + bytes.length);
        out.writeInt(user.getAge());
        out.writeBytes(bytes);

    }
}
