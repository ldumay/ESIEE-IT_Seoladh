/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import app.network.ConnectBDD;
import app.utils.Dates;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ldumay
 */
public class ListContacts {
    //-Attributs de base
    private Dates dates = new Dates();
    private int id;
    private String nom;
    private String description;
    private String dateDebut;
    private String dateFin;
    private ArrayList<Contact> contactsCollection;
    
    /**
     * Constructor
     */
    public ListContacts(){}
    
    /**
     * Constructor
     * @param id
     * @param nom
     * @param description
     * @param dateDebut
     * @param dateFin
     * @throws java.sql.SQLException
     */
    public ListContacts(int id, String nom, String description, String dateDebut, String dateFin) throws SQLException{
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.contactsCollection = recupContactsCollection(this.id);
    }
    
    /**
     * Constructor
     * @param nom
     * @param contactsCollection
     */
    public ListContacts(String nom, ArrayList contactsCollection){
        this.nom = nom;
        this.contactsCollection = contactsCollection;
    }
    
    private ArrayList recupContactsCollection(int id) throws SQLException{
        ArrayList<Contact> contactsCollection = new ArrayList();
        
        // Variables nécessasires
        System.out.println("-> recupContactsCollection() : START");
        ConnectBDD connectBDD = new ConnectBDD();
        ResultSet datas = null;
        String sql = null;
        
        // = = = [ Connexion à la BDD ] = = =
        connectBDD.openConnexion();
        System.out.println("BDD : Open");

        // Récupération des contacts liés à la liste
        sql = "SELECT "
                +"c.`id`, "
                +"c.`nom`, "
                +"c.`prenom`, "
                +"c.`dateNaissance`, "
                +"c.`categorie`, "
                +"c.`email1`, "
                +"c.`email2`, "
                +"c.`tel1`, "
                +"c.`tel2`, "
                +"c.`adresse1`, "
                +"c.`adresse2`, "
                +"c.`codepostal`, "
                +"c.`ville`, "
                +"c.`pays`, "
                +"c.`blacklist` "
                +"FROM "
                +"`contacts` c, "
                +"`lists_contacts` lc, "
                +"`lists_contacts_and_contacts` lcc "
                +" "
                +"WHERE c.`id`=lcc.`id` "
                +"AND lc.`id`=lcc.`list_contacts_id` "
                +"AND lcc.`list_contacts_id`="+id+""
                + ";";
        System.out.println(sql);
        datas = connectBDD.getDatasBySQL(sql);
        while (datas.next()) {
            Contact contact = new Contact(datas.getInt(1), datas.getString(2), datas.getString(3),
                datas.getString(4), datas.getString(5), datas.getString(6), datas.getString(7),
                datas.getString(8), datas.getString(9), datas.getString(10), datas.getString(11),
                datas.getString(12), datas.getString(13), datas.getString(14), datas.getInt(15));
            contactsCollection.add(contact);
        }
        
        // Lecture de données terminée
        connectBDD.closeConnexion();
        System.out.println("-> recupContactsCollection() : END");
        
        return contactsCollection;
    }
    
    // The methods of basic getter below.
    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getDescription() { return description; }
    public String getDateDebut() { return dateDebut; }
    public String getDateFin() { return dateFin; }
    public ArrayList getContactsCollection() { return contactsCollection; }

    // The methods of basic setter below.
    public void setId(int id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setDescription(String description) { this.description = description; }
    public void setDateDebut(String dateDebut) { this.dateDebut = dateDebut; }
    public void setDateFin(String dateFin) { this.dateFin = dateFin; }
    public void setContactsCollection(ArrayList contactsCollection) { this.contactsCollection = contactsCollection; }

    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        return "ContactList{"
            +"nom="+nom+","
            +"description="+description+","
            +"dateDebut="+dateDebut+","
            +"dateFin="+dateFin+","
            +"contactsCollection=" + contactsCollection
            +"}";
    }
}
