/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views;

import app.includes.ElementsPages;
import app.models.ListContacts;
import app.models.Role;
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
@WebServlet(name = "admin-roles", urlPatterns = {"/admin-roles"})
public class AdminRoles extends HttpServlet {

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
            
            // = = = [ Lecture des contacts ] = = =
            System.out.println("-> Admin rôle : START");
            
            // = = = [ Connexion à la BDD ] = = =
            connectBDD.openConnexion();
            System.out.println("BDD : Open");
            
            //si le paramètre == admin-role-ajout
            if(request.getParameter("admin-role-ajout")!=null){
                //-Validation Ajout Film
                if( (!request.getParameter("admin-role-ajout").isEmpty() && !"".equals(request.getParameter("admin-role-ajout"))) ){
                    // = = = [ Lecture des contacts ] = = =
                    System.out.println("-> Ajout du rôle : START");
                    //-
                    Role roleAAjouter = new Role();
                    roleAAjouter.setNom(request.getParameter("nom"));
                    roleAAjouter.setDescription(request.getParameter("description"));
                    //-
                    sql = "INSERT INTO `admin_roles` "
                        +"(`nom`, `description`) "
                        +"VALUES "
                        +"("
                        +"\""+roleAAjouter.getNom()+"\","
                        +"\""+roleAAjouter.getDescription()+"\""
                        +");";
                    //-
                    System.out.println(sql);
                    connectBDD.setDatasBySQL(sql);
                    //-
                    System.out.println("-> Ajout du rôle : END");
                }
            }
            // = = = [ Edition d'un contact ] = = =
            if(request.getParameter("admin-role-edit")!=null){
                //-Validation Ajout Film
                if( (!request.getParameter("admin-role-edit").isEmpty() && "admin-role-edit".equals(request.getParameter("admin-role-edit"))) 
                    && (!request.getParameter("nom").isEmpty() && !"".equals(request.getParameter("nom"))) ){
                    //-
                    System.out.println("-> Edition du rôle : START");
                    //-
                    Role roleAEditer = new Role();
                    roleAEditer.setId(Integer.parseInt(request.getParameter("id")));
                    roleAEditer.setNom(request.getParameter("nom"));
                    roleAEditer.setDescription(request.getParameter("description"));
                    //-
                    sql = "UPDATE `admin_roles` SET"
                        +"`nom`=\""+roleAEditer.getNom()+"\","
                        +"`description`=\""+roleAEditer.getDescription()+"\""
                        +" WHERE `id`="+roleAEditer.getId()+";";
                    System.out.println(sql);
                    //-
                    connectBDD.setDatasBySQL(sql);
                    //-
                    System.out.println("-> Edition du rôle : END");
                }
            }
            // = = = [ Suppression d'un contact ] = = =
            if(request.getParameter("admin-roles-id")!=null){
                //-Validation Ajout Film
                if( (!request.getParameter("admin-roles-id").isEmpty() && !"".equals(request.getParameter("admin-roles-id"))) ){
                    //-
                    System.out.println("-> Suppression du rôle : START");
                    //-
                    sql = "DELETE FROM `admin_roles` WHERE `id`="+request.getParameter("admin-roles-id")+";";
                    System.out.println(sql);
                    //-
                    connectBDD.setDatasBySQL(sql);
                    //-
                    System.out.println("-> Suppression du rôle : END");
                }
            }
            
            // Récupération des lists de contacts
            sql = "SELECT * FROM `admin_roles`;";
            System.out.println(sql);
            datas = connectBDD.getDatasBySQL(sql);
            while (datas.next()) {
                Role listContacts = new Role(datas.getInt(1), datas.getString(2), datas.getString(3));
                contentTable += "<tr>\n"
                            +"<td>"+listContacts.getNom()+"</td>\n"
                            +"<td>"+listContacts.getDescription()+"</td>\n";
                contentTable += "<td><a href=\"admin-roles-edit?admin-roles-id="+listContacts.getId()+"\">Modifier</a></td>\n";
                contentTable += "<td><a href=\"admin-roles?admin-roles-id="+listContacts.getId()+"\">Supprimer</a></td>\n";
                contentTable +="</tr>\n";
            }
            // Lecture de données terminée
            connectBDD.closeConnexion();
            System.out.println("-> Admin rôle : END");
            
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
                                        +"<li class=\"breadcrumb-item active\">Gestion des rôles</li>\n"
                                    +"</ol>\n"
                                +"</nav>\n"
                            +"</div>\n"
                            //_Title_
                            +"<!-- Page - Title -->\n"
                            +"<div class=\"row col-md-12 col-xs-12 text-center\">"
                                +"<h3>Gestion des rôles</h3>"
                                +"<p><a href=\"admin-roles-new\">Ajout un rôle</a></p>"
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
            Logger.getLogger(AdminRoles.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AdminRoles.class.getName()).log(Level.SEVERE, null, ex);
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
