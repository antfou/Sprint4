package Uppgift12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerHandler extends Thread {
    Socket socket;
    MessagePrintHandler messagePrintHandler;
    StaticVariables staticVariables = new StaticVariables();
    String tempString;
    public ServerHandler(Socket socket, MessagePrintHandler messagePrintHandler){
        this.socket = socket;
        this.messagePrintHandler = messagePrintHandler;
    }
    public void run() {
        try(PrintWriter outStream = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader inStream = new BufferedReader(new InputStreamReader(socket.getInputStream()))){

            messagePrintHandler.addWriter(outStream);
            while (true){
                tempString = inStream.readLine();
                if(tempString == null){
                    return;
                }
                for(PrintWriter printWriter : messagePrintHandler.getWriters()){
                    printWriter.println(tempString);
                }
                //TODO: kommentera bort
                System.out.println(tempString);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
