package lesson.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

//客户端
public class TCPClientDemo2 {

    public static void main(String[] args) throws Exception {

        //1、创建一个Socket链接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);

        //2、创建一个输出流
        OutputStream outputStream = socket.getOutputStream();

        //3、读取文件
        FileInputStream fileInputStream = new FileInputStream(new File("dandan.JPG"));

        //4、写文件
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fileInputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }

        //通知服务器已经结束传输
        socket.shutdownOutput();

        //确定服务器接受完毕才能断开链接
        InputStream inputStream = socket.getInputStream();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        byte[] buffer2 = new byte[1024];
        int len2;
        while ((len2 = inputStream.read(buffer2)) != -1) {
            byteArrayOutputStream.write(buffer2, 0, len2);

        }
        System.out.println(byteArrayOutputStream.toString());
        //5、关闭资源
        byteArrayOutputStream.close();
        inputStream.close();
        fileInputStream.close();
        outputStream.close();
        socket.close();
    }
}

