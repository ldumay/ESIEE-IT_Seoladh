/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views;

import app.includes.ElementsPages;
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
@WebServlet(name = "contacts-new", urlPatterns = {"/contacts-new"})
public class ContactsNew extends HttpServlet {

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
                                        +"<li class=\"breadcrumb-item active\">Nouveau contact</li>\n"
                                    +"</ol>\n"
                                +"</nav>\n"
                            +"</div>\n"
                            //_Title_
                            +"<!-- Page - Title -->\n"
                            +"<div class=\"row col-md-12 col-xs-12 text-center\">"
                                +"<h3>Nouveau contact</h3>"
                            +"</div>\n"
                            +"<hr>\n"
                            //_Content_
                            +"<!-- Page - Content -->\n"
                            +"<form method=\"post\" action=\"contacts\">\n"
                                +"<div class=\"row col-md-12 col-xs-12\">\n"
                                    +"<div class=\"row col-md-2 col-xs-2\"></div>\n"
                                    +"<div class=\"row col-md-8 col-xs-8s text-right\">\n"
                                        +"\n"
                                        +"<!-- NomDuContact -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"nom\">Nom</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"text\" class=\"form-control\" id=\"nom\" name=\"nom\" maxlength=\"32\" placeholder=\"Nom\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- PrenomDuContact -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"prenom\">Prénom</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"text\" class=\"form-control\" id=\"prenom\" name=\"prenom\" maxlength=\"32\" placeholder=\"Prénom\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- DateDeNaissance -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"dateDeNaissance\">Date de naissance</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"text\" class=\"form-control\" id=\"dateDeNaissance\" name=\"dateDeNaissance\" maxlength=\"32\" placeholder=\"Date de naissance (AAAA-MM-DD)\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        /*
                                        +"<!-- Categorie -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"pays\">Catégorie</label>\n"
                                        +"<div class=\"col-sm-6\">\n"
                                            +"<select class=\"form-select\" id=\"categorie\" name=\"categorie\">\n"
                                                +"<option selected>Choisissez une catégorie</option>\n"
                                                +"<option value=\"1\">Catégorie 1</option>\n"
                                                +"<option value=\"2\">Catégorie 2</option>\n"
                                                +"<option value=\"3\">Catégorie 3</option>\n"
                                            +"</select>\n"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        */
                                        +"<!-- Email1 -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"email1\">E-mail (principal)</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"email\" class=\"form-control\" id=\"email1\" name=\"email1\" maxlength=\"32\" placeholder=\"E-mail (principal)\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- Email2 -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"email2\">E-mail (secondaire)</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"email\" class=\"form-control\" id=\"email2\" name=\"email2\" maxlength=\"32\" placeholder=\"E-mail (secondaire)\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- Tel1 -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"tel1\">Téléphone (principal)</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"tel\" class=\"form-control\" id=\"tel1\" name=\"tel1\" maxlength=\"32\" placeholder=\"Téléphone (principal)\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- Tel2 -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"tel2\">Téléphone (secondaire)</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"tel\" class=\"form-control\" id=\"tel2\" name=\"tel2\" maxlength=\"32\" placeholder=\"Téléphone (secondaire)\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- Adresse1 -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"adresse1\">Adresse (principal)</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"text\" class=\"form-control\" id=\"adresse1\" name=\"adresse1\" placeholder=\"Adresse (principal)\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- Adresse2 -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"adresse2\">Adresse (secondaire)</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"text\" class=\"form-control\" id=\"adresse2\" name=\"adresse2\" placeholder=\"Adresse (secondaire)\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- CodePostal -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"codePostal\">Code Postal</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"tel\" class=\"form-control\" id=\"codePostal\" name=\"codePostal\" maxlength=\"5\" placeholder=\"Code Postal\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- Ville -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"ville\">Ville</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"text\" class=\"form-control\" id=\"ville\" name=\"ville\" maxlength=\"32\" placeholder=\"Ville\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        /*
                                        +"<!-- Pays -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"pays\">Pays</label>\n"
                                        +"<div class=\"col-sm-6\">\n"
                                            +"<select class=\"form-select\" id=\"pays\" name=\"pays\">\n"
                                                +"<option selected>Choisissez un pays</option>\n"
                                                +"<option value=\"1\">Pays 1</option>\n"
                                                +"<option value=\"2\">Pays 2</option>\n"
                                                +"<option value=\"3\">Pays 3</option>\n"
                                            +"</select>\n"
                                        +"</div>\n"
                                        +"\n"
                                        */
                                    +"</div>\n"
                                    +"<div class=\"row col-md-1 col-xs-1\"></div>\n"
                                +"</div>\n"
                                +"\n"
                                +"<br>\n"
                                +"\n"
                                +"<div class=\"row col-md-12 col-xs-12\">\n"
                                    +"<div class=\"row col-md-4 col-xs-4\"></div>\n"
                                    +"<div class=\"row col-md-4 col-xs-4 text-center\">\n"
                                        +"<button type=\"submit\" class=\"btn btn-success\" name=\"contact-ajout\" value=\"contact-ajout\">Ajouter le contact</button>\n"
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
            Logger.getLogger(ContactsNew.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ContactsNew.class.getName()).log(Level.SEVERE, null, ex);
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
