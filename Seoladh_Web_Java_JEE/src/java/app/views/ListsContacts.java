/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views;

import app.includes.ElementsPages;
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
@WebServlet(name = "lists-contacts", urlPatterns = {"/lists-contacts"})
public class ListsContacts extends HttpServlet {
    
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
            
            // = = = [ Lecture des contacts ] = = =
            System.out.println("-> lists de contacts : START");
            
            // = = = [ Connexion à la BDD ] = = =
            connectBDD.openConnexion();
            System.out.println("BDD : Open");
            
            // = = = [ Ajout d'un contact ] = = =
            if(request.getParameter("list-contacts-ajout")!=null){
                if( (!request.getParameter("list-contacts-ajout").isEmpty() && "list-contacts-ajout".equals(request.getParameter("list-contacts-ajout"))) 
                    && (!request.getParameter("nom").isEmpty() && !"".equals(request.getParameter("nom"))) ){
                    //-
                    System.out.println("-> Ajout une liste de contact : START");
                    //-
                    ListContacts listContactAAjouter = new ListContacts();
                    listContactAAjouter.setNom(request.getParameter("nom"));
                    listContactAAjouter.setDescription(request.getParameter("description"));
                    listContactAAjouter.setDateDebut(request.getParameter("dateDeDebut"));
                    listContactAAjouter.setDateFin(request.getParameter("dateDeFin"));
                    //-
                    sql = ""
                        +"INSERT INTO `lists_contacts` "
                        +"(`nom`, `description`, `date_start`, `date_end`) "
                        +"VALUES "
                        +"("
                        +"\""+listContactAAjouter.getNom()+"\","
                        +"\""+listContactAAjouter.getDescription()+"\",";
                    sql += "\""+listContactAAjouter.getDateDebut()+"\",";
                    sql += "\""+listContactAAjouter.getDateFin()+"\"";
                    sql += ");";
                    System.out.println(sql);
                    connectBDD.setDatasBySQL(sql);
                    
                    // Récupération de l'id de la liste de contact ajouté
                    sql = "SELECT `id` FROM `lists_contacts` ORDER BY `id` DESC LIMIT 0,1;";
                    System.out.println(sql);
                    datas = connectBDD.getDatasBySQL(sql);
                    while (datas.next()) {
                        listContactAAjouter.setId(datas.getInt(1));
                    }
                    
                    // Liaison de la liste de contacts avec les contacts choisi
                    try{
                        int x = 0;
                        while(x<100){
                            if(request.getParameter("contact_"+x+"")!=null && !"".equals(request.getParameter("contact_"+x+""))){
                                //-
                                sql = "INSERT INTO `lists_contacts_and_contacts` "
                                    +"(`list_contacts_id`, `contact_id`) "
                                    +"VALUES "
                                    +"("
                                    +""+listContactAAjouter.getId()+","
                                    +""+x+""
                                    +")";
                                //-
                                System.out.println(sql);
                                connectBDD.setDatasBySQL(sql);
                            }
                            x++;
                        }
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    //-
                    System.out.println("-> Ajout une liste de contact : END");
                }
            }
            
            // = = = [ Suppression d'une liste de contacts - Partie 1 ] = = =
            if(request.getParameter("list-contacts-suppr-id")!=null){
                if( (!request.getParameter("list-contacts-suppr-id").isEmpty() && !"".equals(request.getParameter("list-contacts-suppr-id"))) 
                    && (!request.getParameter("nouvelle-liste-contacts").isEmpty() && !"".equals(request.getParameter("nouvelle-liste-contacts"))) ){
                    //-
                    System.out.println("-> Edition de contact : START");
                    String oldListeContacts = request.getParameter("ancienne-liste-contacts");
                    String newListeContacts = request.getParameter("nouvelle-liste-contacts");
                    //-
                    sql = "UPDATE `lists_contacts_and_contacts` "
                            +"SET `list_contacts_id`="+newListeContacts+" "
                            +"WHERE `list_contacts_id`="+oldListeContacts+";";
                    System.out.println(sql);
                    connectBDD.setDatasBySQL(sql);
                    //-
                    sql = "DELETE FROM `lists_contacts` WHERE `id`="+oldListeContacts+";";
                    System.out.println(sql);
                    connectBDD.setDatasBySQL(sql);
                    //-
                    System.out.println("-> Edition de contact : END");
                }
            }
            
            // Récupération des lists de contacts
            sql = "SELECT * FROM `lists_contacts`;";
            System.out.println(sql);
            datas = connectBDD.getDatasBySQL(sql);
            while (datas.next()) {
                ListContacts listContacts = new ListContacts(datas.getInt(1), datas.getString(2), datas.getString(3),
                        datas.getString(4), datas.getString(5));
                contentTable += "<tr>\n"
                            +"<td>"+listContacts.getNom()+"</td>\n"
                            +"<td>"+listContacts.getDescription()+"</td>\n"
                            +"<td>"+listContacts.getDateDebut()+"</td>\n"
                            +"<td>"+listContacts.getDateFin()+"</td>\n";
                contentTable += "<td><a href=\"lists-contacts-edit?contact-edit-id="+listContacts.getId()+"\">Modifier</a></td>\n";
                contentTable += "<td><a href=\"lists-contacts-suppr?list-contacts-id="+listContacts.getId()+"\">Supprimer</a></td>\n";
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
                                        +"<li class=\"breadcrumb-item active\">Listes de contacts</li>\n"
                                    +"</ol>\n"
                                +"</nav>\n"
                            +"</div>\n"
                            //_Title_
                            +"<!-- Page - Title -->\n"
                            +"<div class=\"row col-md-12 col-xs-12 text-center\">"
                                +"<h3>Listes de contacts</h3>"
                                +"<p><a href=\"lists-contacts-new\">Ajout une liste de contacts</a></p>"
                            +"</div>\n"
                            +"<hr>\n"
                            //_Content_
                            +"<!-- Page - Content -->\n"
                            +"<table class=\"table table-bordered text-center\">\n"
                                +"<thead>\n"
                                    +"<tr>\n"
                                        +"<th scope=\"col\">Nom</th>\n"
                                        +"<th scope=\"col\">Description</th>\n"
                                        +"<th scope=\"col\">Date de début</th>\n"
                                        +"<th scope=\"col\">Date de fin</th>\n"
                                        +"<th scope=\"col\">Modifier</th>\n"
                                        +"<th scope=\"col\">Supprimer</th>\n"
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
            Logger.getLogger(ListsContacts.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ListsContacts.class.getName()).log(Level.SEVERE, null, ex);
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
