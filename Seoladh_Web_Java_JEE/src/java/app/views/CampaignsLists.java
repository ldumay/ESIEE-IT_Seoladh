/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views;

import app.includes.ElementsPages;
import app.models.Campaign;
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
@WebServlet(name = "campaigns", urlPatterns = {"/campaigns"})
public class CampaignsLists extends HttpServlet {

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
            
            // = = = [ Lecture des campaigns ] = = =
            System.out.println("-> lists de contacts : START");
            
            // = = = [ Connexion à la BDD ] = = =
            connectBDD.openConnexion();
            System.out.println("BDD : Open");
            
            // = = = [ Ajout d'un campaign ] = = =
            if(request.getParameter("campaign-new")!=null){
                //-Validation Ajout Film
                if( (!request.getParameter("campaign-new").isEmpty() && "campaign-new".equals(request.getParameter("campaign-new"))) 
                    && (!request.getParameter("nomDeLaCampagne").isEmpty() && !"".equals(request.getParameter("nomDeLaCampagne")))
                    && (!request.getParameter("listeContacts").isEmpty() && !"".equals(request.getParameter("listeContacts")) && !"Choisissez un liste de contacts".equals(request.getParameter("listeContacts"))) ){
                    //-
                    System.out.println("-> Ajout de la campagne : START");
                    //Préparation de la campagne
                    Campaign campaignAAjouter = new Campaign();
                    campaignAAjouter.setNom(request.getParameter("nomDeLaCampagne"));
                    campaignAAjouter.setDescription(request.getParameter("descriptionDeLaCampagne"));
                    campaignAAjouter.setDateDebut(request.getParameter("dateDebutDeLaCampagne"));
                    campaignAAjouter.setDateFin(request.getParameter("dateFinDeLaCampagne"));
                    int listContact_id = Integer.parseInt(request.getParameter("listeContacts"));
                    //Ajout de la campagne dans le table campaigns
                    sql = "INSERT INTO `campaigns`"
                        +"(`nom`, `description`, `date_start`, `date_end`) "
                        +"VALUES "
                        +"("
                        +"\""+campaignAAjouter.getNom()+"\","
                        +"\""+campaignAAjouter.getDescription()+"\","
                        +"\""+campaignAAjouter.getDateDebut()+"\","
                        +"\""+campaignAAjouter.getDateFin()+"\""
                        +");";
                    System.out.println(sql);
                    connectBDD.setDatasBySQL(sql);
                    //Récupération de l'id de la campagne
                    sql = "SELECT id FROM `campaigns` WHERE `nom`=\""+campaignAAjouter.getNom()+"\" AND `date_start`=\""+campaignAAjouter.getDateDebut()+"\";";
                    System.out.println(sql);
                    datas = connectBDD.getDatasBySQL(sql);
                    while (datas.next()) {
                        campaignAAjouter.setId(datas.getInt(1));
                    }
                    //Liaison entre la campagne et la liste de contact
                    sql = "INSERT INTO `campaigns_and_lists_contacts` "
                        +"(`campaigns_id`, `list_contacts_id`) "
                        +"VALUES ("
                        +""+campaignAAjouter.getId()+","
                        +""+listContact_id+""
                        +");";
                    System.out.println(sql);
                    connectBDD.setDatasBySQL(sql);
                    //-
                    System.out.println("-> Ajout de la campagne : END");
                }
            }
            
            // = = = [ Edit d'un campaign ] = = =
            if(request.getParameter("campaign-edit")!=null){
                //-Validation Ajout Film
                if( (!request.getParameter("campaign-edit").isEmpty() && "campaign-edit".equals(request.getParameter("campaign-edit"))) 
                    && (!request.getParameter("nomDeLaCampagne").isEmpty() && !"".equals(request.getParameter("nomDeLaCampagne"))) ){
                    //-
                    System.out.println("-> Modification de la campagne : START");
                    //Préparation de la campagne
                    Campaign campaignAModifier = new Campaign();
                    campaignAModifier.setId(Integer.parseInt(request.getParameter("id")));
                    campaignAModifier.setNom(request.getParameter("nomDeLaCampagne"));
                    campaignAModifier.setDescription(request.getParameter("descriptionDeLaCampagne"));
                    campaignAModifier.setDateDebut(request.getParameter("dateDebutDeLaCampagne"));
                    campaignAModifier.setDateFin(request.getParameter("dateFinDeLaCampagne"));
                    int listContact_id = Integer.parseInt(request.getParameter("listeContacts"));
                    //Modification de la campagne dans le table campaigns
                    sql = "UPDATE `campaigns` SET "
                        +"`nom`=\""+campaignAModifier.getNom()+"\", "
                        +"`description`=\""+campaignAModifier.getDescription()+"\", "
                        +"`date_start`=\""+campaignAModifier.getDateDebut()+"\", "
                        +"`date_end`=\""+campaignAModifier.getDateFin()+"\" "
                        +"WHERE `id`="+campaignAModifier.getId()+";";
                    System.out.println(sql);
                    connectBDD.setDatasBySQL(sql);
                    //Nettoyage de la table de laison entre la campagne et la liste de contact
                    sql = "SELECT * FROM `campaigns_and_lists_contacts` WHERE `campaigns_id`="+campaignAModifier.getId()+";";
                    System.out.println(sql);
                    datas = connectBDD.getDatasBySQL(sql);
                    try{
                        while (datas.next()) {
                            if(!datas.equals(null) && !datas.equals("")){
                                sql = "DELETE FROM `campaigns_and_lists_contacts` WHERE `campaigns_id`="+campaignAModifier.getId()+";";
                                System.out.println(sql);
                                connectBDD.setDatasBySQL(sql);
                            }
                        }
                    } catch(Exception e){ System.err.println(e); }
                    //Liaison entre la campagne et la liste de contact
                    sql = "INSERT INTO `campaigns_and_lists_contacts` "
                        +"(`campaigns_id`, `list_contacts_id`) "
                        +"VALUES ("
                        +""+campaignAModifier.getId()+","
                        +""+listContact_id+""
                        +");";
                    System.out.println(sql);
                    connectBDD.setDatasBySQL(sql);
                    //-
                    System.out.println("-> Modification de la campagne : END");
                }
            }
            
