/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.esiee_it.projet.mvc_connectors;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author ldumay
 */
public class ConnectBDD {
    //-Attributs de base
    private String bddName;
    private String bddLogin;
    private String bddPassword;
    private String bddIP;
    private String bddPort;
    private String bddUrl;
    
    //-Attributs du driver JDBC
    private final String strClassName = "com.mysql.jdbc.Driver";
    private Statement statement;
    private Connection conn;
    
    /**
     * Constructor
     */
    public ConnectBDD(){
        this.bddName = "univcergy22";
        this.bddLogin = "root";
        this.bddPassword = "root";
        this.bddIP = "localhost";
        this.bddPort = "3306";
        this.bddUrl = "jdbc:mysql://"+this.bddIP+":"+this.bddPort+"/"+this.bddName;
    }
    
    /**
     * Constructor
     * @param bddName
     * @param bddLogin
     * @param bddPassword
     * @param bddIP
     * @param bddPort
     */
    public ConnectBDD(String bddName, String bddLogin, String bddPassword, String bddIP, String bddPort){
        this.bddName = bddName;
        this.bddLogin = bddLogin;
        this.bddPassword = bddPassword;
        this.bddIP = bddIP;
        this.bddPort = bddPort;
        this.bddUrl = "jdbc:mysql://"+this.bddIP+":"+this.bddPort+"/"+this.bddName;
    }

    // The methods of basic getter below.
    public String getBddName() { return bddName; }
    public String getBddLogin() { return bddLogin; }
    public String getBddPassword() { return bddPassword; }
    public String getBddIP() { return bddIP; }
    public String getBddPort() { return bddPort; }
    public String getBddUrl() { return bddUrl; }
    
    // The methods of basic setter below.
    public void setBddName(String bddName) { this.bddName = bddName; }
    public void setBddLogin(String bddLogin) { this.bddLogin = bddLogin; }
    public void setBddPassword(String bddPassword) { this.bddPassword = bddPassword; }
    public void setBddIP(String bddIP) { this.bddIP = bddIP; }
    public void setBddPort(String bddPort) { this.bddPort = bddPort; }
    public void setBddUrl(String bddUrl) { this.bddUrl = bddUrl; }
    
    /**
     * toString
     * 
     * @return String
     */
    @Override
    public String toString() {
        return "ConnectBDD{"
            +"bddName="+bddName+","
            +"bddLogin="+bddLogin+","
            +"bddPassword="+bddPassword+","
            +"bddIP="+bddIP+","
            +"bddPort="+bddPort+","
            +"bddUrl=" + bddUrl
            +'}';
    }
    
    /**
     * toStringURL
     * 
     * @return String
     */
    public String toStringURL() {
        return "ConnectBDD{"
            +"strClassName="+strClassName+","
            +"}";
    }
    
}
