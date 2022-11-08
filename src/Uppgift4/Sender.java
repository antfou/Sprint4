package Uppgift4;
import javax.swing.*;
import java.io.IOException;
import java.net.*;
import java.time.LocalDateTime;
public class Sender {
    private LocalDateTime localDateTime = LocalDateTime.now();
    String timestamp;
    final String multicastAdress = "234.235.236.237";
    final String networkInterfaceName = "wlan1";
    final String exitMessage = "Hej då!";
    final int destinationPort = 11111;
    final String messagePrompt1 = "Vilken stad vill du rapportera?";
    final String messagePrompt2 = "Vilken temperatur var det?";
    final String commaAndSpace = ", ";
    final String celcius = " celcius.";
    final String newLine = "\n";
    String userInputCity;
    String userInputTemperature;
    String upDataAsString;
    InetAddress inetAddress;
    Sender() throws IOException, InterruptedException {
        inetAddress = InetAddress.getByName(multicastAdress);
        InetSocketAddress inetSocketAddress = new InetSocketAddress(inetAddress,destinationPort);
        NetworkInterface networkInterface = NetworkInterface.getByName(networkInterfaceName);
        MulticastSocket multicastSocket = new MulticastSocket(destinationPort);
        multicastSocket.joinGroup(inetSocketAddress,networkInterface);
        while(true){
            userInputCity = JOptionPane.showInputDialog(messagePrompt1);
            userInputTemperature = JOptionPane.showInputDialog(messagePrompt2);
            if(userInputCity == null || userInputTemperature == null||
            userInputCity.isEmpty()|| userInputTemperature.isEmpty()){
                System.out.println(exitMessage);
                System.exit(0);
            }
            timestamp = localDateTime.toString();
            upDataAsString = userInputCity + commaAndSpace + userInputTemperature + celcius + newLine + timestamp;
            byte[] upDataAsByte = upDataAsString.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(upDataAsByte, upDataAsByte.length, inetAddress, destinationPort);
            multicastSocket.send(datagramPacket);
            Thread.sleep(15000);
        }
    }
    public static void main(String[] args) {
        try {
            new Sender();
        } catch (SocketException e) {
            System.out.println("SocketException");
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            System.out.println("UnknownHostException");
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}