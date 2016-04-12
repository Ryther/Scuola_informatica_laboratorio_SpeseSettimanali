package spesesettimanali_server;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Edoardo Zanoni
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        List<Utente> utenti = new LinkedList<>();
        System.out.append("Prova cambio I/O in cmd");
        utenti.add(new Utente(scn.nextLine(), scn.nextLine(), scn.nextLine()));
        for (int i = 0; i < 10; i++) {
            utenti.get(0).aggiungiSpesa(new SpesaStandard(CalendarUtils.stringToDate(scn.nextLine()), scn.nextLine()));
        }
        utenti.get(0).aggiungiSpesa(new SpesaUrgente(CalendarUtils.stringToDate(scn.nextLine()), CalendarUtils.stringToDate(scn.nextLine()), scn.nextLine()));
        utenti.get(0).save();
    }
}