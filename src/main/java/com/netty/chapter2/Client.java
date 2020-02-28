package com.netty.chapter2;

import java.io.IOException;
import java.net.Socket;

/**
 * @author:chenjinfeng
 * @date: 2018/9/10
 * @time: 22:13
 * @desc
 */
public class Client {
    

    private Socket socket;

    public Client(String host, int port) {
        try {
            this.socket = new Socket(host, port);
            System.out.println("客户端启动成功");
        } catch (Exception e) {

        }
    }

    public void start() {
        new Thread(() -> {
            while (true) {
                try {
                    String message = "hello world";
                    System.out.println("客户端发送数据: " + message);
                    socket.getOutputStream().write(message.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        new Client("127.0.0.1", 8000).start();
    }
}
