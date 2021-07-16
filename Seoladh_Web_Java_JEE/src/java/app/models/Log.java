/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

/**
 *
 * @author ldumay
 */
public class Log {
    
    private int id;
    private String date;
    private String ip;
    
    /**
     * Constructor
     */
    public Log(){}
    
    /**
     * Constructor
     * @param id
     * @param date
     * @param ip
     */
    public Log(int id, String date, String ip){
        this.id = id;
        this. date = date;
        this.ip = ip;
    }

    // The methods of basic setter below.
    public int getId() { return id; }
    public String getDate() { return date; }
    public String getIp() { return ip; }

    // The methods of basic getter below.
    public void setId(int id) { this.id = id; }
    public void setDate(String date) { this.date = date; }
    public void setIp(String ip) { this.ip = ip; }
    
    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        return "Log{"
            +"id="+id+", "
            +"date="+date+", "
            +"ip="+ip
            +'}';
    }
}
