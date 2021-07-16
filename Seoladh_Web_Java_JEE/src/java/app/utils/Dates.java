/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ldumay
 */
public class Dates {
    
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-dd");
    
    /**
     * Constructor
     */
    public Dates(){}
    
    /**
     * Formatage d'une date de type String vers le type Date de forme : yyyy-MMM-dd.
     * @param date
     * @return Date
     * @throws java.text.ParseException
     */
    public Date conversionStringToDate(String date) throws ParseException{
        Date newDate = dateFormat.parse(date);
        return newDate;
    }
    
    /**
     * Formatage d'une date de type String vers le type Date de forme : yyyy-MMM-dd.
     * @param date
     * @return String
     * @throws java.text.ParseException
     */
    public String conversionDateToString(Date date) throws ParseException{
        String newDate = dateFormat.format(date);
        return newDate;
    }
}
