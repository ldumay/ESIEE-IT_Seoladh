<%-- 
    Document   : index.jsp
    Created on : 23 juin 2021, 17:37:16
    Author     : ldumay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        <div class="col-md-12 col-xs-12 text-center">
                            <h1>Seoladh Web - [Java JEE]</h1>
                            <h2>Pages en cours</h2>
                            <ul>
                                <li><a href="register.jsp">Page d'inscription</a></li>
                                <li><a href="login.jsp">Page de connexion</a></li>
                                <li><a href="accueil.jsp">Page d'accueil</a></li>
                                <li><a href="campaigns.jsp">Page des campagnes</a></li>
                                <li><a href="adminAccountManagment.jsp">Gestion des comptes</a></li>
                                <li><a href="#">Template</a></li>
                                <li><a href="#">Template</a></li>
                                <li><a href="#">Template</a></li>
                            </ul>
                        </div>
                    </div>
                    
                    <!-- Header -->
                    <%@ include file="includes/footer.jsp" %>
                    <!-- ./Header -->
                    
                </div>
        </div>
        
    </body>
</html>