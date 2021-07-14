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
@WebServlet(name = "lists-contacts-new", urlPatterns = {"/lists-contacts-new"})
public class ListsContactsNew extends HttpServlet {

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Variables nécessasires
            ConnectBDD connectBDD = new ConnectBDD();
            ResultSet datas = null;
            String sql = null;
            String contentTable = "";
            
            // = = = [ Lecture des contacts ] = = =
            System.out.println("-> lists de contacts : START");
            
            // = = = [ Connexion à la BDD ] = = =
            connectBDD.openConnexion();
            System.out.println("BDD : Open");
            
            // Récupération des lists de contacts
            sql = "SELECT * FROM `contacts` WHERE blacklist=0;";
            System.out.println(sql);
            datas = connectBDD.getDatasBySQL(sql);
            while (datas.next()) {
                Contact contact = new Contact(datas.getInt(1), datas.getString(2), datas.getString(3),
                        datas.getString(4), datas.getString(5), datas.getString(6), datas.getString(7),
                        datas.getString(8), datas.getString(9), datas.getString(10), datas.getString(11),
                        datas.getString(12), datas.getString(13), datas.getString(14), datas.getInt(15));
                contentTable += "<tr>\n"
                            +"<td>"
                                +"<input class=\"form-check-input\" type=\"checkbox\" id=\"contact_"+contact.getId()+"\" name=\"contact_"+contact.getId()+"\" value=\""+contact.getId()+"\">\n"
                            +"</td>"
                            +"<td>"+contact.getNom()+"</td>\n"
                            +"<td>"+contact.getPrenom()+"</td>\n"
                            +"<td>"+contact.getDateNaissance()+"</td>\n"
                            +"<td>"+contact.getEmail1()+"</td>\n"
                            +"<td>"+contact.getEmail2()+"</td>\n";
                contentTable +="</tr>\n";
            }
            System.out.println("-> lists de contacts : END");
            
            //-
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
                                        +"<li class=\"breadcrumb-item\"><a href=\"lists-contacts\">Listes de contacts</a></li>\n"
                                        +"<li class=\"breadcrumb-item active\">Nouvelle liste de contacts</li>\n"
                                    +"</ol>\n"
                                +"</nav>\n"
                            +"</div>\n"
                            //_Title_
                            +"<!-- Page - Title -->\n"
                            +"<div class=\"row col-md-12 col-xs-12 text-center\">"
                                +"<h3>Nouvelle liste de contacts</h3>"
                            +"</div>\n"
                            +"<hr>\n"
                            //_Content_
                            +"<!-- Page - Content -->\n"
                            +"<form method=\"post\" action=\"lists-contacts\">\n"
                                +"<div class=\"row col-md-12 col-xs-12\">\n"
                                    +"<div class=\"row col-md-1 col-xs-1\"></div>\n"
                                    +"<div class=\"row col-md-9 col-xs-9 text-right\">\n"
                                        +"\n"
                                        +"<!-- ListeDeContact_Nom -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"nom\">Nom</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"text\" class=\"form-control\" id=\"nom\" name=\"nom\" maxlength=\"32\" placeholder=\"Nom\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- ListeDeContact_Description -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"description\">Description</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"text\" class=\"form-control\" id=\"description\" name=\"description\" maxlength=\"32\" placeholder=\"Description\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- ListeDeContact_DateDeDebut -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"dateDeDebut\">Date de début</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"text\" class=\"form-control\" id=\"dateDeDebut\" name=\"dateDeDebut\" maxlength=\"32\" placeholder=\"Date de début (AAAA-MM-DD)\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- ListeDeContact_DateDeFin -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"dateDeFin\">Date de fin</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"text\" class=\"form-control\" id=\"dateDeFin\" name=\"dateDeFin\" maxlength=\"32\" placeholder=\"Date de fin (AAAA-MM-DD)\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                    +"</div>\n"
                                +"</div>\n"
                                +"<br><br>\n"
                                +"\n"
                                +"<!-- ListDeContacts_choix_des_contacts -->\n"
                                +"<div id=\"liste-de-contact-table\" class=\"row col-md-12 col-xs-12\">\n"
                                    +"<table class=\"table table-bordered text-center\">\n"
                                        +"<thead>\n"
                                            +"<tr>\n"
                                                +"<th scope=\"col\">#</th>\n"
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
                                +"<br>\n"
                                +"\n"
                                +"<div class=\"row col-md-12 col-xs-12\">\n"
                                    +"<div class=\"row col-md-4 col-xs-4\"></div>\n"
                                    +"<div class=\"row col-md-4 col-xs-4 text-center\">\n"
                                        +"<button type=\"submit\" class=\"btn btn-success\" name=\"list-contacts-ajout\" value=\"list-contacts-ajout\">Ajouter la liste de contacts</button>\n"
                                    +"</div>\n"
                                    +"<div class=\"row col-md-4 col-xs-4\"></div>\n"
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
        } catch (SQLException ex) {
            Logger.getLogger(ListsContactsNew.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(ListsContactsNew.class.getName()).log(Level.SEVERE, null, ex);
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
