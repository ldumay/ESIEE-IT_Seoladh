/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.esiee_it.projet.mvc_models;

import java.util.Collection;

/**
 *
 * @author ldumay
 */
public class ContactList {
    //-Attributs de base
    private String nom;
    private Collection<Contact> contactsCollection;
    
    /**
     * Constructor
     */
    public ContactList(){}
    
    /**
     * Constructor
     * @param nom
     * @param contactsCollection
     */
    public ContactList(String nom, Collection contactsCollection){
        this.nom = nom;
        this.contactsCollection = contactsCollection;
    }
    
    // The methods of basic getter below.
    public String getNom() { return nom; }
    public Collection getContactsCollection() { return contactsCollection; }

    // The methods of basic setter below.
    public void setNom(String nom) { this.nom = nom; }
    public void setContactsCollection(Collection contactsCollection) { this.contactsCollection = contactsCollection; }

    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        return "ContactList{"
            +"nom="+nom+","
            +"contactsCollection=" + contactsCollection
            +"}";
    }
}
