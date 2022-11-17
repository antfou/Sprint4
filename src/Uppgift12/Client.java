package Uppgift12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Objects;

public class Client implements ActionListener{
    StaticVariables staticVariables = new StaticVariables();
    JFrame jFrame = new JFrame();
    JTextArea jTextArea = new JTextArea();
    JTextField jTextField = new JTextField();
    final InetAddress IP_ADRESS;
    {
        try {
            IP_ADRESS = InetAddress.getByName(staticVariables.ADDRESS_HOST);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    String userMessage = "";
    String oldMessage = "";
    public Client() {
        try (Socket socket = new Socket(IP_ADRESS, staticVariables.PORT_NR);
             BufferedReader insStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter outStream = new PrintWriter(socket.getOutputStream(), true)) {

            String userName;
            userName = JOptionPane.showInputDialog(staticVariables.BOOTUP_MESSAGE);
            if(userName == null){
                System.exit(0);
            }
            jFrame.setTitle(staticVariables.title + userName);
            userName = userName + ": ";
            jFrame.add(jTextArea, BorderLayout.CENTER);
            jFrame.add(jTextField, BorderLayout.SOUTH);
            jTextField.addActionListener((ActionListener) this);
            jTextArea.setEditable(false);
            jFrame.setLocation(100,100);
            jFrame.setSize(400,400);
            jFrame.setVisible(true);
            jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            String tempString;

            while(true){
                if(userMessage != null && !Objects.equals(userMessage, oldMessage) && !userMessage.isEmpty()){
                    outStream.println(userName + userMessage);
                    oldMessage = userMessage;
                }
                if((tempString = insStream.readLine()) != null){
                    jTextArea.append(tempString + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        new Client();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(jTextField)){
            userMessage = jTextField.getText();
            jTextField.setText("");
        }
    }
}