/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views;

import app.includes.ElementsPages;
import app.models.Campaign;
import app.models.Contact;
import app.models.ListContacts;
import app.network.ConnectBDD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(name = "campaigns-send-result", urlPatterns = {"/campaigns-send-result"})
public class CampaignsSendResult extends HttpServlet {

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
            Campaign campaign = null;
            boolean campaignSendCancel = false;
            String sendStatut = "";
            
            // = = = [ Connexion à la BDD ] = = =
            connectBDD.openConnexion();
            System.out.println("BDD : Open");
            
            // Récupération des campaigns
            sql = "SELECT * FROM `campaigns` WHERE `id`="+request.getParameter("id")+";";
            System.out.println(sql);
            datas = connectBDD.getDatasBySQL(sql);
            while (datas.next()) {
                campaign = new Campaign(datas.getInt(1), datas.getString(2), datas.getString(3), datas.getString(4), datas.getString(5), datas.getString(6), datas.getString(7));
            }
            
            //Envoi de la campagne annuler
            if( (request.getParameter("campaign-send-cancel")!=null && !request.getParameter("campaign-send-cancel").isEmpty() && !"".equals(request.getParameter("campaign-send-cancel"))) ){
                campaignSendCancel = true;
                sendStatut = "Annulé";
            }
            //Envoi de la campagne
            else if( (request.getParameter("campaign-send")!=null && !request.getParameter("campaign-send").isEmpty() && !"".equals(request.getParameter("campaign-send"))) ){
                sendStatut = "Envoyé";
                
                // = = = [ Lecture des campaigns ] = = =
                System.out.println("-> Envoi de la campagne : START");

                // Mise à jour du message de la campaign
                sql = "UPDATE `campaigns` SET `message`=\""+request.getParameter("message")+"\" WHERE `id`="+campaign.getId()+";";
                System.out.println(sql);
                connectBDD.setDatasBySQL(sql);
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
                                        +"<li class=\"breadcrumb-item active\">Campagne envoyé</li>\n"
                                    +"</ol>\n"
                                +"</nav>\n"
                            +"</div>\n"
                            //_Title_
                            +"<!-- Page - Title -->\n"
                            +"<div class=\"row col-md-12 col-xs-12 text-center\">"
                                +"<h3>Campagne <b>\""+campaign.getNom()+"\"</b> - "+sendStatut+"</h3>"
                            +"</div>\n"
                            +"<hr>\n"
                            //_Content_
                            +"<!-- Page - Content -->\n"
                            +"<div class=\"row col-md-12 col-xs-12 text-center\">";
                            if(!campaignSendCancel){
                                //==DEMO
                                // Lecture des listes des contact de la campagne
                                int x = 0;
                                ArrayList<ListContacts> listesDeContact = campaign.getListeContactsCollection();
                                for(ListContacts listeContacts : listesDeContact){
                                    //Lecture des contacts de la liste
                                    x++;
                                    htmlContent += "<h5>Liste de contacts #"+listeContacts.getNom()+"</h5>";
                                    ArrayList<Contact> contacts = listeContacts.getContactsCollection();
                                    int y = 0;
                                    for(Contact contact : contacts){
                                        y++;
                                        htmlContent += "<p>"
                                            +"Mail #"+x+" envoyé à : "
                                            +"<b>Contact #"+y+" :</b> "+contact.getNom()+" "+contact.getPrenom()+""
                                            +" - <b>Mail 1 :</b> "+contact.getEmail1()+""
                                            +" - <b>Mail 2 :</b> "+contact.getEmail2()+""
                                            +"</p>";
                                    }
                                }
                                
                                htmlContent += ""
                                    +"<div class=\"alert alert-success\" role=\"alert\">\n"
                                    +"La campagne a bien été envoyé.\n"
                                    +"</div>.\n";
                                
                                // Mise à jour du message de la campaign
                                sql = "UPDATE `campaigns` SET `statut`='Envoyé' WHERE `id`="+campaign.getId()+";";
                                System.out.println(sql);
                                connectBDD.setDatasBySQL(sql);
                            } else {
                                // Mise à jour du message de la campaign
                                sql = "UPDATE `campaigns` SET `statut`='Annulé' WHERE `id`="+campaign.getId()+";";
                                System.out.println(sql);
                                connectBDD.setDatasBySQL(sql);
                                
                                htmlContent += ""
                                    +"<div class=\"alert alert-danger\" role=\"alert\">\n"
                                    +"La campagne a bien été annulé.\n"
                                    +"</div>.\n";
                            }
                            htmlContent += ""
                            +"<p><a href=\"campaigns\">Retour aux campagnes</a></p>"
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
            
            // Lecture de données terminée
            connectBDD.closeConnexion();
            System.out.println("-> Envoi de la campagne : END");
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
            Logger.getLogger(CampaignsSendResult.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CampaignsSendResult.class.getName()).log(Level.SEVERE, null, ex);
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
