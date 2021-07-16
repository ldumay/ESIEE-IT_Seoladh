/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import app.network.ConnectBDD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ldumay
 */
public class Campaign {
    //-Attributs de base
    private int id;
    private String nom;
    private String description;
    private String dateDebut;
    private String dateFin;
    private String statut;
    private String mail;
    private int listeContacts_id;
    private ArrayList<ListContacts> listeContactsCollection;
    
    /**
     * Constructor
     */
    public Campaign(){}
    
    /**
     * Constructor
     * @param id
     * @param nom
     * @param description
     * @param dateDebut
     * @param dateFin
     * @param statut
     * @throws java.sql.SQLException
     */
    public Campaign(int id, String nom, String description, String dateDebut,
            String dateFin, String statut) throws SQLException{
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statut = statut;
        this.listeContactsCollection = getListeContactsCollection(this.id);
        if(listeContactsCollection.size()>0){
            this.listeContacts_id = listeContactsCollection.get(0).getId();
        }
    }
    
    /**
     * Récupération de la liste des contacts de la campagne
     * @param id
     * @return ArrayList<ListContacts>
     * @throws java.sql.SQLException
     */
    public ArrayList<ListContacts> getListeContactsCollection(int id) throws SQLException{
        ArrayList<ListContacts> listeContactsCollection = new ArrayList();
        
        // Variables nécessasires
        System.out.println("-> recupContactsCollection() : START");
        ConnectBDD connectBDD = new ConnectBDD();
        ResultSet datas = null;
        String sql = null;
        
        // = = = [ Connexion à la BDD ] = = =
        connectBDD.openConnexion();
        System.out.println("BDD : Open");

        // Récupération liste de contacts liés à la campagne
        sql = "SELECT "
            +"lc.`id`, "
            +"lc.`nom`, "
            +"lc.`description`, "
            +"lc.`date_start`, "
            +"lc.`date_end` "
            +"FROM "
            +"`campaigns` c, "
            +"`lists_contacts` lc, "
            +"`campaigns_and_lists_contacts` clc "
            +"WHERE "
            +"c.`id`=clc.`campaigns_id` "
            +"AND lc.`id`=clc.`list_contacts_id` "
            +"AND clc.`campaigns_id`="+id+";";
        System.out.println(sql);
        datas = connectBDD.getDatasBySQL(sql);
        while (datas.next()) {
            ListContacts contact = new ListContacts(datas.getInt(1), datas.getString(2), datas.getString(3),
                datas.getString(4), datas.getString(5));
            if(!listeContactsCollection.contains(contact)){
                listeContactsCollection.add(contact);
            }
        }
        
        // Lecture de données terminée
        connectBDD.closeConnexion();
        System.out.println("-> recupContactsCollection() : END");
        
        return listeContactsCollection;
    }

    // The methods of basic getter below.
    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getDescription() { return description; }
    public String getDateDebut() { return dateDebut; }
    public String getDateFin() { return dateFin; }
    public String getStatut() { return statut; }
    public String getMail() { return mail; }
    public int getListeContactsId() { return listeContacts_id; }
    public ArrayList<ListContacts> getListeContactsCollection() { return listeContactsCollection; }

    // The methods of basic setter below.
    public void setId(int id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setDescription(String description) { this.description = description; }
    public void setDateDebut(String dateDebut) { this.dateDebut = dateDebut; }
    public void setDateFin(String dateFin) { this.dateFin = dateFin; }
    public void setStatut(String statut) { this.statut = statut; }
    public void setMail(String mail){ this.mail = mail; }
    public void setListeContactsId(int listeContacts_id) { this.listeContacts_id = listeContacts_id; }
    public void setListeContactsCollection(ArrayList<ListContacts> listeContactsCollection) { this.listeContactsCollection = listeContactsCollection; }

    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        return "Campaign{"
            +"id="+id+", "
            +"nom="+nom+", "
            +"description="+description+", "
            +"dateDebut="+dateDebut+", "
            +"dateFin="+dateFin+","
            +"statut="+statut
            +'}';
    }
}
