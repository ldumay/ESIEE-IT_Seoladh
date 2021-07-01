/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.esiee_it.projet.mvc_controllers;

import fr.esiee_it.projet.main.AppSession;
import fr.esiee_it.projet.mvc_models.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ldumay
 */
@WebServlet(name = "index", urlPatterns = {"/"})
public class Index extends HttpServlet {
    //-Attributs de base
    AppSession session;
    User userConnect;
    
    /**
     * Constcrutor
     * @throws java.sql.SQLException
     */
    public Index() throws SQLException{
        super();
        //-
        session = new AppSession("superAdmin","superAdmin");
        userConnect = session.getUserConnect();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet index</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet index at " + request.getContextPath() + "</h1>");
            out.println("<p>User Connect : ");
            out.println("<br>- identifiant : "+userConnect.getIdentifiant());
            out.println("<br>- mot de passe : "+userConnect.getMotDePasse());
            out.println("<br>");
            out.println("<br>- id : "+userConnect.getContactInfos().getId());
            out.println("<br>- nom : "+userConnect.getContactInfos().getNom());
            out.println("<br>- prénom : "+userConnect.getContactInfos().getPrenom());
            out.println("<br>- date de naissance : "+userConnect.getContactInfos().getDateNaissance());
            out.println("<br>- catégorie : "+userConnect.getContactInfos().getCategorie());
            out.println("<br>- email 1 : "+userConnect.getContactInfos().getEmail1());
            out.println("<br>- email 2 : "+userConnect.getContactInfos().getEmail2());
            out.println("<br>- téléphone 1 : "+userConnect.getContactInfos().getTel1());
            out.println("<br>- téléphone 2 : "+userConnect.getContactInfos().getTel2());
            out.println("<br>- adresse 1 : "+userConnect.getContactInfos().getAdresse1());
            out.println("<br>- adresse 2 : "+userConnect.getContactInfos().getAdresse2());
            out.println("<br>- code postal : "+userConnect.getContactInfos().getCodepostal());
            out.println("<br>- ville : "+userConnect.getContactInfos().getVille());
            out.println("<br>- pays : "+userConnect.getContactInfos().getPays());
            out.println("</p>");
            out.println("</body>");
            out.println("</html>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
