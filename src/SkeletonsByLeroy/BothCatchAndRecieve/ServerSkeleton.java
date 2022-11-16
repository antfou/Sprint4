package SkeletonsByLeroy.BothCatchAndRecieve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSkeleton {
    final int PORT_NUM = 2233;
    final String CONNECTED = "Connected.";
    final String MESSAGE = "Welcome to the server.";
    final String MESSAGE_RECIEVED = "Message recieved: ";

    ServerSkeleton(){
        try(ServerSocket serverSocket = new ServerSocket(PORT_NUM);
            Socket socket = serverSocket.accept();
            PrintWriter outputHandler = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader inputHandler = new BufferedReader(new InputStreamReader(socket.getInputStream())))
        {
            String tempStringFromClient;
            String stringFromClient;
            System.out.println(CONNECTED);
            outputHandler.println(MESSAGE);

            while((tempStringFromClient = inputHandler.readLine())!= null){
                stringFromClient = tempStringFromClient;
                System.out.println(stringFromClient);
                outputHandler.println(MESSAGE_RECIEVED + stringFromClient);
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new ServerSkeleton();
    }
}
