package spesesettimanali_server;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edoardo Zanoni
 */
public class Utente {
    
    private static int counter = 0;
    
    private int id;
    private String nomeUtente;
    private String emailUtente;
    private String pwdUtente;
    private List<Spesa> spese = new LinkedList<>();

    public Utente(String nomeUtente, String emailUtente, String pwdUtente) {
        this.nomeUtente = nomeUtente;
        this.emailUtente = emailUtente;
        this.pwdUtente = pwdUtente;
        counter++;
        id = counter;
    }
    
    public Utente(String nomeUtente, String emailUtente, String pwdUtente, int id) {
        this.nomeUtente = nomeUtente;
        this.emailUtente = emailUtente;
        this.pwdUtente = pwdUtente;
        this.id = id;
        if (counter < this.id) {
            counter = this.id;
        }
    }

    public String getNomeUtente() {
        
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        
        this.nomeUtente = nomeUtente;
    }

    public String getEmailUtente() {
        
        return emailUtente;
    }

    public void setEmailUtente(String emailUtente) {
        
        this.emailUtente = emailUtente;
    }

    public String getPwdUtente() {
        
        return pwdUtente;
    }

    public void setPwdUtente(String pwdUtente) {
        
        this.pwdUtente = pwdUtente;
    }

    public List<Spesa> getSpese() {
        
        return spese;
    }

    public void setSpese(List<Spesa> spese) {
        
        this.spese = spese;
    }
    
    public void aggiungiSpesa(Spesa spesa) {
        
        this.spese.add(spesa);
    }
    
    public void rimuoviSpesa(LocalDate data, int id) {
        
        Iterator iterator = this.getSpese().listIterator();
        Spesa element = null;
        while (iterator.hasNext()) {
            
            element = (Spesa) iterator.next();
            
            if (element.getDataSpesa().equals(data) && element.getId() == id) {
                
                iterator.remove();
            }
        }
    }
    
    public void save() {
        
        StringBuilder stringBuilder = new StringBuilder();
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        
        stringBuilder.append("user").append(";")
                .append(this.id).append(";")
                .append(this.getNomeUtente()).append(";")
                .append(this.getEmailUtente()).append(";")
                .append(this.getPwdUtente()).append("\n");
        
        try {
            byteStream.write(stringBuilder.toString().getBytes());
        } catch (IOException ex) {
            Logger.getLogger(Utente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Iterator iterator = this.getSpese().listIterator();
        
        Spesa element = null;
        while (iterator.hasNext()) {
            
            element = (Spesa) iterator.next();
            try {
                byteStream.write(element.toByte());
            } catch (IOException ex) {
                Logger.getLogger(Utente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        FileUtils.salvataggioDati(byteStream.toByteArray());
    }
}