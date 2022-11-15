package GottÅBlandat.TCP.LiveKodning;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    final int PORT_NR = 1234;
    final String ACKNOWLEDGED = "Message recieved: ";
    final String SUCCESFUL_CONNECTION = "Connected.";
    public Server(){
        try(ServerSocket serverSocket = new ServerSocket(PORT_NR);
            Socket socket = serverSocket.accept();
            PrintWriter outStream = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader insStream = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ){
            String tempInStreamLine = "";
            outStream.println(SUCCESFUL_CONNECTION);
            while ((tempInStreamLine = insStream.readLine()) != null){
                System.out.println(tempInStreamLine);
                outStream.println(ACKNOWLEDGED + tempInStreamLine);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Server s = new Server();
    }
}
