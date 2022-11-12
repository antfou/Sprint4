package Uppgift3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodListener;

public class Graphics extends JFrame implements ActionListener{
    String userName = "";
    String userInput = "";
    final JButton jButton = new JButton("Koppla Ner");
    JTextArea jTextArea = new JTextArea();
    JTextField jTextField = new JTextField();
    Graphics(){
        add(jButton, BorderLayout.NORTH);
        add(jTextArea,BorderLayout.CENTER);
        add(jTextField,BorderLayout.SOUTH);
        jButton.addActionListener((ActionListener) this);
        jTextField.addActionListener((ActionListener) this);
        jTextArea.setEditable(false);
        setLocation(100,100);
        setSize(400,800);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public String getUserName(){
        return userName;
    }
    public String getUserInput(){
        return userInput;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(jButton)){
            userName = JOptionPane.showInputDialog("Vem chattar?");
        } else if (e.getSource().equals(jTextField)) {
            if (userName.isEmpty()){
                JOptionPane.showMessageDialog(null,"Vänligen skriv in ditt användarnamn innan du börjar chatta." +
                        " \n                " +
                        "Klicka på 'koppla ner för att köra igång!");
                jTextField.setText("");
                jTextArea.setText("");
            }else {
                userInput = jTextField.getText();
                jTextField.setText("");
                jTextArea.append(userName + ": " + userInput + "\n");
            }
        }
    }
}
