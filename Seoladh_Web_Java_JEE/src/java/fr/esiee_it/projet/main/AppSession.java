/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.esiee_it.projet.main;

import fr.esiee_it.projet.mvc_models.User;
import java.sql.SQLException;

/**
 *
 * @author ldumay
 */
public class AppSession {
    //-Attributs de base
    public User userConnect;
    
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
     * Permet de testé une session client.
     * @throws SQLException 
     */
    public void clientDemo() throws SQLException{
        userConnect = new User("superAdmin","superAdmin");
    }

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
