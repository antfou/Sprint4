package Uppgift3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reciever  {
    String userInput = "";
    String userName = "";
    Reciever(){
        Graphics graphics = new Graphics();
        while (true) {
            userName = graphics.getUserName();
            userInput = graphics.getUserInput();
            if (!userInput.isEmpty() && !userName.isEmpty()) {
                graphics.jTextArea.append(userName + ": " + userInput + "\n");
            }
        }
    }
    public static void main(String[] args) {
        new Reciever();
    }
}