            // = = = [ Suppression d'une campaign ] = = =
            if(request.getParameter("campaign-suppr-id")!=null && !request.getParameter("campaign-suppr-id").isEmpty()){
                //-
                System.out.println("-> Suppression de la campagne : START");
                //-
                String campaignIdSelected = request.getParameter("campaign-suppr-id");
                //Nettoyage de la table de laison entre la campagne et la liste de contact
                sql = "SELECT * FROM `campaigns_and_lists_contacts` WHERE `campaigns_id`="+campaignIdSelected+";";
                System.out.println(sql);
                datas = connectBDD.getDatasBySQL(sql);
                try{
                    while (datas.next()) {
                        if(!datas.equals(null) && !datas.equals("")){
                            sql = "DELETE FROM `campaigns_and_lists_contacts` WHERE `campaigns_id`="+campaignIdSelected+";";
                            System.out.println(sql);
                            connectBDD.setDatasBySQL(sql);
                        }
                    }
                } catch(Exception e){ System.err.println(e); }
                //-
                sql = "DELETE FROM `campaigns` WHERE `id`="+campaignIdSelected+";";
                System.out.println(sql);
                connectBDD.setDatasBySQL(sql);
                //-
                System.out.println("-> Suppression de la campagne : END");
            }
            
            // Récupération des campaigns
            sql = "SELECT * FROM `campaigns`;";
            System.out.println(sql);
            datas = connectBDD.getDatasBySQL(sql);
            while (datas.next()) {
                Campaign campaign = new Campaign(datas.getInt(1), datas.getString(2), datas.getString(3), datas.getString(4), datas.getString(5), datas.getString(6));
                contentTable += ""
                    +"<!-- Item -->\n"
                    +"<div class=\"col\">\n"
                        +"<div class=\"card shadow-sm\">\n"
                            +"<div class=\"card-body\">\n"
                                +"<h4>"+campaign.getNom()+"</h4>"
                                +"<hr>"
                                +"<p class=\"card-text\">"+campaign.getDescription()+"</p>\n"
                                +"<div class=\"d-flex justify-content-between align-items-center\">\n"
                                +"<div class=\"btn-group\">\n"
                                    +"<a href=\"campaigns-send?campaign-id="+campaign.getId()+"\"><button type=\"button\" class=\"btn btn-sm btn-outline-success\">Envoyer</button></a>\n"
                                    +"<a href=\"campaigns-edit?campaign-id="+campaign.getId()+"\"><button type=\"button\" class=\"btn btn-sm btn-outline-primary\">Editer</button></a>\n"
                                    +"<a href=\"campaigns?campaign-suppr-id="+campaign.getId()+"\"><button type=\"button\" class=\"btn btn-sm btn-outline-danger\" id=\"campaigns-suppr\" name=\"campaigns-suppr\">Delete</button></a>\n"
                                +"</div>\n"
                                +"<small class=\"text-muted\">Début : "+campaign.getDateDebut()+" <br> Fin : "+campaign.getDateFin()+"</small>\n"
                                +"</div>\n"
                                +"<hr>"
                                +"<div class=\"row col-md-12 col-xs-12 text-center\">\n"
                                    +"<p class=\"statut\">Statut : "+campaign.getStatut()+"</p>"
                                +"</div>\n"
                            +"</div>\n"
                        +"</div>\n"
                    +"</div>\n";
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
                                        +"<li class=\"breadcrumb-item active\">Campagnes</li>\n"
                                    +"</ol>\n"
                                +"</nav>\n"
                            +"</div>\n"
                            //_Title_
                            +"<!-- Page - Title -->\n"
                            +"<div class=\"row col-md-12 col-xs-12 text-center\">"
                                +"<h3>Campagnes</h3>"
                                +"<p><a href=\"campaigns-new\">Créer une nouvelle campagne</a></p>"
                            +"</div>\n"
                            +"<hr>\n"
                            //_Content_
                            +"<!-- Page - Content -->\n"
                            +"<form method=\"post\" action=\"campaigns\">\n"
                                +"<div class=\"row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3\">\n"
                                    +contentTable
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
            Logger.getLogger(CampaignsLists.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CampaignsLists.class.getName()).log(Level.SEVERE, null, ex);
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
