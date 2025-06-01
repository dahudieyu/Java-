package testcom.testmyapp.allclass;

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务器启动，等待客户端连接...");

        Socket clientSocket = serverSocket.accept();
        System.out.println("客户端连接成功: "+
                clientSocket.getInetAddress());

        // 读客户端发来的消息
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String message = in.readLine();
        System.out.println("收到客户端消息：" + message);

        // 给客户端回消息
       
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        // out.println("服务器已收到消息：" + message + system.getMenuText());
        // System.out.println("服务器已给客户端回消息：" + system.getMenuText());

        // 关闭连接
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

}

