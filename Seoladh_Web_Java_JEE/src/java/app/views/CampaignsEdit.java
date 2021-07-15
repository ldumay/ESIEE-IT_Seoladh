/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views;

import app.includes.ElementsPages;
import app.models.Campaign;
import app.models.ListContacts;
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
 * @author mtl
 */
@WebServlet(name = "campaigns-edit", urlPatterns = {"/campaigns-edit"})
public class CampaignsEdit extends HttpServlet {

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
            String optionsListesContacts = "";
            
            // = = = [ Lecture des contacts ] = = =
            System.out.println("-> lists de rôles : START");
            
            // = = = [ Connexion à la BDD ] = = =
            connectBDD.openConnexion();
            System.out.println("BDD : Open");
            
            // Récupération de la campagne sélectionné
            Campaign campaign = new Campaign();
            sql = "SELECT * FROM `campaigns` WHERE id="+request.getParameter("campaign-id")+";";
            System.out.println(sql);
            datas = connectBDD.getDatasBySQL(sql);
            while (datas.next()) {
                campaign = new Campaign(datas.getInt(1), datas.getString(2), datas.getString(3), datas.getString(4), datas.getString(5), datas.getString(6));
            }
            
            // Récupération des lists des rôles
            sql = "SELECT * FROM `lists_contacts`;";
            System.out.println(sql);
            datas = connectBDD.getDatasBySQL(sql);
            while (datas.next()) {
                ListContacts listContacts = new ListContacts(datas.getInt(1), datas.getString(2), datas.getString(3), datas.getString(4), datas.getString(5));
                if(listContacts.getId()==campaign.getListeContactsId()){
                    optionsListesContacts += "<option value=\""+listContacts.getId()+"\" selected>"+listContacts.getNom()+"</option>\n";
                } else {
                    optionsListesContacts += "<option value=\""+listContacts.getId()+"\">"+listContacts.getNom()+"</option>\n";
                }
            }
            
            // Lecture de données terminée
            connectBDD.closeConnexion();
            System.out.println("-> lists de rôles : END");
            
            
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
                                        +"<li class=\"breadcrumb-item\"><a href=\"campaigns\">Campagnes</a></li>\n"
                                        +"<li class=\"breadcrumb-item active\">Nouvelle campagne</li>\n"
                                    +"</ol>\n"
                                +"</nav>\n"
                            +"</div>\n"
                            //_Title_
                            +"<!-- Page - Title -->\n"
                            +"<div class=\"row col-md-12 col-xs-12 text-center\">"
                                +"<h3>Nouvelle campagne</h3>"
                            +"</div>\n"
                            +"<hr>\n"
                            //_Content_
                            +"<!-- Page - Content -->\n"
                            +"<form method=\"post\" action=\"campaigns\">\n"
                                +"<div class=\"row col-md-12 col-xs-12\">\n"
                                    +"<div class=\"row col-md-1 col-xs-1\"></div>\n"
                                    +"<div class=\"row col-md-9 col-xs-9 text-right\">\n"
                                        +"<!-- IdDeLaCampagne -->\n"
                                        +"<div class=\"col-sm-6\" style=\"display:none;\">"
                                            +"<input type=\"text\" class=\"form-control\" id=\"id\" name=\"id\" value=\""+campaign.getId()+"\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- NomDeLaCampagne -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"nomDeLaCampagne\">Nom de la campagne</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"text\" class=\"form-control\" id=\"nomDeLaCampagne\" name=\"nomDeLaCampagne\" placeholder=\"Nom de la campagne\" value=\""+campaign.getNom()+"\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- DescriptionDeLaCampagne -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"descriptionDeLaCampagne\">Description de la campagne</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"text\" class=\"form-control\" id=\"descriptionDeLaCampagne\" name=\"descriptionDeLaCampagne\" placeholder=\"Description de la campagne\" value=\""+campaign.getDescription()+"\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- DateDebutDeLaCampagne -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"dateDebutDeLaCampagne\">Date de début de la campagne</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"text\" class=\"form-control\" id=\"dateDebutDeLaCampagne\" name=\"dateDebutDeLaCampagne\" placeholder=\"Date de début (AAAA-MM-DD)\" value=\""+campaign.getDateDebut()+"\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- DateFinDeLaCampagne -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"dateFinDeLaCampagne\">Date de fin de la campagne</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"text\" class=\"form-control\" id=\"dateFinDeLaCampagne\" name=\"dateFinDeLaCampagne\" placeholder=\"Date de fin (AAAA-MM-DD)\" value=\""+campaign.getDateFin()+"\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- Contact_1_DeLaListDeContacts -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"listeContacts\">Liste de contacts #1</label>\n"
                                        +"<div class=\"col-sm-6 input-group\">\n"
                                            +"<select class=\"form-select\" id=\"listeContacts\" name=\"listeContacts\">\n"
                                                +"<option>Choisissez un liste de contacts</option>\n"
                                                +optionsListesContacts
                                            +"</select>\n"
                                            +"<button type=\"button\" class=\"btn btn-primary\" name=\"listContacts_add\" value=\"listContacts_add\" disabled>+ Ajouter une liste de contacts</button>\n"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                    +"</div>\n"
                                    +"<div class=\"row col-md-1 col-xs-1\"></div>\n"
                                +"</div>\n"
                                +"\n"
                                +"<br>\n"
                                +"\n"
                                +"<div class=\"row col-md-12 col-xs-12\">\n"
                                    +"<div class=\"row col-md-4 col-xs-4\"></div>\n"
                                        +"<div class=\"row col-md-4 col-xs-4 text-center\">\n"
                                            +"<button type=\"submit\" class=\"btn btn-success\" name=\"campaign-edit\" value=\"campaign-edit\">Valider la modification campagne</button>\n"
                                        +"</div>\n"
                                    +"<div class=\"row col-md-4 col-xs-4\"></div>\n"
                                +"</div>\n"
                            +"</form>\n"
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
            Logger.getLogger(CampaignsEdit.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CampaignsEdit.class.getName()).log(Level.SEVERE, null, ex);
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
