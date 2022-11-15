package Uppgift1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    final int PORT_NR = 1234;
    final String ADDRESS_HOST = "LocalHost";
    final InetAddress IP_ADRESS = InetAddress.getByName(ADDRESS_HOST);
    public Client() throws UnknownHostException {
        try (Socket socket = new Socket(IP_ADRESS, PORT_NR);
             BufferedReader insStream = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            String temp = "";
            while ((temp = insStream.readLine()) != null) {
                System.out.println(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws UnknownHostException {
        new Client();
    }
}
