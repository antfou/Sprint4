package Uppgift12;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MessagePrintHandler {
    private static List<PrintWriter> writers = new ArrayList<>();

    public void addWriter(PrintWriter printWriter){
        writers.add(printWriter);
    }
    public List<PrintWriter> getWriters(){
        return writers;
    }
}
