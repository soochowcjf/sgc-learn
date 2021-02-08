package netty.chapter12.thread;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;

import static netty.chapter12.thread.Constant.PORT;


public class Server {

    public static void main(String[] args) {

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        //创建一个业务线程池
        EventLoopGroup businessGroup = new NioEventLoopGroup(1000);

        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childOption(ChannelOption.SO_REUSEADDR, true)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) {
                        ch.pipeline().addLast(new FixedLengthFrameDecoder(Long.BYTES));
//                ch.pipeline().addLast(ServerBusinessHandler.INSTANCE);

                        //优化方式一：将耗时操作交给线程池去做
//                ch.pipeline().addLast(ServerBusinessThreadPoolHandler.INSTANCE);
                        //优化方式二：将整个操作放到一个线程池中去处理
                        ch.pipeline().addLast(businessGroup, ServerBusinessHandler.INSTANCE);
                    }
                });

        bootstrap.bind(PORT).addListener((ChannelFutureListener) future -> System.out.println("bind success in port: " + PORT));
    }

}
