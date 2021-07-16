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
public class User {
    //-Attributs de base
    private int id;
    private String identifiant;
    private String motDePasse;
    private int user_Id;
    private int contact_Id;
    private int role_Id;
    //-
    private Contact contactInfos;
    private Role roleInfos;
    //-
    private ConnectBDD connectBDD = new ConnectBDD();
    private ResultSet datas = null;
    private String sql = null;
    
    /**
     * Constructor
     */
    public User(){}
    
    /**
     * Constructor
     * @param id
     * @param identifiant
     * @param motDePasse
     * @throws java.sql.SQLException
     */
    public User(int id, String identifiant, String motDePasse) throws SQLException{
        this.id = id;
        this.identifiant = identifiant;
        this.motDePasse = motDePasse;
    }
    
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
    
    /**
     * 
     * @param id
     * @return Role
     * @throws SQLException 
     */
    public Role getRoleInfo(int id) throws SQLException{
        System.out.println("-> getRoleInfo(id) : START");
        
        // Variables nécessasires
        contactInfos = null;
        connectBDD.openConnexion();
        
        // Récupération de l'id de l'utilisateur demandé
        sql = "SELECT * FROM `admin_roles` WHERE `id`="+id+";";
        System.out.println(sql);
        datas = connectBDD.getDatasBySQL(sql);
        while (datas.next()) {
            this.roleInfos = new Role(datas.getInt(1), datas.getString(2), datas.getString(3));
        }
        
        // Lecture de données terminée
        connectBDD.closeConnexion();
        System.out.println("-> getRoleInfo(id) : OK");
        return roleInfos;
    }
    
    /**
     * Récupération des information de contacts d'un utilisateur connu.
     * 
     * @param identifiant
     * @param motDePasse
     * @return
     * @throws SQLException 
     */
    private Contact getContactInfos(String identifiant, String motDePasse) throws SQLException{
        System.out.println("-> getContactInfos() : START");
        
        // Variables nécessasires
        contactInfos = null;
        connectBDD.openConnexion();
        
        // Récupération de l'id de l'utilisateur demandé
        sql = "SELECT id FROM `users` WHERE `identifiant`=\""+identifiant+"\" AND `motdepasse`=\""+motDePasse+"\";";
        System.out.println(sql);
        datas = connectBDD.getDatasBySQL(sql);
        while (datas.next()) {
            this.user_Id = datas.getInt(1);
        }
        // Vérification des informations de contact de l'utilicsateur dans la table de liaison pour récupérer l'id de contact lié 
        sql = "SELECT contact_id FROM `users_and_contacts` WHERE user_id="+this.user_Id+";";
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
                    datas.getString(12), datas.getString(13), datas.getString(14), datas.getInt(15));
        }
        // Lecture de données terminée
        connectBDD.closeConnexion();
        System.out.println("-> getContactInfos() : OK");
        return contactInfos;
    }
    
    // The methods of basic getter below.
    public int getId() { return id; }
    public String getIdentifiant() { return identifiant; }
    public String getMotDePasse() { return motDePasse; }
    public int getUser_Id() { return user_Id; }
    public int getContact_Id() { return contact_Id; }
    public int getRole_Id() { return role_Id; }
    public Contact getContactInfos() { return contactInfos; }

    // The methods of basic setter below.
    public void setId(int id) { this.id = id; }
    public void setIdentifiant(String identifiant) { this.identifiant = identifiant; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }
    public void setUser_Id(int user_Id) { this.user_Id = user_Id; }
    public void setContact_Id(int contact_Id) { this.contact_Id = contact_Id; }
    public void setRole_Id(int role_Id) { this.role_Id = role_Id; }
    public void setContactInfos(Contact contactInfos) { this.contactInfos = contactInfos; }

    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        return "User{"
            +"id="+id+","
            +"identifiant="+identifiant+","
            +"motDePasse=" + motDePasse
            +"}";
    }
}
