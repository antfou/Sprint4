package Uppgift2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class Sender {

    public static void main(String[] args) throws UnknownHostException, SocketException, InterruptedException {
        String adress = "localHost";
        final int destinationPort = 1337;
        String message;
        int counter = 0;
        final String quote1 = "There are no accidents - Master Oogway";
        final String quote2 = "There is just news. There is no good or bad. - Master Oogway";
        final String quote3 = "When will you realise? The more you take, the less you have. - Master Oogway";
        List<String> stringList = new ArrayList<>();
        stringList.add(quote1);
        stringList.add(quote2);
        stringList.add(quote3);
        InetAddress inetAddress = InetAddress.getByName(adress);
        DatagramSocket datagramSocket = new DatagramSocket();
        while (true) {
            message = stringList.get(counter);
            counter = (counter +1) % 3;
            byte[] upData = message.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(upData,upData.length,inetAddress,destinationPort);
            try {
                datagramSocket.send(datagramPacket);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            Thread.sleep(5000);
        }
    }
}
