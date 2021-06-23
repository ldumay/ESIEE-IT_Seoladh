/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.esiee_it.projet.mvc_models;

/**
 *
 * @author ldumay
 */
public class User {
    //-Attributs de base
    private String identifiant;
    private String motDePasse;
    
    /**
     * Constructor
     */
    public User(){}
    
    /**
     * Constructor
     * @param identifiant
     * @param motDePasse
     */
    public User(String identifiant, String motDePasse){
        this.identifiant = identifiant;
        this.motDePasse = motDePasse;
    }
    
    // The methods of basic getter below.
    public String getIdentifiant() { return identifiant; }
    public String getMotDePasse() { return motDePasse; }

    // The methods of basic setter below.
    public void setIdentifiant(String identifiant) { this.identifiant = identifiant; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }

    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        return "User{"
            +"identifiant="+identifiant+","
            +"motDePasse=" + motDePasse
            +"}";
    }
}
