/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.esiee_it.projet.mvc_models;

import fr.esiee_it.projet.mvc_connectors.ConnectBDD;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ldumay
 */
public class User {
    //-Attributs de base
    private String identifiant;
    private String motDePasse;
    private int user_Id;
    private int contact_Id;
    private Contact contactInfos;
    
    /**
     * Constructor
     */
    public User(){}
    
    /**
     * Constructor
     * @param identifiant
     * @param motDePasse
     * @throws java.sql.SQLException
     */
    public User(String identifiant, String motDePasse) throws SQLException{
        this.identifiant = identifiant;
        this.motDePasse = motDePasse;
        this.contactInfos = getContactInfos(this.identifiant, this.motDePasse);
    }
    
    private Contact getContactInfos(String identifiant, String motDePasse) throws SQLException{
        System.out.println("-> getContactInfos() : START");
        
        // Variables nécessasires
        Contact contactInfos = null;
        ConnectBDD connectBDD = new ConnectBDD();
        ResultSet datas = null;
        String sql = null;
        
        connectBDD.openConnexion();
        
        // Récupération de l'id de l'utilisateur demandé
        sql = "SELECT id FROM `users` WHERE identifiant=\""+identifiant+"\" AND motdepasse=\""+motDePasse+"\";";
        System.out.println(sql);
        datas = connectBDD.getDatasBySQL(sql);
        while (datas.next()) {
            this.user_Id = datas.getInt(1);
        }
        
        // Vérification des informations de contact de l'utilicsateur dans la table de liaison pour récupérer l'id de contact lié 
        sql = "SELECT contact_id FROM `user_and_contact` WHERE user_id="+this.user_Id+";";
        System.out.println(sql);
        datas = connectBDD.getDatasBySQL(sql);
        while (datas.next()) {
            this.contact_Id = datas.getInt(1);
        }
        
        // Récuparation des données de contact de l'utilisateur par rapport à l'id de contact récupérer avant
        sql = "SELECT * FROM `contacts` WHERE id="+this.contact_Id+";";
        System.out.println(sql);
        datas = connectBDD.getDatasBySQL(sql);
        while (datas.next()) {
            contactInfos = new Contact(datas.getInt(1), datas.getString(2), datas.getString(3),
                    datas.getString(4), datas.getString(5), datas.getString(6), datas.getString(7),
                    datas.getString(8), datas.getString(9), datas.getString(10), datas.getString(11),
                    datas.getString(12), datas.getString(13), datas.getString(14));
        }
        
        // Lecture de données terminée
        connectBDD.closeConnexion();
        System.out.println("-> getContactInfos() : OK");
        return contactInfos;
    }
    
    // The methods of basic getter below.
    public String getIdentifiant() { return identifiant; }
    public String getMotDePasse() { return motDePasse; }
    public Contact getContactInfos() { return contactInfos; }

    // The methods of basic setter below.
    public void setIdentifiant(String identifiant) { this.identifiant = identifiant; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }
    public void setContactInfos(Contact contactInfos) { this.contactInfos = contactInfos; }

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
