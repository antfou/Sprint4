package Uppgift3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;


    //TODO: Programmet är klart så använder TODO för att kunna hitta min kod enklare :)
    //TODO: Ett single-thread program som inte riktigt är det pga actionlisteners or some shit.
    //TODO: Kopplar upp mig till en multiclass address, kan starta flera av appen samtidigt, de kommer alla att vara på samma nätverk men varje instans av appen har sin egen thread.


public class HuvudProgram implements ActionListener, Runnable{
    private final String ERROR_MESSAGE = "Vänligen skriv in ditt användarnamn innan du börjar chatta." +
            " \n                " +
            "Klicka på 'koppla ner för att köra igång!";
    JFrame jFrame = new JFrame();
    final JButton jButton = new JButton("Koppla Ner");
    JTextArea jTextArea = new JTextArea();
    JTextField jTextField = new JTextField();
    final Timer timer = new Timer(10000, this);
    //TODO: Här kopplar jag upp mig till nätverket.
    final String multicastAdress = "234.235.236.237";
     final String networkInterfaceName = "wlan2";
     final int destinationPort = 11111;
     InetAddress inetAddress;
     String userInput;
     String userName;
     InetSocketAddress inetSocketAddress;
     NetworkInterface networkInterface;
     MulticastSocket multicastSocket;

    protected HuvudProgram(String userName)throws IOException, InterruptedException {
        //TODO: Här kopplar jag upp mig till nätverket.
        inetAddress = InetAddress.getByName(multicastAdress);
        inetSocketAddress = new InetSocketAddress(inetAddress,destinationPort);
        networkInterface = NetworkInterface.getByName(networkInterfaceName);
        multicastSocket = new MulticastSocket(destinationPort);
        multicastSocket.joinGroup(inetSocketAddress,networkInterface);

        this.userName = userName;

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

        timer.start();

        //TODO: Min reciever som plockar ner uppdata från varje Thread så att alla kan se den nya informationen.
        byte[] inData = new byte[1024];

        while(true){
            try{
                DatagramPacket packet = new DatagramPacket
                        (inData, inData.length);
                multicastSocket.receive(packet);
                String medd = new String(inData, 0,
                        packet.getLength());
                synchronized(this) {
                    jTextArea.append(medd +"\n");
                }
            }
            catch (IOException e){
                break;
            }
        }
    }
    //TODO: Min metod för att packa datan samt skicka den.
    protected void sendMessage(String userInput){
        byte[] upData = (userName + userInput).getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(upData, upData.length, inetAddress, destinationPort);
        try{
            multicastSocket.send(datagramPacket);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    protected void confirmConnectionMessage( ){
        byte[] data = ("A new user has joined the chat.").getBytes();
            //jTextArea.append("Uppkopplad" + "\n");
        DatagramPacket datagramPacket = new DatagramPacket(data, data.length, inetAddress, destinationPort);
        try{
            multicastSocket.send(datagramPacket);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        try {
            new HuvudProgram("");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(jButton)){
            userName = JOptionPane.showInputDialog("Vem chattar?");
            userName = userName + ": ";
        } else if (e.getSource().equals(jTextField)) {
            if (userName.isEmpty() || userName.equals(": ")){
                JOptionPane.showMessageDialog(null,ERROR_MESSAGE);
                jTextField.setText("");
            }else {
                userInput = jTextField.getText();
                if(!userInput.isEmpty()) {
                    //jTextArea.append(userName + "\n");
                    //jTextArea.append(userInput + "\n");
                    sendMessage(userInput);
                    jTextField.setText("");
                }
            }
        }
    }
//TODO: Om klassen är runnable måste du ha "run()".
    @Override
    public void run() {}
}