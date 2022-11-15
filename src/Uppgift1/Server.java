package Uppgift1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    final int PORT_NR = 1234;
    final int INTERVAL = 3000;
    final String MESSAGE_ONE = "message 1";
    final String MESSAGE_TWO = "message 2";
    final String MESSAGE_THREE = "message 3";
    public Server(){
        //Servern finns alltid på samma socket och väntar på att clienter ska koppla upp sig.
        try(ServerSocket serverSocket = new ServerSocket(PORT_NR);
            Socket socket = serverSocket.accept();
            PrintWriter outStream = new PrintWriter(socket.getOutputStream(),true))
        {
            while (true){
                outStream.println(MESSAGE_ONE);
                Thread.sleep(INTERVAL);
                outStream.println(MESSAGE_TWO);
                Thread.sleep(INTERVAL);
                outStream.println(MESSAGE_THREE);
                Thread.sleep(INTERVAL);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Server();
    }
}
