package Kladdis.Properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesVideo {
    private String fName;
    private String lName;
    private String age;
    private String identity;
    private String identity2;
    public PropertiesVideo(){
        Properties properties = new Properties();
        try{
            properties.load(new FileInputStream("src/Kladdis/Properties/propertiesVideo.properties"));
        }catch (FileNotFoundException e){
            System.out.println("Error: File not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error: RuntimeException.");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
         fName = properties.getProperty("FName", "Leroy");
         lName = properties.getProperty("LName", "Collazo");
         age = properties.getProperty("Age","22");
         identity = properties.getProperty("FName", "John") +
                 " " + properties.getProperty("LName", "Doe") +
                 ": " + properties.getProperty("Age","42");
         identity2 = properties.getProperty("fname", "John") +
                 " " + properties.getProperty("lname", "Doe") +
                 ": " + properties.getProperty("age","42");
    }
    public String getfName() {
        return fName;
    }
    public String getlName() {
        return lName;
    }
    public String getAge() {
        return age;
    }
    public String getIdentity() {
        return identity;
    }
    public String getIdentity2() {
        return identity2;
    }
    public static void main(String[] args) {
        PropertiesVideo propertiesVideo = new PropertiesVideo();
        System.out.println(propertiesVideo.getfName());
        System.out.println(propertiesVideo.getlName());
        System.out.println(propertiesVideo.getAge());
        System.out.println(propertiesVideo.getIdentity());
        System.out.println(propertiesVideo.getIdentity2());
    }
}
