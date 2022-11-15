package Uppgift6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
public class Client {
    final int PORT_NR = 1234;
    final String ADDRESS_HOST = "LocalHost";
    final InetAddress IP_ADRESS = InetAddress.getByName(ADDRESS_HOST);
    public Client() throws UnknownHostException {
        try (Socket socket = new Socket(IP_ADRESS, PORT_NR);
             ObjectInputStream insStream = new ObjectInputStream(socket.getInputStream());
             PrintWriter outStream = new PrintWriter(socket.getOutputStream(),true))
        {
            Object fromServer = (insStream.readObject());
            String userInput;
            System.out.println(fromServer);
            Scanner scanner = new Scanner(System.in);
            while((userInput = scanner.nextLine()) != null){
                outStream.println(userInput);
                System.out.println("Sent to server: " + userInput);

                fromServer = insStream.readObject();

                if(fromServer instanceof Kompis){
                    Kompis kompis = (Kompis) fromServer;
                    System.out.println("Namn: " + kompis.getNamn());
                    System.out.println("Email: " + kompis.getEmail());
                    System.out.println("Mobilnummer: " + kompis.getMobilnummer());
                    System.out.println("Födelsedag: " + kompis.getFödelsedag());
                }else if(fromServer instanceof String){
                    System.out.println(fromServer);
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