/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views;

import app.includes.ElementsPages;
import app.models.Role;
import app.models.User;
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
@WebServlet(name = "admin-users-edit", urlPatterns = {"/admin-users-edit"})
public class AdminUsersEdit extends HttpServlet {

    User userAModifier = new User();
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Variables nécessasires
            ConnectBDD connectBDD = new ConnectBDD();
            ResultSet datas = null;
            String sql = null;
            String optionsListesRoles = "";
            
            // = = = [ Lecture des contacts ] = = =
            System.out.println("-> lists de contacts : START");
            
            // = = = [ Connexion à la BDD ] = = =
            connectBDD.openConnexion();
            System.out.println("BDD : Open");
            
            // Récupération des informations sur l'utilisateur à modifier
            sql = "SELECT u.`id`, u.`identifiant`, u.`motdepasse`, uar.`admin_roles_id` FROM `users` u, `users_and_admin_roles` uar WHERE uar.`user_id`=u.`id` AND u.`id`="+request.getParameter("admin-users-id")+";";
            System.out.println(sql);
            datas = connectBDD.getDatasBySQL(sql);
            while (datas.next()) {
                userAModifier = new User(datas.getInt(1), datas.getString(2), datas.getString(3));
                userAModifier.setRole_Id(datas.getInt(4));
            }
            
            // Récupération des lists des rôles
            sql = "SELECT * FROM `admin_roles`;";
            System.out.println(sql);
            datas = connectBDD.getDatasBySQL(sql);
            while (datas.next()) {
                Role role = new Role(datas.getInt(1), datas.getString(2), datas.getString(3));
                optionsListesRoles += (role.getId()==userAModifier.getRole_Id()) ? "<option value=\""+role.getId()+"\" selected>"+role.getNom()+"</option>\n" : "<option value=\""+role.getId()+"\">"+role.getNom()+"</option>\n";
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
                                        +"<li class=\"breadcrumb-item\"><a href=\"admin\">Administration</a></li>\n"
                                        +"<li class=\"breadcrumb-item\"><a href=\"admin-users\">Gestion des comptes utilisateurs</a></li>\n"
                                        +"<li class=\"breadcrumb-item active\">Modifier l'utilisateur</li>\n"
                                    +"</ol>\n"
                                +"</nav>\n"
                            +"</div>\n"
                            //_Title_
                            +"<!-- Page - Title -->\n"
                            +"<div class=\"row col-md-12 col-xs-12 text-center\">"
                                +"<h3>Modifier l'utilisateur</h3>"
                            +"</div>\n"
                            +"<hr>\n";
                            if(erreur==false){
                            htmlContent += ""
                            //_Content_
                            +"<!-- Page - Content -->\n"
                            +"<form method=\"post\" action=\"admin-users\">\n"
                                +"<div class=\"row col-md-12 col-xs-12\">\n"
                                    +"<div class=\"row col-md-2 col-xs-2\"></div>\n"
                                    +"<div class=\"row col-md-8 col-xs-8s text-right\">\n"
                                        +"<!-- IdDuUser -->\n"
                                        +"<div class=\"col-sm-6\" style=\"display:none;\">"
                                            +"<input type=\"text\" class=\"form-control\" id=\"id\" name=\"id\" value=\""+userAModifier.getId()+"\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- IdentifiantDuUser -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"nom\">Identifiant</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"text\" class=\"form-control\" id=\"identifiant\" name=\"identifiant\" maxlength=\"32\" placeholder=\"Identifiant\" value=\""+userAModifier.getIdentifiant()+"\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- MotDePasseDuUser -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"motDePasse\">Mot de passe</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"text\" class=\"form-control\" id=\"motDePasse\" name=\"motDePasse\" maxlength=\"32\" placeholder=\"Mot de passe\" value=\""+userAModifier.getMotDePasse()+"\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- RoleDuUser -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"role\">Choix du rôle</label>\n"
                                        +"<div class=\"col-sm-6\">\n"
                                            +"<select class=\"form-select\" id=\"role\" name=\"role\">\n"
                                                +"<option selected>Choisissez un rôle</option>\n"
                                                +optionsListesRoles
                                            +"</select>\n"
                                        +"</div>\n"
                                        +"\n"
                                    +"</div>\n"
                                +"</div>\n"
                                +"\n"
                                +"<br>\n"
                                +"\n"
                                +"<div class=\"row col-md-12 col-xs-12\">\n"
                                    +"<div class=\"row col-md-4 col-xs-4\"></div>\n"
                                    +"<div class=\"row col-md-4 col-xs-4 text-center\">\n"
                                        +"<button type=\"submit\" class=\"btn btn-success\" name=\"admin-user-edit\" value=\"admin-user-edit\">Modifier l'utilisateur</button>\n"
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
            Logger.getLogger(AdminUsersEdit.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AdminUsersEdit.class.getName()).log(Level.SEVERE, null, ex);
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
