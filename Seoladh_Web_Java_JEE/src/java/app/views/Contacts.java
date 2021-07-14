/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views;

import app.includes.ElementsPages;
import app.models.Contact;
import app.network.ConnectBDD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ldumay
 */
@WebServlet(name = "contacts", urlPatterns = {"/contacts"})
public class Contacts extends HttpServlet {
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Variables nécessasires
            ConnectBDD connectBDD = new ConnectBDD();
            ResultSet datas = null;
            String sql = null;
            String contentTable = "";
            
            // = = = [ Connexion à la BDD ] = = =
            connectBDD.openConnexion();
            System.out.println("BDD : Open");
            
            // = = = [ Ajout d'un contact ] = = =
            if(request.getParameter("contact-ajout")!=null){
                //-Validation Ajout Film
                if( (!request.getParameter("contact-ajout").isEmpty() && "contact-ajout".equals(request.getParameter("contact-ajout"))) 
                    && (!request.getParameter("nom").isEmpty() && !"".equals(request.getParameter("nom"))) ){
                    //-
                    System.out.println("-> Ajout de contact : START");
                    //-
                    Contact contactAAjouter = new Contact();
                    contactAAjouter.setNom(request.getParameter("nom"));
                    contactAAjouter.setPrenom(request.getParameter("prenom"));
                    contactAAjouter.setDateNaissance(request.getParameter("dateDeNaissance"));
                    contactAAjouter.setEmail1(request.getParameter("email1"));
                    contactAAjouter.setEmail2(request.getParameter("email2"));
                    contactAAjouter.setTel1(request.getParameter("tel1"));
                    contactAAjouter.setTel2(request.getParameter("tel2"));
                    contactAAjouter.setAdresse1(request.getParameter("adresse1"));
                    contactAAjouter.setAdresse2(request.getParameter("adresse2"));
                    contactAAjouter.setCodepostal(request.getParameter("codePostal"));
                    contactAAjouter.setVille(request.getParameter("ville"));
                    //-
                    sql = "INSERT INTO `contacts`"
                        + "(`nom`, `prenom`, `dateNaissance`, `email1`, `email2`, `tel1`, `tel2`, `adresse1`, `adresse2`, `codepostal`, `ville`, `blacklist`)"
                        + "VALUES"
                        + "("
                        + "\""+contactAAjouter.getNom()+"\","
                        + "\""+contactAAjouter.getPrenom()+"\","
                        + "\""+contactAAjouter.getDateNaissance()+"\","
                        + "\""+contactAAjouter.getEmail1()+"\","
                        + "\""+contactAAjouter.getEmail2()+"\","
                        + "\""+contactAAjouter.getTel1()+"\","
                        + "\""+contactAAjouter.getTel2()+"\","
                        + "\""+contactAAjouter.getAdresse1()+"\","
                        + "\""+contactAAjouter.getAdresse2()+"\","
                        + "\""+contactAAjouter.getCodepostal()+"\","
                        + "\""+contactAAjouter.getVille()+"\","
                        +"1"
                        + ");";
                    System.out.println(sql);
                    //-
                    connectBDD.setDatasBySQL(sql);
                    //-
                    System.out.println("-> Ajout de contact : END");
                }
            }
            // = = = [ Edition d'un contact ] = = =
            if(request.getParameter("contact-edit")!=null){
                //-Validation Ajout Film
                if( (!request.getParameter("contact-edit").isEmpty() && "contact-edit".equals(request.getParameter("contact-edit"))) 
                    && (!request.getParameter("nom").isEmpty() && !"".equals(request.getParameter("nom"))) ){
                    //-
                    System.out.println("-> Edition de contact : START");
                    //-
                    Contact contactAEditer = new Contact();
                    contactAEditer.setId(Integer.parseInt(request.getParameter("id")));
                    contactAEditer.setNom(request.getParameter("nom"));
                    //contactAEditer.setNom((request.getParameter("nom")!=null || !"".equals(request.getParameter("nom"))) ? request.getParameter("nom") : "");
                    contactAEditer.setNom(request.getParameter("nom"));
                    contactAEditer.setPrenom(request.getParameter("prenom"));
                    contactAEditer.setDateNaissance(request.getParameter("dateDeNaissance"));
                    contactAEditer.setEmail1(request.getParameter("email1"));
                    contactAEditer.setEmail2(request.getParameter("email2"));
                    contactAEditer.setTel1(request.getParameter("tel1"));
                    contactAEditer.setTel2(request.getParameter("tel2"));
                    contactAEditer.setAdresse1(request.getParameter("adresse1"));
                    contactAEditer.setAdresse2(request.getParameter("adresse2"));
                    contactAEditer.setCodepostal(request.getParameter("codePostal"));
                    contactAEditer.setVille(request.getParameter("ville"));
                    //-
                    sql = "UPDATE `contacts` SET"
                        +"`id`="+contactAEditer.getId()+","
                        +"`nom`=\""+contactAEditer.getNom()+"\","
                        +"`prenom`=\""+contactAEditer.getPrenom()+"\","
                        +"`dateNaissance`=\""+contactAEditer.getDateNaissance()+"\","
                        +"`email1`=\""+contactAEditer.getEmail1()+"\","
                        +"`email2`=\""+contactAEditer.getEmail2()+"\","
                        +"`tel1`=\""+contactAEditer.getTel1()+"\","
                        +"`tel2`=\""+contactAEditer.getTel2()+"\","
                        +"`adresse1`=\""+contactAEditer.getAdresse1()+"\","
                        +"`adresse2`=\""+contactAEditer.getAdresse2()+"\","
                        +"`codepostal`=\""+contactAEditer.getCodepostal()+"\","
                        +"`ville`=\""+contactAEditer.getVille()+"\""
                        +" WHERE `id`="+contactAEditer.getId()+";";
                    System.out.println(sql);
                    //-
                    connectBDD.setDatasBySQL(sql);
                    //-
                    System.out.println("-> Edition de contact : END");
                }
            }
            // = = = [ Suppression d'un contact ] = = =
            if(request.getParameter("contact-suppr-id")!=null){
                //-Validation Ajout Film
                if( (!request.getParameter("contact-suppr-id").isEmpty() && !"".equals(request.getParameter("contact-suppr-id"))) ){
                    //-
                    System.out.println("-> Edition de contact : START");
                    //-
                    sql = "DELETE FROM `lists_contacts_and_contacts` WHERE `contact_id`="+request.getParameter("contact-suppr-id")+";";
                    System.out.println(sql);
                    connectBDD.setDatasBySQL(sql);
                    //-
                    sql = "DELETE FROM `contacts` WHERE `id`="+request.getParameter("contact-suppr-id")+";";
                    System.out.println(sql);
                    //-
                    connectBDD.setDatasBySQL(sql);
                    //-
                    System.out.println("-> Edition de contact : END");
                }
            }
            // = = = [ Blacklist d'un contact ] = = =
            if(request.getParameter("blacklist-ajout")!=null){
                //-Validation Ajout Film
                if( (!request.getParameter("blacklist-ajout").isEmpty() && !"".equals(request.getParameter("blacklist-ajout"))) ){
                    //-
                    System.out.println("-> Blacklist ajout : START");
                    //-
                    sql = "UPDATE `contacts` SET `blacklist`=2 WHERE `id`="+request.getParameter("blacklist-ajout")+";";
                    System.out.println(sql);
                    connectBDD.setDatasBySQL(sql);
                    //-
                    System.out.println("-> Blacklist ajout : END");
                }
            }
        
