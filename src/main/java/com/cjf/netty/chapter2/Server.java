package com.cjf.netty.chapter2;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author:chenjinfeng
 * @date: 2018/9/10
 * @time: 22:13
 * @desc
 */
public class Server {

    private ServerSocket serverSocket;

    public Server(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
            System.out.println("服务端已经启动，端口：" + port);
        } catch (Exception e) {
            System.out.println("服务端启动发生异常");
        }
    }


    public void start() {
        new Thread(() -> {
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    InputStream inputStream = socket.getInputStream();
                    byte[] buf = new byte[1024];
                    int len;
                    while ((len = inputStream.read(buf)) != -1) {
                        String str = new String(buf, 0, len);
                        System.out.println("客户端传递的数据：" + str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        new Server(8000).start();
    }
}
