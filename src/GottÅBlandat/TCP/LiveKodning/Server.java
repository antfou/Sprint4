package GottÅBlandat.TCP.LiveKodning;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    final int PORT_NR = 1234;
    public Server(){
        try(ServerSocket serverSocket = new ServerSocket(PORT_NR);
            Socket socket = serverSocket.accept();
            BufferedReader insStream = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ){
            String temp = "";
            while ((temp = insStream.readLine()) != null){
                System.out.println(temp);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server s = new Server();
    }
}
