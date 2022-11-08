package Uppgift4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Reciever {
    final int thisPort = 11111;
    String printablData;
    DatagramSocket datagramSocket = new DatagramSocket(thisPort);
    byte[] inData = new byte[256];
    public Reciever() throws IOException {
        while(true){
            DatagramPacket datagramPacket = new DatagramPacket(inData, inData.length);
            datagramSocket.receive(datagramPacket);
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
