/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import app.utils.Dates;
import java.util.Collection;

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
    private Collection<Contact> contactsCollection;
    
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
     */
    public ListContacts(int id, String nom, String description, String dateDebut, String dateFin){
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }
    
    /**
     * Constructor
     * @param nom
     * @param contactsCollection
     */
    public ListContacts(String nom, Collection contactsCollection){
        this.nom = nom;
        this.contactsCollection = contactsCollection;
    }
    
    // The methods of basic getter below.
    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getDescription() { return description; }
    public String getDateDebut() { return dateDebut; }
    public String getDateFin() { return dateFin; }
    public Collection getContactsCollection() { return contactsCollection; }

    // The methods of basic setter below.
    public void setId(int id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setDescription(String description) { this.description = description; }
    public void setDateDebut(String dateDebut) { this.dateDebut = dateDebut; }
    public void setDateFin(String dateFin) { this.dateFin = dateFin; }
    public void setContactsCollection(Collection contactsCollection) { this.contactsCollection = contactsCollection; }

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
