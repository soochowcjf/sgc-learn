package com.cjf.netty.chapter12.thread;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;

import static com.cjf.netty.chapter12.thread.Constant.PORT;

public class Client {

    private static final String SERVER_HOST = "127.0.0.1";

    public static void main(String[] args) throws Exception {
        new Client().start(PORT);
    }

    public void start(int port) throws Exception {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        final Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventLoopGroup).
                channel(NioSocketChannel.class)
                .option(ChannelOption.SO_REUSEADDR, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) {
                        ch.pipeline().addLast(new FixedLengthFrameDecoder(Long.BYTES));
                        ch.pipeline().addLast(ClientBusinessHandler.INSTANCE);
                    }
                });

        /**
         * 创建1000个连接去连接服务端
         */
        for (int i = 0; i < 1000; i++) {
            bootstrap.connect(SERVER_HOST, port).get();
        }
    }
}
