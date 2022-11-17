package Uppgift10;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListener {
    final int PORT_NR = 1234;

    public ServerListener(){

        try (ServerSocket serverSocket = new ServerSocket(PORT_NR);){

            while(true) {
                Socket socket = serverSocket.accept();
                Server server = new Server(socket);
                server.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        new ServerListener();
    }
}