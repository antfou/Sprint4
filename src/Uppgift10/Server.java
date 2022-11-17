package Uppgift10;

import Uppgift5.Database;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
    final int PORT_NR = 1234;
    Uppgift5.Database database = new Database();
    Socket socket;
    String databaseAnswer;

    public Server(Socket socket){
        this.socket = socket;
    }
    Protokoll protokoll = new Protokoll();
    public void run(){
        try(PrintWriter outStream = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader insStream = new BufferedReader(new InputStreamReader(socket.getInputStream())))
        {
            outStream.println(protokoll.getOutput(null));
            String tempString = "";
            while ((tempString = insStream.readLine()) != null) {
                if (database.hämtaKompis(tempString) == null) {
                    databaseAnswer = protokoll.getOutput(tempString).trim();
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
        new Uppgift5.Server();
    }
}
