/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.network;

import app.models.User;
import java.sql.SQLException;

/**
 *
 * @author ldumay
 */
public class AppSession {
    //-Attributs de base
    private User userConnect;
    
    /**
     * Constructor
     * @param identifiant
     * @param motDePasse
     * @throws java.sql.SQLException
     */
    public AppSession(String identifiant, String motDePasse) throws SQLException{
        this.userConnect = new User(identifiant, motDePasse);
    }

    // The methods of basic getter below.
    public User getUserConnect() { return userConnect; }

    // The methods of basic setter below.
    public void setUserConnect(User userConnect) { this.userConnect = userConnect; }

    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        return "AppSession{"
            +"userConnect="+userConnect
            +'}';
    }
}
