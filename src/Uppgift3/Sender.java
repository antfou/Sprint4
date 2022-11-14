package Uppgift3;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;

public class Sender implements ActionListener{
    JFrame jFrame = new JFrame();
    final JButton jButton = new JButton("Koppla Ner");
    JTextArea jTextArea = new JTextArea();
    JTextField jTextField = new JTextField();
    private final String ERROR_MESSAGE = "Vänligen skriv in ditt användarnamn innan du börjar chatta." +
            " \n                " +
            "Klicka på 'koppla ner för att köra igång!";
     final String multicastAdress = "234.235.236.237";
     final String networkInterfaceName = "wlan2";
     final int destinationPort = 11111;
     InetAddress inetAddress;
     String userInput;
     String userName;
     InetSocketAddress inetSocketAddress;
     NetworkInterface networkInterface;
     MulticastSocket multicastSocket;

    protected Sender(String userName)throws IOException, InterruptedException {
        inetAddress = InetAddress.getByName(multicastAdress);
        inetSocketAddress = new InetSocketAddress(inetAddress,destinationPort);
        networkInterface = NetworkInterface.getByName(networkInterfaceName);
        multicastSocket = new MulticastSocket(destinationPort);
        multicastSocket.joinGroup(inetSocketAddress,networkInterface);
        this.userName = userName + ": ";

        confirmConnectionMessage();

        jFrame.add(jButton, BorderLayout.NORTH);
        jFrame.add(jTextArea, BorderLayout.CENTER);
        jFrame.add(jTextField, BorderLayout.SOUTH);
        jButton.addActionListener((ActionListener) this);
        jTextField.addActionListener((ActionListener) this);
        jFrame.setLocation(100,100);
        jFrame.setSize(400,800);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    protected void sendMessage(String userInput){
        byte[] data = (userName + userInput).getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(data, data.length, inetAddress, destinationPort);
        try{
            multicastSocket.send(datagramPacket);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    protected void confirmConnectionMessage( ){
        byte[] data = ("Uppkopplad").getBytes();
            //TODO: Kommentera ut raden under.
            jTextArea.append("Uppkopplad" + "\n");
        DatagramPacket datagramPacket = new DatagramPacket(data, data.length, inetAddress, destinationPort);
        try{
            multicastSocket.send(datagramPacket);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        try {
            new Sender("");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
//JOptionPane.showInputDialog("Vem Chattar?")
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(jButton)){
            userName = JOptionPane.showInputDialog("Vem chattar?");
        } else if (e.getSource().equals(jTextField)) {
            if (userName.isEmpty() || userName.equals(": ")){
                JOptionPane.showMessageDialog(null,ERROR_MESSAGE);
                jTextField.setText("");
            }else {
                userInput = jTextField.getText();
                if(!userInput.isEmpty()) {
                    //TODO: Kommentera ut de 2raderna under.
                    jTextArea.append(userName + "\n");
                    jTextArea.append(userInput + "\n");
                    sendMessage(userInput);
                    jTextField.setText("");
                }
            }
        }
    }
}