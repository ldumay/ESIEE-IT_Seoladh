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
@WebServlet(name = "contacts-edit", urlPatterns = {"/contacts-edit"})
public class ContactsEdit extends HttpServlet {

    Contact contactAModifier = new Contact();
    boolean erreur = false;
    
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
            
            // = = = [ Connexion à la BDD ] = = =
            connectBDD.openConnexion();
            System.out.println("BDD : Open");
            
            //si le paramètre == contact-edit-id
            if(request.getParameter("contact-edit-id")!=null){
                //-Validation Ajout Film
                if( (!request.getParameter("contact-edit-id").isEmpty() && !"".equals(request.getParameter("contact-edit-id"))) ){
                    // = = = [ Lecture des contacts ] = = =
                    System.out.println("-> Edition de contacts : START");

                    // Récupération des lists de contacts
                    sql = "SELECT * FROM `contacts` WHERE `id`="+request.getParameter("contact-edit-id")+";";
                    System.out.println(sql);
                    datas = connectBDD.getDatasBySQL(sql);
                    while (datas.next()) {
                        contactAModifier = new Contact(datas.getInt(1), datas.getString(2), datas.getString(3),
                                datas.getString(4), datas.getString(5), datas.getString(6), datas.getString(7),
                                datas.getString(8), datas.getString(9), datas.getString(10), datas.getString(11),
                                datas.getString(12), datas.getString(13), datas.getString(14), datas.getInt(15));
                        contentTable += "<tr>\n"
                                    +"<th scope=\"row\">"+contactAModifier.getId()+"</th>\n"
                                    +"<td>"+contactAModifier.getNom()+"</td>\n"
                                    +"<td>"+contactAModifier.getPrenom()+"</td>\n"
                                    +"<td>"+contactAModifier.getDateNaissance()+"</td>\n"
                                    +"<td>"+contactAModifier.getEmail1()+"</td>\n"
                                    +"<td>"+contactAModifier.getEmail2()+"</td>\n";
                        contentTable += "<td><a href=\"contacts-edit?contact-edit-id="+contactAModifier.getId()+"\">Modifier</a></td>\n";
                        contentTable += "<td><a href=\"contacts-blacklist-ajout?id="+contactAModifier.getId()+"\">Ajout</a></td>\n";
                        contentTable +="</tr>\n";
                    }
                    //-
                    System.out.println("-> Edition de contact : END");
                } else {
                    erreur=true;
                    System.out.println("-> Edition de contact : ERREUR");
                }
            }
            
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
                                        +"<li class=\"breadcrumb-item active\">Modification de contact</li>\n"
                                    +"</ol>\n"
                                +"</nav>\n"
                            +"</div>\n"
                            //_Title_
                            +"<!-- Page - Title -->\n"
                            +"<div class=\"row col-md-12 col-xs-12 text-center\">"
                                +"<h3>Modification de contact</h3>"
                            +"</div>\n"
                            +"<hr>\n";
                            
                            //_Content_
                            if(erreur==false){
                            htmlContent += ""
                            +"<!-- Page - Content -->\n"
                            +"<form method=\"post\" action=\"contacts\">\n"
                                +"<div class=\"row col-md-12 col-xs-12\">\n"
                                    +"<div class=\"row col-md-2 col-xs-2\"></div>\n"
                                    +"<div class=\"row col-md-8 col-xs-8s text-right\">\n"
                                        +"<!-- IdDuContact -->\n"
                                        +"<div class=\"col-sm-6\" style=\"display:none;\">"
                                            +"<input type=\"text\" class=\"form-control\" id=\"id\" name=\"id\" value=\""+contactAModifier.getId()+"\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- NomDuContact -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"nom\">Nom</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"text\" class=\"form-control\" id=\"nom\" name=\"nom\" maxlength=\"32\" placeholder=\"Nom\" value=\""+contactAModifier.getNom()+"\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- PrenomDuContact -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"prenom\">Prénom</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"text\" class=\"form-control\" id=\"prenom\" name=\"prenom\" maxlength=\"32\" placeholder=\"Prénom\" value=\""+contactAModifier.getPrenom()+"\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- DateDeNaissance -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"dateDeNaissance\">Date de naissance</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"text\" class=\"form-control\" id=\"dateDeNaissance\" name=\"dateDeNaissance\" maxlength=\"32\" placeholder=\"AAAA-MM-DD\" value=\""+contactAModifier.getDateNaissance()+"\">"
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
                                            +"<input type=\"email\" class=\"form-control\" id=\"email1\" name=\"email1\" placeholder=\"E-mail (principal)\" value=\""+contactAModifier.getEmail1()+"\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- Email2 -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"email2\">E-mail (secondaire)</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"email\" class=\"form-control\" id=\"email2\" name=\"email2\" placeholder=\"E-mail (secondaire)\" value=\""+contactAModifier.getEmail2()+"\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- Tel1 -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"tel1\">Téléphone (principal)</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"tel\" class=\"form-control\" id=\"tel1\" name=\"tel1\" maxlength=\"32\" placeholder=\"Téléphone (principal)\" value=\""+contactAModifier.getTel1()+"\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- Tel2 -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"tel2\">Téléphone (secondaire)</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"tel\" class=\"form-control\" id=\"tel2\" name=\"tel2\" maxlength=\"32\" placeholder=\"Téléphone (secondaire)\" value=\""+contactAModifier.getTel2()+"\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- Adresse1 -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"adresse1\">Adresse (principal)</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"text\" class=\"form-control\" id=\"adresse1\" name=\"adresse1\" placeholder=\"Adresse (principal)\" value=\""+contactAModifier.getAdresse1()+"\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- Adresse2 -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"adresse2\">Adresse (secondaire)</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"text\" class=\"form-control\" id=\"adresse2\" name=\"adresse2\" placeholder=\"Adresse (secondaire)\" value=\""+contactAModifier.getAdresse2()+"\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- CodePostal -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"codePostal\">Code Postal</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"tel\" class=\"form-control\" id=\"codePostal\" name=\"codePostal\" maxlength=\"5\" placeholder=\"Code Postal\" value=\""+contactAModifier.getCodepostal()+"\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- Ville -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"ville\">Ville</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"text\" class=\"form-control\" id=\"ville\" name=\"ville\" maxlength=\"32\" placeholder=\"Ville\" value=\""+contactAModifier.getVille()+"\">"
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
                                        +"<button type=\"submit\" class=\"btn btn-success\" name=\"contact-edit\" value=\"contact-edit\">Modifier le contact</button>\n"
                                    +"</div>\n"
                                    +"<div class=\"row col-md-4 col-xs-4\"></div>\n"
                                +"</div>\n"
                            +"</form>";
                            
                            }else{
                                htmlContent += ""
                                    +"<div class=\"row col-md-12 col-xs-12 text-center\">\n"
                                        +"<div class=\"alert alert-danger\" role=\"alert\">\n"
                                            +"<h2>Oups !</h2>"
                                            +"<p>Quelque chose s'est mal passé.\n"
                                            +"<br>Veuillez réessayé, svp.\n"
                                            +"</p>\n"
                                        +"</div>"
                                    +"</div>";
                            }
                            
                            htmlContent += ""
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
            Logger.getLogger(ContactsEdit.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ContactsEdit.class.getName()).log(Level.SEVERE, null, ex);
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
