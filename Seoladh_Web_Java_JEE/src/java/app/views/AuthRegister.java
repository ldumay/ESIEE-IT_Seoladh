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
 * @author ldumay
 */
@WebServlet(name = "auth-register", urlPatterns = {"/auth-register"})
public class AuthRegister extends HttpServlet {

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
                +elements.getHeaderContentLogin()
                //_Content_
                +"<div id=\"sub-container\">\n"
                    +"<div id=\"content\" class=\"row\">"
                        +"<div class=\"col-md-12 col-xs-12 text-center\">"
                            +"<p><a href=\"auth-login\">Vous connecter</a></p>"
                        +"</div>"
                        +"<hr>"
                        +"<div class=\"col-md-12 col-xs-12\">"
                            +"<form method=\"post\" action=\"index\">\n"
                                +"<div class=\"mb-3\">"
                                    +"<label for=\"identifiant\" class=\"form-label\">Identifiant</label>"
                                    +"<input type=\"text\" name\"identifiant\" name\"identifiant\" class=\"form-control\" id=\"identifiant\">"
                                +"</div>"
                                +"<div class=\"mb-3\">"
                                    +"<label for=\"motDePasse\" class=\"form-label\">Mot de passe</label>"
                                    +"<input type=\"password\" name\"motDePasse\" name\"motDePasse\" class=\"form-control\" id=\"motDePasse\">"
                                +"</div>"
                                +"<div class=\"mb-3\">"
                                    +"<label for=\"confirmationMotDePasse\" class=\"form-label\">Confirmation du mot de passe</label>"
                                    +"<input type=\"password\" name\"confirmationMotDePasse\" name\"confirmationMotDePasse\" class=\"form-control\" id=\"confirmationMotDePasse\">"
                                +"</div>"
                                +"<button type=\"submit\" class=\"btn btn-success\" name=\"register\" id=\"register\" value=\"register\">Inscription</button>"
                            +"</form>"
                        +"</div>"
                    +"</div>"
                    +"\n"
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
            Logger.getLogger(AuthRegister.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AuthRegister.class.getName()).log(Level.SEVERE, null, ex);
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
