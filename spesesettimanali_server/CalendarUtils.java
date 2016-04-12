package spesesettimanali_server;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author Edoardo Zanoni
 */
public class CalendarUtils {
    
    public static final int FIRST_WEEK_DAY = Calendar.MONDAY;
    
    public static int getDateDay(LocalDate date) {
        
        return date.getDayOfWeek().getValue();
    }
    
    public static int getDateDay(String date) throws ParseException {
        
        return CalendarUtils.stringToDate(date).getDayOfWeek().getValue();
    }
    
    public static int getDateWeek(LocalDate date) {
        
        TemporalField week = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear(); 
        return date.get(week);
    }
    
    public static int getDateWeek(String date) throws ParseException {
        
        TemporalField week = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear(); 
        return CalendarUtils.stringToDate(date).get(week);
    }
    
    public static int getDateYear(LocalDate date) {
        
        return date.getYear();
    }
    
    public static int getDateYear(String date) throws ParseException {
        
        return CalendarUtils.stringToDate(date).getYear();
    }
    
    public static LocalDate stringToDate(String s) throws ParseException {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/y");
        return LocalDate.parse(s, formatter);
    }
    
    public static LocalDate stringToDate(String s, String format) throws ParseException {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDate.parse(s, formatter);
    }
    
    public static String dateToString(LocalDate data) throws ParseException {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/y");
        return String.valueOf(data.format(formatter));
    }
    
    public static String dateToString(LocalDate data, String format) throws ParseException {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return String.valueOf(data.format(formatter));
    }
    
    public static boolean equals(LocalDate data1, LocalDate data2) throws ParseException {
        
        return CalendarUtils.dateToString(data1).equals(CalendarUtils.dateToString(data2));
    }
    
    public static boolean equals(String data1, String data2) throws ParseException {
        
        return data1.equals(data2);
    }
}