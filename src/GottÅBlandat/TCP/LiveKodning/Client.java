package GottÅBlandat.TCP.LiveKodning;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    final int PORT_NR = 1234;
    final String ADDRESS_HOST = "LocalHost";
    final String MESSAGE= "Test";
    final InetAddress IP_ADRESS = InetAddress.getByName(ADDRESS_HOST);
    public Client() throws UnknownHostException {
        try(Socket socket = new Socket(IP_ADRESS,PORT_NR);
            PrintWriter outStream = new PrintWriter(socket.getOutputStream(), true)){

            while (true) {
                outStream.println(MESSAGE);
                Thread.sleep(3000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws UnknownHostException {
        Client client = new Client();
    }
}
