package Uppgift10;

public class Protokoll {
    final String BOOTUP_MESSAGE = "Vilken kompis vill du söka upp?";
    final protected int INITIAL = 0;
    final protected int INTHELOOP = 1;
    String tempString;
    Database database = new Database();
    protected int state = INITIAL;
    public String getOutput(String fromClient){
        if (state == INITIAL){
            state = INTHELOOP;
            return BOOTUP_MESSAGE;
        }
        else if (state == INTHELOOP){
            tempString = database.hämtaKompis((String)fromClient).trim();
        }
        return "Unexpected state eror";
    }
}