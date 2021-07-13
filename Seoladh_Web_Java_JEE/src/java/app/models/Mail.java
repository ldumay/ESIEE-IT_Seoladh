/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import java.util.Collection;

/**
 *
 * @author ldumay
 */
public class Mail { 
    //-Attributs de base
    private String mode;
    private String mailExpediteur;
    private Collection<Contact> listeContactsDestinatairesCollection;
    private String mailObjet;
    private String mailContenu;
    private Collection<PieceJointe> listePiecesJointesCollection;
    private Contact destinataireContact;
    
    /**
     * Constructor
     */
    public Mail(){}
    
    /**
     * Constructor
     * @param mode
     * @param mailExpediteur
     * @param listeContactsDestinatairesCollection
     * @param mailObjet
     * @param mailContenu
     * @param listePiecesJointesCollection
     * @param destinataireContact
     */
    public Mail(String mode, String mailExpediteur, Collection listeContactsDestinatairesCollection,
            String mailObjet, String mailContenu, Collection listePiecesJointesCollection, Contact destinataireContact){
        this.mode = mode;
        this.mailExpediteur = mailExpediteur;
        this.listeContactsDestinatairesCollection = listeContactsDestinatairesCollection;
        this.mailObjet = mailObjet;
        this.mailContenu = mailContenu;
        this.listePiecesJointesCollection = listePiecesJointesCollection;
        this.destinataireContact = destinataireContact;
    }

    // The methods of basic getter below.
    public String getMode() { return mode; }
    public String getMailExpediteur() { return mailExpediteur; }
    public Collection<Contact> getListeContactsDestinatairesCollection() { return listeContactsDestinatairesCollection; }
    public String getMailObjet() { return mailObjet; }
    public String getMailContenu() { return mailContenu; }
    public Collection<PieceJointe> getListePiecesJointesCollection() { return listePiecesJointesCollection; }
    public Contact getDestinataireContact() { return destinataireContact; }
    
    // The methods of basic setter below.
    public void setMode(String mode) { this.mode = mode; }
    public void setMailExpediteur(String mailExpediteur) { this.mailExpediteur = mailExpediteur; }
    public void setListeContactsDestinatairesCollection(Collection<Contact> listeContactsDestinatairesCollection) { this.listeContactsDestinatairesCollection = listeContactsDestinatairesCollection; }
    public void setMailObjet(String mailObjet) { this.mailObjet = mailObjet; }
    public void setMailContenu(String mailContenu) { this.mailContenu = mailContenu; }
    public void setListePiecesJointesCollection(Collection<PieceJointe> listePiecesJointesCollection) { this.listePiecesJointesCollection = listePiecesJointesCollection; }
    public void setDestinataireContact(Contact destinataireContact) { this.destinataireContact = destinataireContact; }
    
    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        return "Mail{"
            +"mode="+mode+","
            +"mailExpediteur="+mailExpediteur + ","
            +"listeContactsDestinatairesCollection="+listeContactsDestinatairesCollection+","
            +"mailObjet="+mailObjet+","
            +"mailContenu=" + mailContenu+","
            +"listePiecesJointesCollection="+listePiecesJointesCollection+","
            +"destinataireContact="+destinataireContact
            +"}";
    }
}
