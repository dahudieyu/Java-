package testcom.testmyapp.allclass;


import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException {
        
        Socket socket = new Socket("localhost", 8888);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("发送请求!");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // 客户端读取代码
        StringBuilder fullResponse = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null && !line.equals("END_OF_RESPONSE")) {
            fullResponse.append(line).append("\n");
        }
        System.out.println("完整响应:\n" + fullResponse);
    
        
        out.close();
        in.close();
        socket.close();
    }

}
