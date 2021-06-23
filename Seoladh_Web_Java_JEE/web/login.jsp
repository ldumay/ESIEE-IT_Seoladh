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
                            <form>
                                <div class="mb-3">
                                <label for="identifiant" class="form-label">Identifiant</label>
                                <input type="text" class="form-control" id="identifiant">
                                </div>
                                <div class="mb-3">
                                <label for="motDePasse" class="form-label">Mot de passe</label>
                                <input type="password" class="form-control" id="motDePasse">
                                </div>
                                <a href="accueil.html"><button type="button" class="btn btn-success">Connexion</button></a>
                            </form>
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