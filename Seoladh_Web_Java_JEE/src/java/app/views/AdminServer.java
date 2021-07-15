/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views;

import app.includes.ElementsPages;
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
@WebServlet(name = "admin-server", urlPatterns = {"/admin-server"})
public class AdminServer extends HttpServlet {

    ElementsPages elements;

    public AdminServer() throws SQLException {
        this.elements = new ElementsPages();
    }
    
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
            System.out.println("-> Récupération serveur STMP : START");

            // = = = [ Connexion à la BDD ] = = =
            connectBDD.openConnexion();
            System.out.println("BDD : Open");
        
            // = = = [ Suppression d'un contact ] = = =
            if(request.getParameter("admin-server-edit")!=null){
                //-Validation Ajout Film
                if( (!request.getParameter("admin-server-edit").isEmpty() && !"".equals(request.getParameter("admin-server-edit"))) ){
                    //-
                    System.out.println("-> Edition du server : START");
                    //-
                    sql = "UPDATE `admin_server` SET "
                        +"`nom_du_serveur`=\""+request.getParameter("nomDuServeur")+"\", "
                        +"`adresse_du_serveur`=\""+request.getParameter("adresseDuServeurEnvoi")+"\", "
                        +"`port_du_serveur`=\""+request.getParameter("adresseDuServeurEnvoiPort")+"\", "
                        +"`adresse_email_du_serveur`=\""+request.getParameter("adresseEmailExpediteur")+"\", "
                        +"`mot_de_passe_du_serveur`=\""+request.getParameter("motDePasseEmailExpediteur")+"\" "
                        +"WHERE `id`=1;";
                    System.out.println(sql);
                    connectBDD.setDatasBySQL(sql);
                    //-
                    System.out.println("-> Edition du server : END");
                }
            }
            
            // Lecture de données terminée
            connectBDD.closeConnexion();
            System.out.println("-> Récupération serveur STMP : END");
            
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
                                        +"<li class=\"breadcrumb-item active\">Serveur SMTP</li>\n"
                                    +"</ol>\n"
                                +"</nav>\n"
                            +"</div>\n"
                            //_Title_
                            +"<!-- Page - Title -->\n"
                            +"<div class=\"row col-md-12 col-xs-12 text-center\">"
                                +"<h3>Serveur SMTP</h3>"
                            +"</div>\n"
                            +"<hr>\n"
                            //_Content_
                            +"<!-- Page - Content -->\n"
                            +"<form method=\"post\" action=\"#\">\n"
                                +"<div class=\"row col-md-12 col-xs-12\">\n"
                                    +"<div class=\"row col-md-1 col-xs-1\"></div>\n"
                                        +"<div class=\"row col-md-9 col-xs-9 text-right\">\n"
                                        +"\n"
                                        +"<!-- NomDuServeur -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"nomDuServeur\">Nom du serveur</label>\n"
                                        +"<div class=\"col-sm-6\"><input type=\"text\" class=\"form-control\" id=\"nomDuServeur\" name=\"nomDuServeur\" placeholder=\"Nom du serveur\" value=\""+elements.getServeurSMTP().getNomDuServeur()+"\"></div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- AdresseDuServeurEnvoi -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"adresseDuServeurEnvoi\">Adresse du serveur d'envoi</label>\n"
                                        +"<div class=\"col-sm-6 input-group\">\n"
                                            +"<input type=\"text\" class=\"form-control box-serveur\" id=\"adresseDuServeurEnvoi\" name=\"adresseDuServeurEnvoi\" placeholder=\"Adresse du serveur\" value=\""+elements.getServeurSMTP().getAdresseDuServeur()+"\">\n"
                                            +"<input type=\"text\" class=\"form-control box-serveur-port\" id=\"adresseDuServeurEnvoiPort\" name=\"adresseDuServeurEnvoiPort\" placeholder=\"Port\" value=\""+elements.getServeurSMTP().getPortDuServeur()+"\">\n"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- AdresseEmailExpediteur -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"adresseEmailExpediteur\">Adresse de l'email de l'expéditeur</label>\n"
                                        +"<div class=\"col-sm-6\"><input type=\"email\" class=\"form-control\" id=\"adresseEmailExpediteur\" name=\"adresseEmailExpediteur\" placeholder=\"Adresse de l'email de l'expéditeur\" value=\""+elements.getServeurSMTP().getAdresseEmailDuServeur()+"\"></div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- MotDePasseEmailExpediteur -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"motDePasseEmailExpediteur\">Mot de passe de l'email de l'expéditeur</label>\n"
                                        +"<div class=\"col-sm-6\"><input type=\"password\" class=\"form-control\" id=\"motDePasseEmailExpediteur\" name=\"motDePasseEmailExpediteur\" placeholder=\"Mot de passe de l'email de l'expéditeur\" value=\""+elements.getServeurSMTP().getMotDePasseDuServeur()+"\"></div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        /*
                                        +"<!-- ChoixProtocole -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"choixProtocole\">Default checkbox</label>\n"
                                        +"<div class=\"col-sm-1 text-left\"><input class=\"form-check-input\" type=\"checkbox\" name=\"choixProtocole\" id=\"choixProtocole\"></div>\n"
                                        +"\n"
                                        */
                                     +"</div>\n"
                                    +"<div class=\"row col-md-1 col-xs-1\"></div>\n"
                                +"</div>\n"
                                +"\n"
                                +"<div class=\"row col-md-12 col-xs-12\">\n"
                                    +"<div class=\"row col-md-4 col-xs-4\"></div>\n"
                                    +"<div class=\"row col-md-4 col-xs-4 text-center\">\n"
                                        +"<button type=\"submit\" class=\"btn btn-success\" name=\"admin-server-edit\" value=\"admin-server-edit\">Enregistrer</button>\n"
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
            Logger.getLogger(AdminServer.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AdminServer.class.getName()).log(Level.SEVERE, null, ex);
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
