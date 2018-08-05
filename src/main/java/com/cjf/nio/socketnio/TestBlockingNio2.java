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
 * @time: 14:34
 * @desc
 */
public class TestBlockingNio2 {

    @Test
    public void client() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("g:/test/1.jpg"), StandardOpenOption.READ);
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8888));
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (inChannel.read(buffer) != -1) {
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }
        socketChannel.shutdownOutput();
        int len = 0;
        while ((len = socketChannel.read(buffer)) != -1) {
            buffer.flip();
            System.out.println(new String(buffer.array(),0,len));
            buffer.clear();
        }
        //关流
        socketChannel.close();
        inChannel.close();
    }

    @Test
    public void server() throws IOException {
        FileChannel outChannel = FileChannel.open(Paths.get("g:/test/3.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8888));
        SocketChannel socketChannel = serverSocketChannel.accept();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (socketChannel.read(buffer) != -1) {
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }
        buffer.put("图片接收成功".getBytes());
        buffer.flip();
        socketChannel.write(buffer);
        //关流
        socketChannel.close();
        serverSocketChannel.close();
        outChannel.close();
    }
}
