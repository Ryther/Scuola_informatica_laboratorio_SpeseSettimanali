package spesesettimanali_server;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Edoardo Zanoni
 */
public class SpesaUrgente implements Spesa {
    
    private static final int DECIMALS = 2;
    private static final int ROUND_TYPE = BigDecimal.ROUND_HALF_EVEN;
    private static final int TYPE = 1;
    
    private static int counter = 0;
    
    private int id;
    private BigDecimal valoreSpesa;
    private LocalDate dataSpesa;
    private LocalDate scadenza;

    public SpesaUrgente(LocalDate dataSpesa, LocalDate scadenza, String valoreSpesa) {
        
        this.valoreSpesa = new BigDecimal(valoreSpesa).setScale(DECIMALS, ROUND_TYPE);
        this.dataSpesa = dataSpesa;
        this.scadenza = scadenza;
        counter++;
        this.id = counter;
    }
    
    public SpesaUrgente(int id, LocalDate dataSpesa, LocalDate scadenza, String valoreSpesa) {
        this.valoreSpesa = new BigDecimal(valoreSpesa).setScale(DECIMALS, ROUND_TYPE);
        this.dataSpesa = dataSpesa;
        this.scadenza = scadenza;
        this.id = id;
        if (counter < this.id) {
            counter = this.id;
        }
    }

    @Override
    public int getId() {
        
        return id;
    }

    @Override
    public BigDecimal getValoreSpesa() {
        
        return valoreSpesa;
    }

    @Override
    public void setValoreSpesa(BigDecimal valoreSpesa) {
        
        this.valoreSpesa = valoreSpesa;
    }

    @Override
    public LocalDate getDataSpesa() {
        
        return dataSpesa;
    }

    @Override
    public void setDataSpesa(LocalDate dataSpesa) {
        
        this.dataSpesa = dataSpesa;
    }

    public LocalDate getScadenza() {
        
        return scadenza;
    }

    public void setScadenza(LocalDate scadenza) {
        
        this.scadenza = scadenza;
    }

    @Override
    public String toString() {
        
        StringBuilder stringBuilder = new StringBuilder();
        
        stringBuilder.append("{ Spesa urgente\n")
                .append("[ ID: ").append(this.getId()).append(" ]\n")
                .append("[ Data spesa: ").append(this.getDataSpesa()).append(" ]\n")
                .append("[ Scadenza: ").append(this.getScadenza()).append(" ]\n")
                .append("[ Valore: ").append(this.getValoreSpesa()).append(" ] }");
        
        return stringBuilder.toString();
    }
    
    @Override
    public byte[] toByte(){
        
        StringBuilder stringBuilder = new StringBuilder();
        String values = stringBuilder.append(TYPE).append(";")
                .append(this.getId()).append(";")
                .append(this.getDataSpesa()).append(";")
                .append(this.getScadenza()).append(";")
                .append(this.getValoreSpesa()).append("\n")
                .toString();
        
        return values.getBytes();
    }
}