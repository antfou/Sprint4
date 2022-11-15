package Uppgift5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
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
             BufferedReader insStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter outStream = new PrintWriter(socket.getOutputStream(),true))
        {
                System.out.println(insStream.readLine());
                Scanner scanner = new Scanner(System.in);
                String userInput = scanner.nextLine();
                outStream.println(userInput);
                System.out.println(insStream.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws UnknownHostException {
        new Client();
    }
}
