<%-- 
    Document   : index.jsp
    Created on : 23 juin 2021, 17:37:16
    Author     : ldumay
--%>

<%@page import="fr.esiee_it.projet.main.AppSession"%>
<%@page import="fr.esiee_it.projet.mvc_models.User"%>

<%@page import="java.sql.*"%>
<%@page import="java.lang.*"%>
<%@page import="org.apache.jasper.*"%>
<%@page import="org.apache.jasper.JasperException"%>
<%@page import="com.sun.corba.se.spi.presentation.rmi.StubAdapter.*"%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<%-- <%@ include file="includes/session.jsp" %> --%>

<!DOCTYPE html>
<html>
    <head>
        <title>Seoladh Web - [Java JEE]</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    
    <!-- Head -->
    <%@ include file="includes/head.jsp" %>
    <!-- ./Head -->
    
    <div class="container">

                <!-- Header -->
                <%@ include file="includes/header.jsp" %>
                <!-- ./Header -->
                
                <div id="sub-container">

                    <div id="content" class="row">
                        <div class="col-md-12 col-xs-12 text-center list-style-custom">
                            
                            <!-- Page - Title -->
                            <div class="row col-md-12 col-xs-12 text-center"><h3>Nouveau contacts</h3></div>
                            <hr>
                            
                            <!-- Page - Content -->
                            <%! 
                                /*
                                AppSession session = (AppSession) request.getAttribute("session");
                                User userConnect = (User) request.getAttribute("userConnect");
                                */
                            %>
                            
                            <%-- ${ !userConnect.equals(null) ? System.out.println(userConnect.getNom()) : System.out.println("userConnect vite !") } --%>
                            
                            <p>User Connect :
                                <%--
                                <br>- identifiant : <%= userConnect.getNom() %>
                                <br>- mot de passe : <%= userConnect.getMotDePasse() %>
                                <br>
                                <br>- id : <%= userConnect.getContactInfos().getId() %>
                                <br>- nom : <%= userConnect.getContactInfos().getNom() %>
                                <br>- prénom : <%= userConnect.getContactInfos().getPrenom() %>
                                <br>- date de naissance : <%= userConnect.getContactInfos().getDateNaissance() %>
                                <br>- catégorie : <%= userConnect.getContactInfos().getCategorie() %>
                                <br>- email 1 : <%= userConnect.getContactInfos().getEmail1() %>
                                <br>- email 2 : <%= userConnect.getContactInfos().getEmail2() %>
                                <br>- téléphone 1 : <%= userConnect.getContactInfos().getTel1() %>
                                <br>- téléphone 2 : <%= userConnect.getContactInfos().getTel2() %>
                                <br>- adresse 1 : <%= userConnect.getContactInfos().getAdresse1() %>
                                <br>- adresse 2 : <%= userConnect.getContactInfos().getAdresse2() %>
                                <br>- code postal : <%= userConnect.getContactInfos().getCodepostal() %>
                                <br>- ville : <%= userConnect.getContactInfos().getVille() %>
                                <br>- pays : <%= userConnect.getContactInfos().getPays() %>
                                --%>
                            </p>
                            
                            <br>
                            
                        </div>
                    </div>
                    
                    <!-- Header -->
                    <%@ include file="includes/footer.jsp" %>
                    <!-- ./Header -->
                    
                </div>
        </div>
        
    </body>
</html>