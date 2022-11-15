package Uppgift6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    final String BOOTUP_MESSAGE = "Vilken kompis vill du söka upp?";
    Database database = new Database();
    final int PORT_NR = 1234;
    public Server() throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(PORT_NR);
            Socket socket = serverSocket.accept();
            ObjectOutputStream outStream = new ObjectOutputStream(socket.getOutputStream());
            BufferedReader insStream = new BufferedReader(new InputStreamReader(socket.getInputStream())))
        {
                outStream.writeObject(BOOTUP_MESSAGE);
                String tempString;
                while ((tempString = insStream.readLine()) != null) {
                    if (database.hämtaKompis(tempString) == null) {
                        System.out.println(database.hämtaKompis(tempString));
                        outStream.writeObject("Du skrev: " + tempString +
                                ". Den personen är inte din kompis.");
                    } else {
                        outStream.writeObject(database.hämtaKompis(tempString));
                    }
                }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        new Server();
    }
}
