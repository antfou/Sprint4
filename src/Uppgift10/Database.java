package Uppgift10;

import Uppgift5.Kompis;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private final Uppgift5.Kompis KOMPIS_1 = new Uppgift5.Kompis("Anton",
            "0701234567","8e Mars",
            "AFougner@mailhemsida.se");
    private final Uppgift5.Kompis KOMPIS_2 = new Uppgift5.Kompis("Leroy",
            "0709873164","9e December",
            "LCollazo@mailhemsida.se");
    private final Uppgift5.Kompis KOMPIS_3 = new Uppgift5.Kompis("Jani",
            "0701234987","5e September",
            "JHakala@mailhemsida.se");

    private final List<Uppgift5.Kompis> KOMPIS_LISTA = new ArrayList<>();

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
