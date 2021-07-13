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
public class PieceJointe {
    //-Attributs de base
    private String nom;
    private String type;
    private String extension;

    /**
     * Constructor
     */
    public PieceJointe(){}
    
    /**
     * Constructor
     * @param nom
     * @param type
     * @param extension
     */
    public PieceJointe(String nom, String type, String extension) {
        this.nom = nom;
        this.type = type;
        this.extension = extension;
    }

    // The methods of basic getter below.
    public String getNom() { return nom; }
    public String getType() { return type; }
    public String getExtension() { return extension; }

    // The methods of basic setter below.
    public void setNom(String nom) { this.nom = nom; }
    public void setType(String type) { this.type = type; }
    public void setExtension(String extension) { this.extension = extension; }

    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        return "PieceJointe{"
            +"nom="+nom+","
            +"type="+type+","
            +"extension="+extension
            +"}";
    }
}
