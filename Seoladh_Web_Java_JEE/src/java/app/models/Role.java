/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

/**
 *
 * @author ldumay
 */
public class Role {
    
    private int id;
    private String nom;
    private String description;
    
    /**
     * Constructor
     */
    public Role(){}
    
    /**
     * Constructor
     * @param id
     * @param nom
     * @param description
     */
    public Role(int id, String nom, String description){
        this.id = id;
        this.nom = nom;
        this.description = description;
    }

    // The methods of basic getter below.
    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getDescription() { return description; }
    
    // The methods of basic setter below.
    public void setId(int id) { this.id = id; }
    public void setNom(String nom) { this.nom = nom; }
    public void setDescription(String description) { this.description = description; }

    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        return "Role{"
            +"id="+id+","
            +"nom="+nom+", "
            +"description="+description
            +'}';
    }
}
