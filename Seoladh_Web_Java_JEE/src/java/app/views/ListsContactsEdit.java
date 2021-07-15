/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views;

import app.includes.ElementsPages;
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
@WebServlet(name = "lists-contacts-edit", urlPatterns = {"/lists-contacts-edit"})
public class ListsContactsEdit extends HttpServlet {

    ListContacts listsContactsAModifier = new ListContacts();
    
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
            ArrayList<Contact> tousLesContacts = new ArrayList();
            
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
                    sql = "SELECT * FROM `lists_contacts` WHERE `id`="+request.getParameter("contact-edit-id")+";";
                    System.out.println(sql);
                    datas = connectBDD.getDatasBySQL(sql);
                    while (datas.next()) {
                        listsContactsAModifier = new ListContacts(datas.getInt(1), datas.getString(2), datas.getString(3),
                            datas.getString(4), datas.getString(5));
                    }
                    //-
                    System.out.println("-> Edition de contact : END");
                }
            }
            
            // Récupération de tous les contacts
            sql = "SELECT "
                +"`id`, "
                +"`nom`, "
                +"`prenom`, "
                +"`dateNaissance`, "
                +"`email1`, "
                +"`email2`"
                +"FROM `contacts` WHERE `blacklist`=1";
            System.out.println(sql);
            datas = connectBDD.getDatasBySQL(sql);
            while (datas.next()) {
                Contact contact = new Contact(datas.getInt(1), datas.getString(2), datas.getString(3), datas.getString(4),
                        datas.getString(5), datas.getString(6));
                Contact contactVerifier = null;
                /*
                ===[Section BUGGER - à vérifer]===
                // Vérification de la présence du contact dans une liste
                sql = "SELECT "
                    +"c.`id`, "
                    +"c.`nom`, "
                    +"c.`prenom`, "
                    +"c.`dateNaissance`, "
                    +"c.`email1`, "
                    +"c.`email2` "
                    +"FROM "
                    +"`lists_contacts_and_contacts` lcc, "
                    +"`contacts` c, "
                    +"`lists_contacts` lc "
                    +"WHERE "
                    +"c.`id`=lcc.`contact_id` "
                    +"AND lc.`id`=lcc.`list_contacts_id` "
                    +"AND c.`blacklist`=1 "
                    +"AND c.`id`="+contact.getId()+";";
                System.out.println(sql);
                datas = connectBDD.getDatasBySQL(sql);
                while (datas.next()) {
                    contactVerifier = new Contact(datas.getInt(1), datas.getString(2), datas.getString(3), datas.getString(4),
                        datas.getString(5), datas.getString(6));
                    if(!contact.equals(contactVerifier)){
                        contacts.add(contact);
                    }
                }
                */
                tousLesContacts.add(contact);
            }
            
            //Génération de la liste des contact disponible
            ArrayList<Contact> contactsDeLaListe = listsContactsAModifier.getContactsCollection();
            String checked = "";
            for(Contact contact : tousLesContacts){
                for(Contact contactCheck : contactsDeLaListe){
                    if(contact.getId()==contactCheck.getId())
                        checked = "checked";
                }
                contentTable += "<tr>\n"
                            +"<td>"
                            +"<input class=\"form-check-input\" type=\"checkbox\" id=\"contact_"+contact.getId()+"\" name=\"contact_"+contact.getId()+"\" value=\""+contact.getId()+"\" "+checked+">\n"
                            +"</td>"
                            +"<td>"+contact.getNom()+"</td>\n"
                            +"<td>"+contact.getPrenom()+"</td>\n"
                            +"<td>"+contact.getDateNaissance()+"</td>\n"
                            +"<td>"+contact.getEmail1()+"</td>\n"
                            +"<td>"+contact.getEmail2()+"</td>\n";
                contentTable +="</tr>\n";
                checked = "";
            }
            
            // Lecture de données terminée
            connectBDD.closeConnexion();
            System.out.println("-> lists de contacts : END");
            
            //-
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
                                        +"<li class=\"breadcrumb-item\"><a href=\"lists-contacts\">Listes de contacts</a></li>\n"
                                        +"<li class=\"breadcrumb-item active\">Modification de la liste de contacts</li>\n"
                                    +"</ol>\n"
                                +"</nav>\n"
                            +"</div>\n"
                            //_Title_
                            +"<!-- Page - Title -->\n"
                            +"<div class=\"row col-md-12 col-xs-12 text-center\">"
                                +"<h3>Modification de la liste de contacts</h3>"
                            +"</div>\n"
                            +"<hr>\n"
                            //_Content_
                            +"<!-- Page - Content -->\n"
                            +"<form method=\"post\" action=\"lists-contacts\">\n"
                                +"<div class=\"row col-md-12 col-xs-12\">\n"
                                    +"<div class=\"row col-md-1 col-xs-1\"></div>\n"
                                    +"<div class=\"row col-md-9 col-xs-9 text-right\">\n"
                                        +"<!-- IdDuContact -->\n"
                                        +"<div class=\"col-sm-6\" style=\"display:none;\">"
                                            +"<input type=\"text\" class=\"form-control\" id=\"id\" name=\"id\" value=\""+listsContactsAModifier.getId()+"\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"\n"
                                        +"<!-- ListeDeContact_Nom -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"nom\">Nom</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"text\" class=\"form-control\" id=\"nom\" name=\"nom\" maxlength=\"32\" placeholder=\"Nom\" value=\""+listsContactsAModifier.getNom()+"\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- ListeDeContact_Description -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"description\">Description</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"text\" class=\"form-control\" id=\"description\" name=\"description\" maxlength=\"32\" placeholder=\"Description\" value=\""+listsContactsAModifier.getDescription()+"\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- ListeDeContact_DateDeDebut -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"dateDeDebut\">Date de début</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"text\" class=\"form-control\" id=\"dateDeDebut\" name=\"dateDeDebut\" maxlength=\"32\" placeholder=\"Date de début (AAAA-MM-DD)\" value=\""+listsContactsAModifier.getDateDebut()+"\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                        +"<!-- ListeDeContact_DateDeFin -->\n"
                                        +"<label class=\"col-sm-4 col-form-label\" for=\"dateDeFin\">Date de fin</label>\n"
                                        +"<div class=\"col-sm-6\">"
                                            +"<input type=\"text\" class=\"form-control\" id=\"dateDeFin\" name=\"dateDeFin\" maxlength=\"32\" placeholder=\"Date de fin (AAAA-MM-DD)\" value=\""+listsContactsAModifier.getDateFin()+"\">"
                                        +"</div>\n"
                                        +"<br><br>\n"
                                        +"\n"
                                    +"</div>\n"
                                +"</div>\n"
                                +"<br><br>\n"
                                +"\n"
                                +"<!-- ListDeContacts_choix_des_contacts -->\n"
                                +"<div id=\"liste-de-contact-table\" class=\"row col-md-12 col-xs-12\">\n"
                                    +"<table class=\"table table-bordered text-center\">\n"
                                        +"<thead>\n"
                                            +"<tr>\n"
                                                +"<th scope=\"col\">#</th>\n"
                                                +"<th scope=\"col\">Nom</th>\n"
                                                +"<th scope=\"col\">Prénom</th>\n"
                                                +"<th scope=\"col\">Date de naissance</th>\n"
                                                +"<th scope=\"col\">Mail 1</th>\n"
                                                +"<th scope=\"col\">Mail 2</th>\n"
                                            +"</tr>\n"
                                        +"</thead>\n"
                                        +"<tbody>\n"
                                            +contentTable
                                        +"</tbody>\n"
                                    +"</table>"
                                +"</div>\n"
                                +"<br>\n"
                                +"\n"
                                +"<div class=\"row col-md-12 col-xs-12\">\n"
                                    +"<div class=\"row col-md-4 col-xs-4\"></div>\n"
                                    +"<div class=\"row col-md-4 col-xs-4 text-center\">\n"
                                        +"<button type=\"submit\" class=\"btn btn-success\" name=\"list-contacts-edit\" value=\"list-contacts-edit\">Modifier la liste de contacts</button>\n"
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
            Logger.getLogger(ListsContactsEdit.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ListsContactsEdit.class.getName()).log(Level.SEVERE, null, ex);
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
