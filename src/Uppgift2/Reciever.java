package Uppgift2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Reciever {
    public static void main(String[] args) throws IOException {
        final int thisPort = 1337;
        String quote;
        DatagramSocket datagramSocket = new DatagramSocket(thisPort);
        byte[] inData = new byte[256];
        while(true){
            DatagramPacket datagramPacket = new DatagramPacket(inData, inData.length);
            datagramSocket.receive(datagramPacket);
            quote = new String(datagramPacket.getData(),0, datagramPacket.getLength());
            System.out.println(quote);
        }
    }
}
