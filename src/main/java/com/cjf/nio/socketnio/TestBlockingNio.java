package com.cjf.nio.socketnio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author:chenjinfeng
 * @date: 2018/8/5
 * @time: 13:59
 * @desc
 */
/**
 * 一、使用 NIO 完成网络通信的三个核心：
 *
 * 1. 通道（Channel）：负责连接
 *
 * 	   java.nio.channels.Channel 接口：
 * 			|--SelectableChannel
 * 				|--SocketChannel
 * 				|--ServerSocketChannel
 * 				|--DatagramChannel
 *
 * 				|--Pipe.SinkChannel
 * 				|--Pipe.SourceChannel
 *
 * 2. 缓冲区（Buffer）：负责数据的存取
 *
 * 3. 选择器（Selector）：是 SelectableChannel 的多路复用器。用于监控 SelectableChannel 的 IO 状况
 *
 */
public class TestBlockingNio {

    @Test
    public void client() throws IOException {
        //获取通道
        FileChannel inChannel = FileChannel.open(Paths.get("g:\\test\\1.jpg"), StandardOpenOption.READ);
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",8888));
        //分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (inChannel.read(buffer) != -1) {
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }
        //关流
        inChannel.close();
        socketChannel.close();
    }

    @Test
    public void server() throws IOException {
        //获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        FileChannel outChannel = FileChannel.open(Paths.get("g:\\test\\2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        //绑定连接
        serverSocketChannel.bind(new InetSocketAddress(8888));
        //获取客户端连接的通道
        SocketChannel socketChannel = serverSocketChannel.accept();
        //分配缓冲区的大小
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //接受客户端的数据，并保存
        while (socketChannel.read(buffer) != -1) {
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }
        socketChannel.close();
        outChannel.close();
        serverSocketChannel.close();
    }
}
