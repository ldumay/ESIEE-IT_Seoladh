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
 * @author ldumay
 */
@WebServlet(name = "campaigns-send", urlPatterns = {"/campaigns-send"})
public class CampaignsSend extends HttpServlet {

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
            Campaign campaign = null;
            
            //Vérification de la campagne
            if( (!request.getParameter("campaign-id").isEmpty() && !"".equals(request.getParameter("campaign-id"))) ){
                // Variables nécessasires
                ConnectBDD connectBDD = new ConnectBDD();
                ResultSet datas = null;
                String sql = null;
                String contentTable = "";

                // = = = [ Lecture des campaigns ] = = =
                System.out.println("-> Preparation de la campagne : START");

                // = = = [ Connexion à la BDD ] = = =
                connectBDD.openConnexion();
                System.out.println("BDD : Open");

                // Récupération des campaigns
                sql = "SELECT * FROM `campaigns` WHERE `id`="+request.getParameter("campaign-id")+";";
                System.out.println(sql);
                datas = connectBDD.getDatasBySQL(sql);
                while (datas.next()) {
                    if(datas.getString(7)!=null && datas.getString(7)!=""){
                        campaign = new Campaign(datas.getInt(1), datas.getString(2), datas.getString(3), datas.getString(4), datas.getString(5), datas.getString(6), datas.getString(7));
                    } else {
                        campaign = new Campaign(datas.getInt(1), datas.getString(2), datas.getString(3), datas.getString(4), datas.getString(5), datas.getString(6));
                        campaign.setMessage("");
                    }
                }

                // Lecture de données terminée
                connectBDD.closeConnexion();
                System.out.println("-> Preparation de la campagne : END");
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
                                        +"<li class=\"breadcrumb-item\"><a href=\"campaigns\">Campagnes</a></li>\n"
                                        +"<li class=\"breadcrumb-item active\">Envoi d'une campagne</li>\n"
                                    +"</ol>\n"
                                +"</nav>\n"
                            +"</div>\n"
                            //_Title_
                            +"<!-- Page - Title -->\n"
                            +"<div class=\"row col-md-12 col-xs-12 text-center\">"
                                +"<h3>Envoie de la campagne <b>\""+campaign.getNom()+"\"</b></h3>"
                            +"</div>\n"
                            +"<hr>\n"
                            //_Content_
                            +"<!-- Page - Content -->\n"
                            +"<form method=\"post\" action=\"campaigns-send-result\" class=\"text-center\">\n"
                                +"<!-- IdDuContact -->\n"
                                +"<div class=\"col-sm-6\" style=\"display:none;\">"
                                    +"<input type=\"text\" class=\"form-control\" id=\"id\" name=\"id\" value=\""+campaign.getId()+"\">"
                                +"</div>\n"
                                +"<br><br>\n"
                                +"\n"
                                +"<div class=\"row col-md-12 col-xs-12\">\n"
                                    +"<div class=\"row col-md-6 col-xs-6\">\n"
                                        +"<h4>Détail de la campagne</h4>\n"
                                        +"<p class=\"text-left\">"
                                        +"<b>Nom :</b> "+campaign.getNom()+""
                                        +"<br><b>Description :</b> "+campaign.getDescription()+""
                                        +"<br><b>Date de début :</b> "+campaign.getDateDebut()+""
                                        +"<br><b>Date de fin :</b> "+campaign.getDateFin()+""
                                        +"</p>"
                                    +"</div>\n"
                                    +"<div class=\"row col-md-6 col-xs-6 text-center\">\n"
                                        +"<h4>Contenu du message</4h>\n"
                                        +"<br><br>\n"
                                        +"<textarea class=\"form-control\" id=\"message\" name=\"message\" rows=\"14\">"+campaign.getMessage()+"</textarea>"
                                    +"</div>\n"
                                +"</div>\n"
                                +"<br>\n"
                                +"\n"
                                +"<div class=\"row col-md-12 col-xs-12\">\n"
                                    +"<div class=\"row col-md-2 col-xs-2\"></div>\n"
                                    +"<div class=\"row col-md-3 col-xs-3 text-center\">\n"
                                        +"<button type=\"submit\" class=\"btn btn-danger\" name=\"campaign-send-cancel\" value=\"campaign-send-cancel\">Annuler l'envoyer la campagne</button>\n"
                                    +"</div>\n"
                                    +"<div class=\"row col-md-2 col-xs-2\"></div>\n"
                                    +"<div class=\"row col-md-3 col-xs-3 text-center\">\n"
                                        +"<button type=\"submit\" class=\"btn btn-success\" name=\"campaign-send\" value=\"campaign-send\">Envoyer la campagne</button>\n"
                                    +"</div>\n"
                                    +"<div class=\"row col-md-2 col-xs-2\"></div>\n"
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
            Logger.getLogger(CampaignsSend.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CampaignsSend.class.getName()).log(Level.SEVERE, null, ex);
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
