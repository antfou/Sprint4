package Uppgift5;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    final String BOOTUP_MESSAGE = "Vilken kompis vill du söka upp?";
    Database database = new Database();
    final int PORT_NR = 1234;
    public Server(){
        try(ServerSocket serverSocket = new ServerSocket(PORT_NR);
            Socket socket = serverSocket.accept();
            PrintWriter outStream = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader insStream = new BufferedReader(new InputStreamReader(socket.getInputStream())))
        {
                outStream.println(BOOTUP_MESSAGE);
                String tempString;
                while ((tempString = insStream.readLine()) != null) {
                    if (database.hämtaKompis(tempString) == null) {
                        System.out.println(database.hämtaKompis(tempString));
                        outStream.println("Du skrev: " + tempString +
                                ". Den personen är inte din kompis.");
                    } else {
                        outStream.println(database.hämtaKompis(tempString));
                    }
                }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Server();
    }
}
