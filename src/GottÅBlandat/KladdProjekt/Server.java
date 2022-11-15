package GottÅBlandat.KladdProjekt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    final int PORT_NR = 1234;

    public Server(){
        try(ServerSocket serverSocket = new ServerSocket(PORT_NR);
            Socket socket = serverSocket.accept();
            PrintWriter outStream = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader insStream = new BufferedReader(new InputStreamReader(socket.getInputStream())))
        {
            //TODO: Skriv mitt program här. While true för print, while != null för read.
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Uppgift1.Server();
    }
}
