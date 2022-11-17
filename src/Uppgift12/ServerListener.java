package Uppgift12;

import Uppgift10.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class ServerListener {
    private StaticVariables staticVariables = new StaticVariables();
    private MessagePrintHandler messagePrintHandler = new MessagePrintHandler();
    public ServerListener(){

            while(true) {
                try(ServerSocket serverSocket = new ServerSocket(staticVariables.PORT_NR);) {
                Socket socket = serverSocket.accept();
                ServerHandler serverHandler = new ServerHandler(socket, messagePrintHandler);
                serverHandler.start();
            }
            catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) {
        new ServerListener();
    }
}
