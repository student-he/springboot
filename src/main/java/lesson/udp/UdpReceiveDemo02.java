package lesson.udp;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpReceiveDemo02 implements Runnable {

    DatagramSocket socket = null;
    private int port;

    public UdpReceiveDemo02(int port){
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {

        while (true){
            try{
                printData(socket);
                String receiveData = null;


            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    static void printData(DatagramSocket socket) throws IOException {
        byte[] container = new byte[1024];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);
        socket.receive(packet);

        byte[] data = packet.getData();
        String receiveData = new String(data,0,data.length);

        System.out.println(receiveData);
    }
}
