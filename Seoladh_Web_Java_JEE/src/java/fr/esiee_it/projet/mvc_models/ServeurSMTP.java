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
public class ServeurSMTP {
    //-Attributs de base
    private String nom;
    private String login;
    private String motDePasse;
    private String port;

    /**
     * Constructor
     */
    public ServeurSMTP(){}
    
    /**
     * Constructor
     * @param nom
     * @param login
     * @param motDePasse
     * @param port
     */
    public ServeurSMTP(String nom, String login, String motDePasse, String port){
        this.nom = nom;
        this.login = login;
        this.motDePasse = motDePasse;
        this.port = port;
    }

    // The methods of basic getter below.
    public String getNom() { return nom; }
    public String getLogin() { return login; }
    public String getMotDePasse() { return motDePasse; }
    public String getPort() { return port; }
    
    // The methods of basic setter below.
    public void setNom(String nom) { this.nom = nom; }
    public void setLogin(String login) { this.login = login; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }
    public void setPort(String port) { this.port = port; }

    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        return "ServeurSMTP{"
            +"nom="+nom+","
            +"login="+login+","
            +"motDePasse="+motDePasse+","
            +"port="+port
            +"}";
    }
}
