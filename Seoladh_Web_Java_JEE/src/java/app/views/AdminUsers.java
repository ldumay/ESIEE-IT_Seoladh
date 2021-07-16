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
@WebServlet(name = "admin-users", urlPatterns = {"/admin-users"})
public class AdminUsers extends HttpServlet {

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
            String contentTable = "";
            
            // = = = [ Lecture des userss ] = = =
            System.out.println("-> Admin user : START");
            
            // = = = [ Connexion à la BDD ] = = =
            connectBDD.openConnexion();
            System.out.println("BDD : Open");
            
            //si le paramètre == admin-user-ajout
            if(request.getParameter("admin-user-ajout")!=null){
                //-Validation Ajout Film
                if( (!request.getParameter("admin-user-ajout").isEmpty() && !"".equals(request.getParameter("admin-user-ajout"))) ){
                    // = = = [ Lecture des userss ] = = =
                    System.out.println("-> Ajout de l'utilisateur : START");
                    //Préparation de l'utilisateur
                    User userAAjouter = new User();
                    userAAjouter.setIdentifiant(request.getParameter("identifiant"));
                    userAAjouter.setMotDePasse(request.getParameter("motDePasse"));
                    userAAjouter.setRole_Id(Integer.parseInt(request.getParameter("role")));
                    //Ajout de l'utilisateur dans la table users
                    sql = "INSERT INTO `users` "
                        +"(`identifiant`, `motDePasse`) "
                        +"VALUES "
                        +"("
                        +"\""+userAAjouter.getIdentifiant()+"\","
                        +"\""+userAAjouter.getMotDePasse()+"\""
                        +");";
                    System.out.println(sql);
                    connectBDD.setDatasBySQL(sql);
                    //Récupération de l'id de l'utilisateur ajouté
                    sql = "SELECT id FROM `users` WHERE `identifiant`=\""+userAAjouter.getIdentifiant()+"\" AND `motDePasse`=\""+userAAjouter.getMotDePasse()+"\";";
                    System.out.println(sql);
                    datas = connectBDD.getDatasBySQL(sql);
                    while (datas.next()) {
                        userAAjouter.setId(datas.getInt(1));
                    }
                    //Laison de l'utilisateur au rôle sélectionné
                    sql = "INSERT INTO `users_and_admin_roles` "
                        +"(`user_id`, `admin_roles_id`) "
                        +"VALUES "
                        +"("
                        +""+userAAjouter.getId()+","
                        +""+userAAjouter.getRole_Id()+""
                        +");";
                    System.out.println(sql);
                    connectBDD.setDatasBySQL(sql);
                    //-
                    System.out.println("-> Ajout de l'utilisateur : END");
                }
            }
            // = = = [ Edition d'un users ] = = =
            if(request.getParameter("admin-user-edit")!=null){
                //-Validation Ajout Film
                if( (!request.getParameter("admin-user-edit").isEmpty() && "admin-user-edit".equals(request.getParameter("admin-user-edit"))) 
                    && (!request.getParameter("identifiant").isEmpty() && !"".equals(request.getParameter("motDePasse"))) ){
                    //-
                    System.out.println("-> Edition de l'utilisateur : START");
                    //Préparation de l'utiliateur à modifier
                    User userAEditer = new User();
                    userAEditer.setId(Integer.parseInt(request.getParameter("id")));
                    userAEditer.setIdentifiant(request.getParameter("identifiant"));
                    userAEditer.setMotDePasse(request.getParameter("motDePasse"));
                    userAEditer.setRole_Id(Integer.parseInt(request.getParameter("role")));
                    //Mise à jour de l'utyilisateur dans la table users
                    sql = "UPDATE `users` SET"
                        +"`identifiant`=\""+userAEditer.getIdentifiant()+"\","
                        +"`motDePasse`=\""+userAEditer.getMotDePasse()+"\""
                        +" WHERE `id`="+userAEditer.getId()+";";
                    System.out.println(sql);
                    connectBDD.setDatasBySQL(sql);
                    //Mise à jour de l'utilisateur dans table users
                    sql = "UPDATE `users_and_admin_roles` SET `admin_roles_id`="+userAEditer.getRole_Id()+" WHERE `user_id`="+userAEditer.getId()+";";
                    System.out.println(sql);
                    connectBDD.setDatasBySQL(sql);
                    //-
                    System.out.println("-> Edition de l'utilisateur : END");
                }
            }
            // = = = [ Suppression d'un users ] = = =
            if(request.getParameter("admin-users-id")!=null){
                //-Validation Ajout Film
                if( (!request.getParameter("admin-users-id").isEmpty() && !"".equals(request.getParameter("admin-users-id"))) ){
                    //-
                    System.out.println("-> Suppression de l'utilisateur : START");
                    //-
                    sql = "DELETE FROM `users_and_admin_roles` WHERE `user_id`="+request.getParameter("admin-users-id")+";";
                    System.out.println(sql);
                    connectBDD.setDatasBySQL(sql);
                    //-
                    sql = "DELETE FROM `users` WHERE `id`="+request.getParameter("admin-users-id")+";";
                    System.out.println(sql);
                    connectBDD.setDatasBySQL(sql);
                    //-
                    System.out.println("-> Suppression de l'utilisateur : END");
                }
            }
            
