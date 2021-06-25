<%-- 
    Document   : login.jsp
    Created on : 23 juin 2021, 21:56:13
    Author     : mtl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Head -->
<%@ include file="includes/head.jsp" %>
<!-- ./Head -->

    <!-- Body -->
    <body>
        <div class="container">

                <!-- Header -->
                <%@ include file="includes/header_login.jsp" %>
                <!-- ./Header -->
                
                <div id="sub-container">

                    <div id="content" class="row">
                        <div class="col-md-12 col-xs-12">
                            
                            <!-- Page - Content -->
                            <div class="text-center">
                                <br><br>
                                <h3>Vous êtes déconnecter</h3>
                                <br><br>
                                <p>
                                    <a href="register.jsp">Inscription</a> | <a href="login.jsp">Connexion</a> | <a href="home.jsp">Accueil</a>
                                </p>
                                <br><br>
                            </div>
                        </div>
                    </div>
                    
                    <!-- Header -->
                    <%@ include file="includes/footer.jsp" %>
                    <!-- ./Header -->
                    
                </div>
    
        </div>
    </body>
    <!-- ./Body -->
    
<!-- Foot -->
<%@ include file="includes/foot.jsp" %>
<!-- ./Foot -->