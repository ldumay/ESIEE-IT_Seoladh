/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import app.utils.Dates;

/**
 *
 * @author ldumay
 */
public class Contact {
    //-Attributs de base
    private Dates dates = new Dates();
    private int id;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String categorie;
    private String email1;
    private String email2;
    private String tel1;
    private String tel2;
    private String adresse1;
    private String adresse2;
    private String codepostal;
    private String ville;
    private String pays;
    private int blacklist;
    
    /**
     * Constructor
     */
    public Contact(){}
    
    /**
     * Constructor
     * @param id
     * @param nom
     * @param prenom
     * @param email1
     * @param dateNaissance
     * @param email2
     */
    public Contact(int id, String nom, String prenom, String dateNaissance,
            String email1, String email2){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.email1 = email1;
        this.email2 = email2;
    }
    
    /**
     * Constructor
     * @param id
     * @param nom
     * @param prenom
     * @param dateNaissance
     * @param categorie
     * @param email1
     * @param email2
     * @param tel1
     * @param tel2
     * @param adresse1
     * @param adresse2
     * @param codepostal
     * @param ville
     * @param pays
     * @param blacklist
     */
    public Contact(int id, String nom, String prenom, String dateNaissance,
            String categorie, String email1, String email2,
            String tel1, String tel2, String adresse1, String adresse2,
            String codepostal, String ville, String pays, int blacklist){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.categorie = categorie;
        this.email1 = email1;
        this.email2 = email2;
        this.tel1 = tel1;
        this.tel2 = tel2;
        this.adresse1 = adresse1;
        this.adresse2 = adresse2;
        this.codepostal = codepostal;
        this.ville = ville;
        this.pays = pays;
        this.blacklist = blacklist;
    }

    // The methods of basic getter below.
    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getDateNaissance() { return dateNaissance; }
    public String getCategorie() { return categorie; }
    public String getEmail1() {  return email1; }
    public String getEmail2() { return email2;  }
    public String getTel1() { return tel1; }
    public String getTel2() { return tel2; }
    public String getAdresse1() { return adresse1; }
    public String getAdresse2() { return adresse2; }
    public String getCodepostal() { return codepostal; }
    public String getVille() { return ville; }
    public String getPays() { return pays; }
    public int getBlacklist() { return blacklist; }
    
    // The methods of basic setter below.
    public void setId(int id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public void setDateNaissance(String dateNaissance) { this.dateNaissance = dateNaissance; }
    public void setCategorie(String categorie) { this.categorie = categorie; }
    public void setEmail1(String email1) { this.email1 = email1; }
    public void setEmail2(String email2) { this.email2 = email2; }
    public void setTel1(String tel1) { this.tel1 = tel1; }
    public void setTel2(String tel2) { this.tel2 = tel2; }
    public void setAdresse1(String adresse1) { this.adresse1 = adresse1; }
    public void setAdresse2(String adresse2) { this.adresse2 = adresse2; }
    public void setCodepostal(String codepostal) { this.codepostal = codepostal; }
    public void setVille(String ville) { this.ville = ville; }
    public void setPays(String pays) { this.pays = pays; }
    public void setBlacklist(int blacklist) { this.blacklist = blacklist; }
    
    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        return "Contact{"
            +"id"+id+","
            +"nom="+nom+","
            +"prenom="+prenom+","
            +"dateNaissance="+dateNaissance+","
            +"categorie="+categorie+","
            +"email1="+email1+","
            +"email2="+email2+","
            +"tel="+tel1+","
            +"tel="+tel2+","
            +"adresse1="+adresse1+","
            +"adresse2="+adresse2+","
            +"codepostal="+codepostal+","
            +"ville="+ville+","
            +"pays="+pays+","
            +"blacklist="+blacklist
            +"}";
    }
}