            // = = = [ Lecture des contacts ] = = =
            System.out.println("-> lists de contacts : START");
            
            // Récupération des lists de contacts
            sql = "SELECT * FROM `contacts` WHERE blacklist=1;";
            System.out.println(sql);
            datas = connectBDD.getDatasBySQL(sql);
            while (datas.next()) {
                Contact contact = new Contact(datas.getInt(1), datas.getString(2), datas.getString(3),
                        datas.getString(4), datas.getString(5), datas.getString(6), datas.getString(7),
                        datas.getString(8), datas.getString(9), datas.getString(10), datas.getString(11),
                        datas.getString(12), datas.getString(13), datas.getString(14), datas.getInt(15));
                contentTable += "<tr>\n"
                            +"<td>"+contact.getNom()+"</td>\n"
                            +"<td>"+contact.getPrenom()+"</td>\n"
                            +"<td>"+contact.getDateNaissance()+"</td>\n"
                            +"<td>"+contact.getEmail1()+"</td>\n"
                            +"<td>"+contact.getEmail2()+"</td>\n";
                contentTable += "<td><a href=\"contacts-edit?contact-edit-id="+contact.getId()+"\">Modifier</a></td>\n";
                contentTable += "<td><a href=\"contacts?contact-suppr-id="+contact.getId()+"\">Supprimer</a></td>\n";
                contentTable += "<td><a href=\"contacts?blacklist-ajout="+contact.getId()+"\">Ajout</a></td>\n";
                contentTable +="</tr>\n";
            }
            System.out.println("-> lists de contacts : END");
            
