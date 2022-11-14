package Uppgift13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class HuvudProgram {
    public int counter = 0;
    public HuvudProgram() throws IOException{
        URL url = new URL("https://github.com/dwyl/english-words/blob/master/words.txt?raw=true");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        String currentLine;
        while((currentLine = bufferedReader.readLine()) != null){
            //System.out.println(currentLine);
            counter++;
        }
        System.out.println("Det var" + counter + " rader text.");
    }
    public static void main(String[] args) throws IOException {
        new HuvudProgram();
    }
}
