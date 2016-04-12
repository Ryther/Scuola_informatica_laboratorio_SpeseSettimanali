package spesesettimanali_server;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Edoardo Zanoni
 */
public interface Spesa {

    public int getId();
    public BigDecimal getValoreSpesa();
    public void setValoreSpesa(BigDecimal valoreSpesa);
    public LocalDate getDataSpesa();
    public void setDataSpesa(LocalDate dataSpesa);
    @Override
    public String toString();
    public byte[] toByte();
}