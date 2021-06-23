/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.esiee_it.projet.mvc_models;

import java.util.Collection;
import java.util.Date;

/**
 *
 * @author ldumay
 */
public class Campaign {
    //-Attributs de base
    private String nom;
    private Date dateCreation;
    private Collection<Contact> listeContactsCollection;
    private Date dateEnvoi;
    private int delaiEnvoiEmailParLot;
    
    /**
     * Constructor
     */
    public Campaign(){}
    
    /**
     * Constructor
     * @param nom
     * @param dateCreation
     * @param listeContactsCollection
     * @param dateEnvoi
     * @param delaiEnvoiEmailParLot
     */
    public Campaign(String nom, Date dateCreation, Collection listeContactsCollection, Date dateEnvoi, int delaiEnvoiEmailParLot){
        this.nom = nom;
        this.dateCreation = dateCreation;
        this.listeContactsCollection = listeContactsCollection;
        this.dateEnvoi = dateEnvoi;
        this.delaiEnvoiEmailParLot = delaiEnvoiEmailParLot;
    }

    // The methods of basic getter below.
    public String getNom() { return nom; }
    public Date getDateCreation() { return dateCreation; }
    public Collection getListeContactsCollection() { return listeContactsCollection; }
    public Date getDateEnvoi() { return dateEnvoi; }
    public int getDelaiEnvoiEmailParLot() { return delaiEnvoiEmailParLot; }
    
    // The methods of basic setter below.
    public void setNom(String nom) { this.nom = nom; }
    public void setDateCreation(Date dateCreation) { this.dateCreation = dateCreation; }
    public void setListeContactsCollection(Collection listeContactsCollection) { this.listeContactsCollection = listeContactsCollection; }
    public void setDateEnvoi(Date dateEnvoi) { this.dateEnvoi = dateEnvoi; }
    public void setDelaiEnvoiEmailParLot(int delaiEnvoiEmailParLot) { this.delaiEnvoiEmailParLot = delaiEnvoiEmailParLot; }

    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        return "Campaign{"
            +"nom="+nom + ","
            +"dateCreation="+dateCreation+","
            +"listeContactsCollection="+listeContactsCollection + ","
            +"dateEnvoi="+dateEnvoi + ","
            +"delaiEnvoiEmailParLot="+delaiEnvoiEmailParLot
            +"}";
    }
}
