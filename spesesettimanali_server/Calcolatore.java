package spesesettimanali_server;

import java.math.BigDecimal;

/**
 *
 * @author Edoardo Zanoni
 */
public class Calcolatore {
    
    private static final int DECIMALS = 2;
    private static final int ROUND_TYPE = BigDecimal.ROUND_HALF_EVEN;
    private BigDecimal valueA;
    private BigDecimal valueB;
    
    public static BigDecimal getSum(BigDecimal a, BigDecimal b) {
        
        return a.add(b);
    }
    
    public static BigDecimal getDifference(BigDecimal a, BigDecimal b) {
        
        return a.subtract(b);
    }
    
    public static BigDecimal getMultiple(BigDecimal a, BigDecimal b) {
        
        return a.multiply(b).setScale(DECIMALS, ROUND_TYPE);
    }
    
    public static BigDecimal getDivision(BigDecimal a, BigDecimal b) {
        
        return a.divide(b, DECIMALS, ROUND_TYPE);
    }
}
