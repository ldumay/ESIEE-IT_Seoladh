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
                        <div class="col-md-12 col-xs-12 text-center list-style-custom">
                            <h1>Seoladh Web - [Java JEE]</h1>
                            <h2>Pages de test</h2>
                            <hr>
                            <ul>
                                <li><a href="home.jsp">[InAPP] > Accueil</a></li>
                            </ul>
                            <hr>
                        </div>
                    </div>
                    
                    <!-- Header -->
                    <%@ include file="includes/footer.jsp" %>
                    <!-- ./Header -->
                    
                </div>
        </div>
        
    </body>
</html>