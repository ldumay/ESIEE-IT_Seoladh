/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views;

import app.includes.ElementsPages;
import app.models.Contact;
import app.models.ListContacts;
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
@WebServlet(name = "lists-contacts-suppr", urlPatterns = {"/lists-contacts-suppr"})
public class ListsContactsSuppr extends HttpServlet {
    
    ListContacts listContactsSelectionnee = new ListContacts();
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
            String optionsListesContacts = "";
            
            // = = = [ Lecture des contacts ] = = =
            System.out.println("-> lists de contacts : START");
            
            // = = = [ Connexion à la BDD ] = = =
            connectBDD.openConnexion();
            System.out.println("BDD : Open");
            
            // = = = [ Ajout d'un contact ] = = =
            if(request.getParameter("list-contacts-id")!=null){
                if( (!request.getParameter("list-contacts-id").isEmpty() && !"".equals(request.getParameter("list-contacts-id"))) ){
                    //-
                    System.out.println("-> Ajout une liste de contact : START");
                    //-
                    
                    // Récupération de lists de contacts sélectionnée
                    sql = "SELECT * FROM `lists_contacts` WHERE id="+request.getParameter("list-contacts-id")+";";
                    System.out.println(sql);
                    datas = connectBDD.getDatasBySQL(sql);
                    while (datas.next()) {
                        listContactsSelectionnee = new ListContacts(datas.getInt(1), datas.getString(2), datas.getString(3),
                            datas.getString(4), datas.getString(5));
                    }
                    
                    // Récupération des contacts de la liste de contacts sélectionnés
                    sql = "SELECT "
                        +"c.`id`, c.`nom`, c.`prenom`, c.`dateNaissance`, c.`categorie`, "
                        +"c.`email1`, c.`email2`, c.`tel1`, c.`tel2`, c.`adresse1`, c.`adresse2`, "
                        +"c.`codepostal`, c.`ville`, c.`pays`, c.`blacklist`\n"
                        +"FROM `lists_contacts` lc, `lists_contacts_and_contacts` lcc, `contacts` c\n"
                        +"WHERE lcc.list_contacts_id=lc.id\n"
                        +"AND lcc.contact_id=c.id\n"
                        +"AND c.blacklist=1\n"
                        +"AND lc.id="+listContactsSelectionnee.getId()+"\n"
                        +"ORDER BY c.id;";
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
                            +"<td>"+contact.getEmail2()+"</td>\n"
                            +"</tr>\n";
                    }
                    
                    // Récupération des lists de contacts
                    sql = "SELECT * FROM `lists_contacts`;";
                    System.out.println(sql);
                    datas = connectBDD.getDatasBySQL(sql);
                    while (datas.next()) {
                        ListContacts listContacts = new ListContacts(datas.getInt(1), datas.getString(2), datas.getString(3),
                            datas.getString(4), datas.getString(5));
                        if(listContacts.getId()!=listContactsSelectionnee.getId()){
                            optionsListesContacts += "<option value=\""+listContacts.getId()+"\">"+listContacts.getNom()+"</option>\n";
                        }
                    }
                    
                    //-
                    System.out.println("-> Ajout une liste de contact : END");
                }
            }
            
            // Lecture de données terminée
            connectBDD.closeConnexion();
            System.out.println("-> lists de contacts : END");
        
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
                                        +"<li class=\"breadcrumb-item active\">Listes de contacts</li>\n"
                                    +"</ol>\n"
                                +"</nav>\n"
                            +"</div>\n"
                            //_Title_
                            +"<!-- Page - Title -->\n"
                            +"<div class=\"row col-md-12 col-xs-12 text-center\">"
                                +"<h3>Listes de contacts</h3>"
                            +"</div>\n"
                            +"<hr>\n"
                            //_Content_
                            +"<!-- Page - Content -->\n"
                            +"<div class=\"row col-md-12 col-xs-12 text-center\">"
                                +"<p>La liste des contacts de la liste <b>\""+listContactsSelectionnee.getNom()+"\"</b>.</p>"
                                +"<br><br>"
                                +"<table class=\"table table-bordered text-center\">\n"
                                    +"<thead>\n"
                                        +"<tr>\n"
                                            +"<th scope=\"col\">Nom</th>\n"
                                            +"<th scope=\"col\">Prénom</th>\n"
                                            +"<th scope=\"col\">Date de naissance</th>\n"
                                            +"<th scope=\"col\">Mail 1</th>\n"
                                            +"<th scope=\"col\">Mail 2</th>\n"
                                        +"</tr>\n"
                                    +"</thead>\n"
                                    +"<tbody>\n"
                                        +contentTable
                                    +"</tbody>\n"
                                +"</table>"
                            +"</div>\n"
                            +"\n"
                    
                            +"<!-- Nouvelle_ListDeContacts -->\n"
                            +"<form method=\"post\" action=\"lists-contacts\">\n"
                                +"<div class=\"row col-md-12 col-xs-12\">\n"
                                    +"<div class=\"row col-md-1 col-xs-1\"></div>\n"
                                    +"<div class=\"row col-md-9 col-xs-9 text-right\">\n"
                                        +"<!-- IdDuContact -->\n"
                                        +"<div class=\"col-sm-6\" style=\"display:none;\">"
                                            +"<input type=\"text\" class=\"form-control\" id=\"ancienne-liste-contacts\" name=\"ancienne-liste-contacts\" value=\""+listContactsSelectionnee.getId()+"\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"nouvelle-liste-contacts\">Choix de la nouvelle liste</label>\n"
                                        +"<div class=\"col-sm-6\">\n"
                                        +"<select class=\"form-select\" id=\"nouvelle-liste-contacts\" name=\"nouvelle-liste-contacts\">\n"
                                            +"<option selected>Choisissez une liste de contact</option>\n"
                                            +optionsListesContacts
                                        +"</select>\n"
                                    +"</div>\n"
                                    +"<div class=\"row col-md-1 col-xs-1\"></div>"
                                    +"<br><br>"
                                    +"\n"
                                    +"<div class=\"row col-md-12 col-xs-12\">\n"
                                        +"<div class=\"row col-md-4 col-xs-4\"></div>\n"
                                        +"<div class=\"row col-md-4 col-xs-4 text-center\">\n"
                                            +"<button type=\"submit\" class=\"btn btn-success\" name=\"list-contacts-suppr-id\" value=\"list-contacts-suppr-id\">Valider la nouvelle liste de contacts</button>\n"
                                        +"</div>\n"
                                        +"<div class=\"row col-md-4 col-xs-4\"></div>\n"
                                    +"</div>\n"
                                +"</div>\n"
                            +"</form>"
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
            Logger.getLogger(ListsContactsSuppr.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ListsContactsSuppr.class.getName()).log(Level.SEVERE, null, ex);
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
