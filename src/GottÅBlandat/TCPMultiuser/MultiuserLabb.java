package GottÅBlandat.TCPMultiuser;

import java.net.ServerSocket;
import java.net.Socket;

public class MultiuserLabb extends Thread /*OR implements runnable*/{

    //Best Practice

    //filmDemoProjOOP Sprint4 TCP BilregisterMultiuser

        //Servern ska bara Lyssna efter ya klienter
        //Varje klient ska få sin egna tråd
        //Check CarDemoMulituser in facit and demos.
        //Om du har en loop för att starta trådar av klienter och servrar så vill du a en separat metod för att samla
        //all info du vill slänga in till ett objekt, eller skicka vidare.
        // I "Run()" vill du ha dina readers och printers.
        //Släng en try with resources i run så att strömmarna stängs.
        //Has shit to do with protkoll, bygg ett skelett för allt det här.
            //I en databas ha 6st tärningar sparade med färg och siffra, varje tärnings namn är 1-6 men det är inte siffran på tärningen.
                //Se till att du kan kasta run objekt och att flera klienter kan använda tärningarna samtidigt.


}