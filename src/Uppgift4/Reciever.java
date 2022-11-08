package Uppgift4;
import java.io.IOException;
import java.net.*;

public class Reciever {
    final String multicastAdress = "234.235.236.237";
    final int thisPort = 11111;
    final String networkInterfaceName = "wlan1";
    String printablData;
    byte[] inData = new byte[256];
    public Reciever() throws IOException {
        InetAddress inetAddress = InetAddress.getByName(multicastAdress);
        InetSocketAddress inetSocketAddress = new InetSocketAddress(inetAddress,thisPort);
        NetworkInterface networkInterface = NetworkInterface.getByName(networkInterfaceName);
        MulticastSocket multicastSocket = new MulticastSocket(thisPort);
        multicastSocket.joinGroup(inetSocketAddress,networkInterface);
        while(true){
            DatagramPacket datagramPacket = new DatagramPacket(inData, inData.length);
            multicastSocket.receive(datagramPacket);
            printablData = new String(datagramPacket.getData(),0, datagramPacket.getLength());
            System.out.println(printablData);
        }
    }
    public static void main(String[] args) {
        try {
            new Reciever();
        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}