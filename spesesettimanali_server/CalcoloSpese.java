package spesesettimanali_server;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Edoardo Zanoni
 */
public class CalcoloSpese {
    
    public static BigDecimal calcoloSettimana(ArrayList<SpesaStandard> spese, int week, int year) {
       
        LocalDate date;
        BigDecimal totale = new BigDecimal("0");
        SpesaStandard temp;
        
        Iterator<SpesaStandard> it = spese.iterator();
        while (it.hasNext()) {
            temp = it.next();
            if ((CalendarUtils.getDateWeek(temp.getDataSpesa()) == week) && (CalendarUtils.getDateYear(temp.getDataSpesa()) == year)) {
                totale = Calcolatore.getSum(totale, temp.getValoreSpesa());
            }
        }
        
        return totale;
    }
    
    public static BigDecimal calcoloSettimana(ArrayList<SpesaStandard> spese, LocalDate date) {
       
        BigDecimal totale = new BigDecimal("0");
        SpesaStandard temp;
        
        Iterator<SpesaStandard> it = spese.iterator();
        while (it.hasNext()) {
            temp = it.next();
            if ((CalendarUtils.getDateWeek(temp.getDataSpesa()) == CalendarUtils.getDateWeek(date)) && ((CalendarUtils.getDateYear(temp.getDataSpesa())) == CalendarUtils.getDateYear(date))) {
                totale = Calcolatore.getSum(totale, temp.getValoreSpesa());
            }
        }
        
        return totale;
    }
    
    public static BigDecimal calcoloDateRange(ArrayList<SpesaStandard> spese, LocalDate dateMin, LocalDate dateMax) {
       
        BigDecimal totale = new BigDecimal("0");
        SpesaStandard temp;
        
        Iterator<SpesaStandard> it = spese.iterator();
        while (it.hasNext()) {
            temp = it.next();
            if ((temp.getDataSpesa().compareTo(dateMin))>=0 || (temp.getDataSpesa().compareTo(dateMin))<=0) {
                totale = Calcolatore.getSum(totale, temp.getValoreSpesa());
            }
        }
        
        return totale;
    }
    
//    public static BigDecimal calcoloWeekRange(ArrayList<Spesa> spese, int weekMin, int weekMax) {
//       
//        BigDecimal totale = new BigDecimal("0");
//        SpesaStandard temp;
//        
//        Iterator<Spesa> it = spese.iterator();
//        while (it.hasNext()) {
//            temp = it.next();
//            if ((CalendarUtils.getDateWeek(temp.getDataSpesa()))>=0 || (temp.getDataSpesa().compareTo(dateMin))<=0) {
//                totale = Calcolatore.getSum(totale, temp.getValoreSpesa());
//            }
//        }
//        
//        return totale;
//    }
}
