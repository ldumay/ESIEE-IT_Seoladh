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
@WebServlet(name = "contacts-blacklist", urlPatterns = {"/contacts-blacklist"})
public class ContactsBlacklist extends HttpServlet {

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            System.out.println("-> lists de contacts : START");
            // Variables nécessasires
            ConnectBDD connectBDD = new ConnectBDD();
            ResultSet datas = null;
            String sql = null;
            String contentTable = "";
            //-
            connectBDD.openConnexion();
            
            // = = = [ Edition d'un contact ] = = =
            if(request.getParameter("blacklist-retrait")!=null){
                //-Validation Ajout Film
                if( (!request.getParameter("blacklist-retrait").isEmpty() && !"".equals(request.getParameter("blacklist-retrait"))) ){
                    //-
                    System.out.println("-> Blacklist retrait : START");
                    //-
                    sql = "UPDATE `contacts` SET `blacklist`=1 WHERE `id`="+request.getParameter("blacklist-retrait")+";";
                    System.out.println(sql);
                    connectBDD.setDatasBySQL(sql);
                    //-
                    System.out.println("-> Blacklist retrait : END");
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
            
            // Récupération des lists de contacts
            sql = "SELECT * FROM `contacts` WHERE blacklist=2;";
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
                contentTable += "<td><a href=\"contacts-blacklist?contact-suppr-id="+contact.getId()+"\">Supprimer</a></td>\n";
                contentTable += "<td><a href=\"contacts-blacklist?blacklist-retrait="+contact.getId()+"\">Retrait</a></td>\n";
                contentTable +="</tr>\n";
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
                                        +"<li class=\"breadcrumb-item\"><a href=\"contacts\">Contacts</a></li>\n"
                                        +"<li class=\"breadcrumb-item active\">Contacts retirés</li>\n"
                                    +"</ol>\n"
                                +"</nav>\n"
                            +"</div>\n"
                            //_Title_
                            +"<!-- Page - Title -->\n"
                            +"<div class=\"row col-md-12 col-xs-12 text-center\">"
                                +"<h3>Contacts retirés</h3>"
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
        } catch (SQLException ex) {
            Logger.getLogger(ContactsBlacklist.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ContactsBlacklist.class.getName()).log(Level.SEVERE, null, ex);
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
