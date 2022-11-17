package Uppgift10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    final int PORT_NR = 1234;
    final String ADDRESS_HOST = "LocalHost";
    final InetAddress IP_ADRESS;
    String fromUser = "";
    String fromServer = "";
    {
        try {
            IP_ADRESS = InetAddress.getByName(ADDRESS_HOST);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
    public Client(){
        try (Socket socket = new Socket(IP_ADRESS, PORT_NR);
                 BufferedReader userInputHandler = new BufferedReader(new InputStreamReader(System.in));
                 BufferedReader insStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter outStream = new PrintWriter(socket.getOutputStream(),true))
        {
            fromServer = insStream.readLine();
            System.out.println(fromServer);

            while((fromUser = userInputHandler.readLine())!=null){

                outStream.println(fromUser);
                System.out.println("Sent to server: " + fromUser);

                fromServer = insStream.readLine();
                if(fromServer!=null){
                System.out.println(fromServer);}
                else {
                    System.out.println("allaala");
                }

            }

        } catch (Exception e) {
                e.printStackTrace();
        }
    }
    public static void main(String[] args) throws UnknownHostException {
        new Client();
    }
}