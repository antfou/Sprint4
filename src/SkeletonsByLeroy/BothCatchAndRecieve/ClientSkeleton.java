package SkeletonsByLeroy.BothCatchAndRecieve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSkeleton {
    final int PORT_NUM = 2233;
    final String MESSAGE = "Hello world!";
    final String MESSAGE_SENT = "Sent message: ";
    final String IP_NAME = "LocalHost";
    final int SLEEP_DURATION = 5000;

    ClientSkeleton() throws UnknownHostException{
        final InetAddress IP = InetAddress.getByName(IP_NAME);

        try(Socket socket = new Socket(IP,PORT_NUM);
            PrintWriter outputHandler = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader inputHandler = new BufferedReader(new InputStreamReader(socket.getInputStream())))
        {
                String tempStringFromServer;
                String stringFromServer;

                while(true){
                    outputHandler.println(MESSAGE);
                    System.out.println(MESSAGE_SENT + MESSAGE);
                    tempStringFromServer = inputHandler.readLine().toString();
                    stringFromServer = tempStringFromServer;
                    System.out.println(stringFromServer);
                    Thread.sleep(SLEEP_DURATION);
                }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws UnknownHostException {
        new ClientSkeleton();
    }
}
