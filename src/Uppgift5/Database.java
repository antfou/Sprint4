package Uppgift5;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private final Kompis KOMPIS_1 = new Kompis("Anton",
            "0701234567","8e Mars",
            "AFougner@mailhemsida.se");
    private final Kompis KOMPIS_2 = new Kompis("Leroy",
            "0709873164","9e December",
            "LCollazo@mailhemsida.se");
    private final Kompis KOMPIS_3 = new Kompis("Jani",
            "0701234987","5e September",
            "JHakala@mailhemsida.se");

    private final List<Kompis> KOMPIS_LISTA = new ArrayList<>();

    public Database(){
        KOMPIS_LISTA.add(KOMPIS_1);
        KOMPIS_LISTA.add(KOMPIS_2);
        KOMPIS_LISTA.add(KOMPIS_3);
    }
    public String hämtaKompis(String input){
        for(Kompis kompis: KOMPIS_LISTA){
            if (kompis.getNamn().equalsIgnoreCase(input)){
                return kompis.getKompis();
            }else{
            }
        }
        return null;
    }
}