            // = = = [ Fermeture de la connexion à la BDD ] = = =
            connectBDD.closeConnexion();
            System.out.println("BDD : Close");
            
            ElementsPages elements = new ElementsPages();
            //-
            String htmlContent = "";
            //-
            htmlContent = ""
                //_Head_
                +elements.getHeadBody()
                //_Body_Start_
                +"<!-- Body -->\n"
                +"<body>\n"
                +"<div class=\"container\">"
                //_Header_
                +elements.getHeaderContent()
                //_Navbar_
                +elements.getNavbarContent()
                //_Content_
                +"<div id=\"sub-container\">\n"
                    +"<div id=\"content\" class=\"row\">\n"
                        +"<div class=\"col-md-12 col-xs-12\">\n"
                            //_Breadcrumb_
                            +"<!-- Page - Breadcrumb -->\n"
                            +"<div class=\"row col-md-12 col-xs-12\">\n"
                                +"<nav style=\"--bs-breadcrumb-divider: '>';\" aria-label=\"breadcrumb\">\n"
                                    +"<ol class=\"breadcrumb\">\n"
                                        +"<li class=\"breadcrumb-item\"><a href=\"home\">Accueil</a></li>\n"
                                        +"<li class=\"breadcrumb-item active\">Contacts</li>\n"
                                    +"</ol>\n"
                                +"</nav>\n"
                            +"</div>\n"
                            //_Title_
                            +"<!-- Page - Title -->\n"
                            +"<div class=\"row col-md-12 col-xs-12 text-center\">"
                                +"<h3>Contacts</h3>"
                            +"</div>\n"
                            +"<hr>\n"
                            //_Content_
                            +"<!-- Page - Content -->\n"
                            +"<table class=\"table table-bordered text-center\">\n"
                                +"<thead>\n"
                                    +"<tr>\n"
                                        +"<th scope=\"col\">Nom</th>\n"
                                        +"<th scope=\"col\">Prénom</th>\n"
                                        +"<th scope=\"col\">Date de naissance</th>\n"
                                        +"<th scope=\"col\">Mail 1</th>\n"
                                        +"<th scope=\"col\">Mail 2</th>\n"
                                        +"<th scope=\"col\">Modifier</th>\n"
                                        +"<th scope=\"col\">Supprimer</th>\n"
                                        +"<th scope=\"col\">Liste noire</th>\n"
                                    +"</tr>\n"
                                +"</thead>\n"
                                +"<tbody>\n"
                                    +contentTable
                                +"</tbody>\n"
                            +"</table>"
                        +"</div>\n"
                    +"</div>\n"
                    +"<hr>"
                //_Footer_
                    +elements.getFooterContent()
                //_Body_End_
                    +"</div>"
                +"</div>"
                //_Foot_
                +elements.getFootBody()
                +"</html>";
            //-
            out.println(htmlContent);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(Contacts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(Contacts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
