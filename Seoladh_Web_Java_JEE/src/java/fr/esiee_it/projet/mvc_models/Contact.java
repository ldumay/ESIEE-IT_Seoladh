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
public class Contact {
    //-Attributs de base
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String categorie;
    private String email1;
    private String email2;
    private String tel;
    private String adresse;
    
    /**
     * Constructor
     */
    public Contact(){}
    
    /**
     * Constructor
     * @param nom
     * @param prenom
     * @param dateNaissance
     * @param categorie
     * @param email1
     * @param email2
     * @param tel
     * @param adresse
     */
    public Contact(String nom, String prenom, String dateNaissance, String categorie, String email1, String email2, String tel, String adresse){
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.categorie = categorie;
        this.email1 = email1;
        this.email2 = email2;
        this.tel = tel;
        this.adresse = adresse;
    }

    // The methods of basic getter below.
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getDateNaissance() { return dateNaissance; }
    public String getCategorie() { return categorie; }
    public String getEmail1() {  return email1; }
    public String getEmail2() { return email2;  }
    public String getTel() { return tel; }
    public String getAdresse() { return adresse; }
    
    // The methods of basic setter below.
    public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public void setDateNaissance(String dateNaissance) { this.dateNaissance = dateNaissance; }
    public void setCategorie(String categorie) { this.categorie = categorie; }
    public void setEmail1(String email1) { this.email1 = email1; }
    public void setEmail2(String email2) { this.email2 = email2; }
    public void setTel(String tel) { this.tel = tel; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        return "Contact{"
            +"nom="+nom+","
            +"prenom="+prenom+","
            +"dateNaissance="+dateNaissance+","
            +"categorie="+categorie+","
            +"email1="+email1+","
            +"email2="+email2+","
            +"tel="+tel+","
            +"adresse="+adresse
            +"}";
    }
}
