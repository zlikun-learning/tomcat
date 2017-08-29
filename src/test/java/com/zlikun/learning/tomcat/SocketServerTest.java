package com.zlikun.learning.tomcat;

import org.junit.Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 测试服务器单播通信
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/8/29 10:30
 */
public class SocketServerTest {

    @Test
    public void test() throws IOException {
        // 绑定本地8888端口
        ServerSocket serverSocket = new ServerSocket(8888) ;
        // 调用accept()方法进行阻塞，等待客户端的连接，一旦有连接就创建一个套接字并返回
        Socket socket = serverSocket.accept() ;
        // 获取输入/输出流，输入流用于获取客户端传输的数据，而输出流用于向客户端响应发送数据
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream()) ;
        DataInputStream dis = new DataInputStream(socket.getInputStream()) ;
        System.out.println("服务器接收到客户端的请求：" + dis.readUTF());
        dos.writeUTF("接受连接请求，连接成功!");
        // 处理完成后关闭套接字
        socket.close();
        serverSocket.close();
    }

}
