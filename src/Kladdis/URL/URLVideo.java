package Kladdis.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLVideo {
    public URLVideo() throws IOException{
        URL url = new URL("https://www.youtube.com");
        //Try with resources
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
        String currentLine;
        while((currentLine = bufferedReader.readLine()) != null){
            System.out.println(currentLine);
        }
    }
    public static void main(String[] args) throws IOException {
        new URLVideo();
    }
}
