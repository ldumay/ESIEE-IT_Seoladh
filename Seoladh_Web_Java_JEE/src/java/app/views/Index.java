/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.views;

import app.includes.ElementsPages;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Index", urlPatterns = {"/Index"})
public class Index extends HttpServlet {
    
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
            ElementsPages elements = new ElementsPages();
            
            //Demande de connexion
            if( (request.getParameter("login")!=null && !request.getParameter("login").isEmpty() && !"".equals(request.getParameter("login"))) ){
                //-
                if( (request.getParameter("identifiant")!=null && !request.getParameter("identifiant").isEmpty() && !"".equals(request.getParameter("identifiant")))
                    && (request.getParameter("motDePasse")!=null && !request.getParameter("motDePasse").isEmpty() && !"".equals(request.getParameter("motDePasse"))) ){
                    //-
                    String identifiant = request.getParameter("identifiant");
                    String motDePasse = request.getParameter("motDePasse");
                    //nouvelle connexion
                    elements.getSessionApp().newUserConnect(identifiant, motDePasse);
                }
            }
            
            //Demande de connexion
            if( (request.getParameter("logout")!=null && !request.getParameter("logout").isEmpty() && !"".equals(request.getParameter("logout"))) ){
                elements.getSessionApp().supprUserConnect();
            }
            
            //Si connecté
            if( (elements.getSessionApp()!=null && !"".equals(elements.getSessionApp()))
                    && (elements.getSessionApp().getUserConnect()!=null && !"".equals(elements.getSessionApp().getUserConnect()))
                    && (elements.getSessionApp().getUserConnect().getIdentifiant()!=null && !"".equals(elements.getSessionApp().getUserConnect().getIdentifiant()))
                    && (elements.getSessionApp().getUserConnect().getMotDePasse()!=null && !"".equals(elements.getSessionApp().getUserConnect().getMotDePasse())) ){
                response.sendRedirect("home");
            } else {
                response.sendRedirect("auth-login");
            }
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
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
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
