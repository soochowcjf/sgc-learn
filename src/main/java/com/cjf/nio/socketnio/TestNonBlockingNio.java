package com.cjf.nio.socketnio;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Date;
import java.util.Iterator;

/**
 * @author:chenjinfeng
 * @date: 2018/8/5
 * @time: 16:08
 * @desc
 */
public class TestNonBlockingNio {
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
//    @Test
    public static void client() throws Exception {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        //切换到非阻塞模式
        socketChannel.configureBlocking(false);
        //分配缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //发送数据给服务端
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = br.readLine()) != null) {
            buffer.put((new Date().toString() + "\n" + line).getBytes());
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }
        socketChannel.close();
    }

//    @Test
    public static void server() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //切换到非阻塞模式
        serverSocketChannel.configureBlocking(false);
        // 绑定连接
        serverSocketChannel.bind(new InetSocketAddress(9898));
        //获取选择器
        Selector selector = Selector.open();
        //注册选择器
        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
        //轮询式的获取选择器上已经注册的事件
        while (selector.select() > 0 ) {
            //获取当前选择器上注册的事件
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey selectionKey = it.next();
                //判断具体是什么事件准备就绪
                if (selectionKey.isAcceptable()) {
                    //若“接收就绪”，获取客户端连接
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    //切换到非阻塞模式
                    socketChannel.configureBlocking(false);
                    //将该通道注册到选择器上
                    socketChannel.register(selector,SelectionKey.OP_READ);
                }else if (selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int len = 0;
                    while ((len = socketChannel.read(buffer)) != -1) {
                        buffer.flip();
                        System.out.println(new String(buffer.array(),0,len));
                        buffer.clear();
                    }
                }
                // 取消选择键 SelectionKey
                it.remove();
            }
        }
        selector.close();
        serverSocketChannel.close();
    }

    public static void main(String[] args) throws Exception {
        server();
        client();
    }
}