            // Récupération des lists de userss
            sql = "SELECT u.`id`, u.`identifiant`, u.`motdepasse`, uar.`admin_roles_id` FROM `users` u, `users_and_admin_roles` uar WHERE uar.`user_id`=u.`id`;";
            System.out.println(sql);
            datas = connectBDD.getDatasBySQL(sql);
            while (datas.next()) {
                User user = new User(datas.getInt(1), datas.getString(2), datas.getString(3));
                user.setRole_Id(datas.getInt(4));
                Role userRole = user.getRoleInfo(user.getRole_Id());
                
                contentTable += "<tr>\n"
                            +"<td>"+user.getIdentifiant()+"</td>\n"
                            +"<td>"+user.getMotDePasse()+"</td>\n";
                contentTable += (userRole.getNom()!=null) ? "<td>"+userRole.getNom()+"</td>\n" : "<td>Aucun rôle</td>\n";
                contentTable += "<td><a href=\"admin-users-edit?admin-users-id="+user.getId()+"\">Modifier</a></td>\n";
                contentTable += "<td><a href=\"admin-users?admin-users-id="+user.getId()+"\">Supprimer</a></td>\n";
                contentTable +="</tr>\n";
            }
            // Lecture de données terminée
            connectBDD.closeConnexion();
            System.out.println("-> Admin user : END");
            
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
                                        +"<li class=\"breadcrumb-item active\">Gestion des comptes utilisateurs</li>\n"
                                    +"</ol>\n"
                                +"</nav>\n"
                            +"</div>\n"
                            //_Title_
                            +"<!-- Page - Title -->\n"
                            +"<div class=\"row col-md-12 col-xs-12 text-center\">"
                                +"<h3>Gestion des comptes utilisateurs</h3>"
                                +"<p><a href=\"admin-users-new\">Ajout un utilisateur</a></p>"
                            +"</div>\n"
                            +"<hr>\n"
                            //_Content_
                            +"<!-- Page - Content -->\n"
                            +"<div class=\"row col-md-12 col-xs-12 text-center\">"
                                +"<table class=\"table table-bordered text-center\">\n"
                                    +"<thead>\n"
                                        +"<tr>\n"
                                            +"<th scope=\"col\">Nom</th>\n"
                                            +"<th scope=\"col\">Description</th>\n"
                                            +"<th scope=\"col\">Rôle</th>\n"
                                            +"<th scope=\"col\">Modifier</th>\n"
                                            +"<th scope=\"col\">Supprimer</th>\n"
                                        +"</tr>\n"
                                    +"</thead>\n"
                                    +"<tbody>\n"
                                        +contentTable
                                    +"</tbody>\n"
                                +"</table>"
                            +"</div>\n"
                            +"\n"
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
            Logger.getLogger(AdminUsers.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AdminUsers.class.getName()).log(Level.SEVERE, null, ex);
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
