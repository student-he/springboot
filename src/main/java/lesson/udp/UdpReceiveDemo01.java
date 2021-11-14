package lesson.udp;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpReceiveDemo01 {

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(6666);
            while (true){
                UdpReceiveDemo02.printData(socket);

                if (receiveDate.endsWith("bye"));{
                    break;
                }
            }
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
