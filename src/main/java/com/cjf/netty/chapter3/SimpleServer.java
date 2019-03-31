package com.cjf.netty.chapter3;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.AttributeKey;
import io.netty.util.CharsetUtil;

/**
 * created by cjf 22:29 2018/10/31
 */
public class SimpleServer {

    public static void main(String[] args) throws Exception {

        //boss负责连接的监听，accept
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        //work处理连接上传输的数据，真正的io线程
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    //设置反射出来的服务端channel的类型
                    .channel(NioServerSocketChannel.class)
                    //给服务端的channel设置属性
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    //给客户端的channel设置属性
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childOption(ChannelOption.TCP_NODELAY, true)
                    //给服务端的channel添加一些自定义属性
                    .attr(AttributeKey.newInstance("serverName"), "nettyServer")
                    //给客户端的channel添加一些自定义属性
                    .childAttr(AttributeKey.newInstance("clientKey"), "clientValue")
                    //添加服务端的handler
                    .handler(new SimpleServerHandler())
                    //添加客户端的handler
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new AuthHandler());
                            //
                        }
                    });
            ChannelFuture f = b.bind(8888).sync();
            f.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    private static class SimpleServerHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            System.out.println("channelActive");
        }

        @Override
        public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
            System.out.println("channelRegistered");
        }

        @Override
        public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
            System.out.println("handlerAdded");
        }
    }

    /**
     * SimpleChannelInboundHandler 会自动释放ByteBuf的内存，释放资源,内部调用了 ReferenceCountUtil.release(msg);
     */
    public static class AuthHandler extends SimpleChannelInboundHandler<ByteBuf> {
        @Override
        protected void channelRead0(ChannelHandlerContext ctx, ByteBuf password) throws Exception {
            if (paas(password)) {
                ctx.pipeline().remove(this);
            } else {
                ctx.close();
            }
        }

        private boolean paas(ByteBuf msg) {
            ByteBuf in = (ByteBuf) msg;
            System.out.println(
                    "Server received: " + in.toString(CharsetUtil.UTF_8));
            return false;
        }
    }
}
