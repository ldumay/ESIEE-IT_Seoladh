/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import app.network.ConnectBDD;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ldumay
 */
public class ServeurSMTP {
    //-Attributs de base
    private String nomDuServeur;
    private String adresseDuServeur;
    private String portDuServeur;
    private String adresseEmailDuServeur;
    private String motDePasseDuServeur;

    /**
     * Constructor
     * @throws java.sql.SQLException
     */
    public ServeurSMTP() throws SQLException{
        // Variables nécessasires
        ConnectBDD connectBDD = new ConnectBDD();
        ResultSet datas = null;
        String sql = null;
        String contentTable = "";

        // = = = [ Lecture des contacts ] = = =
        System.out.println("-> Récupération serveur STMP : START");

        // = = = [ Connexion à la BDD ] = = =
        connectBDD.openConnexion();
        System.out.println("BDD : Open");

        // Récupération des lists de contacts
        sql = "SELECT `nom_du_serveur`, `adresse_du_serveur`, "
            +"`port_du_serveur`, `adresse_email_du_serveur`, `mot_de_passe_du_serveur` "
            +"FROM `admin_server`;";
        System.out.println(sql);
        datas = connectBDD.getDatasBySQL(sql);
        while (datas.next()) {
            this.nomDuServeur = datas.getString(1);
            this.adresseDuServeur = datas.getString(2);
            this.portDuServeur = datas.getString(3);
            this.adresseEmailDuServeur = datas.getString(4);
            this.motDePasseDuServeur = datas.getString(5);
        }
        // Lecture de données terminée
        connectBDD.closeConnexion();
        System.out.println("-> Récupération serveur STMP : END");
    }
    
    /**
     * Constructor
     * @param nomDuServeur
     * @param adresseDuServeur
     * @param portDuServeur
     * @param adresseEmailDuServeur
     * @param motDePasseDuServeur
     */
    public ServeurSMTP(String nomDuServeur, String adresseDuServeur, String portDuServeur, String adresseEmailDuServeur, String motDePasseDuServeur){
        this.nomDuServeur = nomDuServeur;
        this.adresseDuServeur = adresseDuServeur;
        this.portDuServeur = portDuServeur;
        this.adresseEmailDuServeur = adresseEmailDuServeur;
        this.motDePasseDuServeur = motDePasseDuServeur;
    }

    // The methods of basic getter below.
    public String getNomDuServeur() { return nomDuServeur; }
    public String getAdresseDuServeur() { return adresseDuServeur; }
    public String getPortDuServeur() { return portDuServeur; }
    public String getAdresseEmailDuServeur() { return adresseEmailDuServeur; }
    public String getMotDePasseDuServeur() { return motDePasseDuServeur; }
    
    // The methods of basic setter below.
    public void setNomDuServeur(String nomDuServeur) { this.nomDuServeur = nomDuServeur; }
    public void setAdresseDuServeur(String adresseDuServeur) { this.adresseDuServeur = adresseDuServeur; }
    public void setPortDuServeur(String portDuServeur) { this.portDuServeur = portDuServeur; }
    public void setAdresseEmailDuServeur(String adresseEmailDuServeur) { this.adresseEmailDuServeur = adresseEmailDuServeur; }
    public void setMotDePasseDuServeur(String motDePasseDuServeur) { this.motDePasseDuServeur = motDePasseDuServeur; }

    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        return "ServeurSMTP{"
            +"nomDuServeur="+nomDuServeur+","
            +"adresseDuServeur="+adresseDuServeur+","
            +"portDuServeur="+portDuServeur+","
            +"adresseEmailDuServeur="+adresseEmailDuServeur+","
            +"motDePasseDuServeur="+motDePasseDuServeur
            +"}";
    }
}
