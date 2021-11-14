package lesson.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

//客户端
public class TCPClientDemo {

    public static void main(String[] args) {

        Socket socket = null;
        OutputStream outputStream = null;
        try {
            InetAddress serverIp = InetAddress.getByName("127.0.0.1");
            int port = 9999;
            //链接服务器Socket
            socket = new Socket(serverIp, port);
            outputStream = socket.getOutputStream();
            //发送消息
            outputStream.write("你好，欢饮光临".getBytes(StandardCharsets.UTF_8));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

