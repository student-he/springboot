package lesson.tcp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

//服务端
public class TCPServerDemo2 {
    public static void main(String[] args) throws Exception {

        //创建服务
        ServerSocket serverSocket = new ServerSocket(9000);
        //监听客户端的链接，阻塞式监听，会一直等待客服端链接
        Socket socket = serverSocket.accept();
        //获取输入流
        InputStream inputStream = socket.getInputStream();
        //文件输出
        FileOutputStream fileOutputStream = new FileOutputStream(new File("receive.JPG"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, len);
        }

        //通知客户端我接收完毕了
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("我接受完毕了，你可以断开了".getBytes(StandardCharsets.UTF_8));

        fileOutputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();

    }
}
