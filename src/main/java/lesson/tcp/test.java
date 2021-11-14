package lesson.tcp;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class test {
    public static void main(String[] args) {
        String socketAddress = "www.baidu.com";
        InetAddress address = null;
        try {
            address = InetAddress.getByName(socketAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println("计算机名" + address.getHostName());
        System.out.println("IP地址" + address.getHostAddress());
    }
}
