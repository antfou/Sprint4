package Uppgift10;

public class Kompis {

    private String namn;
    private String mobilnummer;
    private String födelsedag;
    private String email;

    public Kompis(String namn, String mobilnummer, String födelsedag, String email){
        this.namn = namn;
        this.mobilnummer = mobilnummer;
        this.födelsedag = födelsedag;
        this.email = email;
    }

    public String getNamn() {
        return namn;
    }
    public String getKompis(){
        return "Namn: " +  namn + ". Mobilnummer: " + mobilnummer +
                ". Födelsedag: " + födelsedag + ". Email: " + email;
    }
}
