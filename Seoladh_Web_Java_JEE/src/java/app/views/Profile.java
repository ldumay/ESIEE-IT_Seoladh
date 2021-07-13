/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views;

import app.includes.ElementsPages;
import app.models.User;
import app.network.AppSession;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "profile", urlPatterns = {"/profile"})
public class Profile extends HttpServlet {
    
    //-Attributs de base
    AppSession session;
    User userConnect;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        session = new AppSession("superAdmin","superAdmin");
        userConnect = session.getUserConnect();
        
        try (PrintWriter out = response.getWriter()) {
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
                                        +"<li class=\"breadcrumb-item active\">Profil</li>\n"
                                    +"</ol>\n"
                                +"</nav>\n"
                            +"</div>\n"
                            //_Title_
                            +"<!-- Page - Title -->\n"
                            +"<div class=\"row col-md-12 col-xs-12 text-center\">"
                                +"<h3>Profil</h3>"
                            +"</div>\n"
                            +"<hr>\n"
                            //_Content_
                            +"<!-- Page - Content -->\n"
                            +"<div class=\"row col-md-12 col-xs-12\">\n"
                                +"<div class=\"col-md-2 col-xs-2\"></div>\n"
                                +"<div class=\"col-md-4 col-xs-4 text-center\">\n"
                                    +"<img width=\"250px\" height=\"250px\" src=\"images/user/user.png\"/>"
                                +"</div>\n"
                                +"<div class=\"col-md-4 col-xs-4\">\n"
                                    +"<h4>User Connect :</h4>"
                                    +"<ul>"
                                        +"<li>Identifiant : "+userConnect.getIdentifiant()+"</li>"
                                        +"<li>Mot de passe : "+userConnect.getMotDePasse()+"</li>"
                                    +"<br>"
                                        +"<li>Id : "+userConnect.getContactInfos().getId()+"</li>"
                                        +"<li>Nom : "+userConnect.getContactInfos().getNom()+"</li>"
                                        +"<li>Prénom : "+userConnect.getContactInfos().getPrenom()+"</li>"
                                        +"<li>Date de naissance : "+userConnect.getContactInfos().getDateNaissance()+"</li>"
                                        +"<li>Catégorie : "+userConnect.getContactInfos().getCategorie()+"</li>"
                                        +"<li>Email 1 : "+userConnect.getContactInfos().getEmail1()+"</li>"
                                        +"<li>Email 2 : "+userConnect.getContactInfos().getEmail2()+"</li>"
                                        +"<li>Téléphone 1 : "+userConnect.getContactInfos().getTel1()+"</li>"
                                        +"<li>Téléphone 2 : "+userConnect.getContactInfos().getTel2()+"</li>"
                                        +"<li>Adresse 1 : "+userConnect.getContactInfos().getAdresse1()+"</li>"
                                        +"<li>Adresse 2 : "+userConnect.getContactInfos().getAdresse2()+"</li>"
                                        +"<li>Code postal : "+userConnect.getContactInfos().getCodepostal()+"</li>"
                                        +"<li>Ville : "+userConnect.getContactInfos().getVille()+"</li>"
                                        +"<li>Pays : "+userConnect.getContactInfos().getPays()+"</li>"
                                    +"</ul>"
                                +"</div>\n"
                                +"<div class=\"col-md-2 col-xs-2\"></div>\n"
                            +"</div>\n"
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
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
