<%-- 
    Document   : parametres_serveur_smtp.jsp
    Created on : 24 juin 2021, 12:00:23
    Author     : ldumay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Head -->
<%@ include file="includes/head.jsp" %>
<!-- ./Head -->

    <!-- Body -->
    <body>
        <div class="container">

                <!-- Header -->
                <%@ include file="includes/header.jsp" %>
                <!-- ./Header -->
                
                <!-- Header -->
                <%@ include file="includes/navbar.jsp" %>
                <!-- ./Header -->
                
                <div id="sub-container">

                    <div id="content">
                        
                        <!-- Page - Breadcrumb -->
                        <div class="row col-md-12 col-xs-12">
                            <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="index.jsp">Accueil</a></li>
                                    <li class="breadcrumb-item">Paramètres</li>
                                    <li class="breadcrumb-item active">Serveur SMTP</li>
                                </ol>
                            </nav>
                        </div>
                        <br><br>
                        
                        <!-- Page - Title -->
                        <div class="row col-md-12 col-xs-12 text-center"><h3>Serveur SMTP</h3></div>
                        <hr>
                        
                        <!-- Page - Formulaire Serveur SMTP -->
                        <form method="post" action="#">
                            <div class="row col-md-12 col-xs-12">
                                    <div class="row col-md-1 col-xs-1"></div>
                                    <div class="row col-md-9 col-xs-9 text-right">

                                        <!-- NomDuServeur -->
                                        <label class="col-sm-4 col-form-label" for="nomDuServeur">Nom du serveur</label>
                                        <div class="col-sm-6"><input type="text" class="form-control" id="nomDuServeur" name="nomDuServeur"></div>
                                        <br><br>

                                        <!-- AdresseDuServeurEnvoi -->
                                        <label class="col-sm-4 col-form-label" for="adresseDuServeurEnvoi">Adresse du serveur d'envoi</label>
                                        <div class="col-sm-6 input-group">
                                            <input type="email" class="form-control box-serveur" id="adresseDuServeurEnvoi" name="adresseDuServeurEnvoi">
                                            <input type="text" class="form-control box-serveur-port" id="adresseDuServeurEnvoiPort" name="adresseDuServeurEnvoiPort" placeholder="Port">
                                        </div>
                                        <br><br>

                                        <!-- AdresseEmailExpediteur -->
                                        <label class="col-sm-4 col-form-label" for="adresseEmailExpediteur">Adresse de l'email de l'expéditeur</label>
                                        <div class="col-sm-6"><input type="email" class="form-control" id="adresseEmailExpediteur" name="adresseEmailExpediteur"></div>
                                        <br><br>

                                        <!-- MotDePasseEmailExpediteur -->
                                        <label class="col-sm-4 col-form-label" for="motDePasseEmailExpediteur">Mot de passe de l'email de l'expéditeur</label>
                                        <div class="col-sm-6"><input type="password" class="form-control" id="motDePasseEmailExpediteur"></div>
                                        <br><br>
                                        
                                        <!-- ChoixProtocole -->
                                        <label class="col-sm-4 col-form-label" for="choixProtocole">Default checkbox</label>
                                        <div class="col-sm-1 text-left"><input class="form-check-input" type="checkbox" name="choixProtocole" id="choixProtocole" value=""></div>

                                    </div>
                                    <div class="row col-md-1 col-xs-1"></div>
                            </div>
                        
                            <div class="row col-md-12 col-xs-12">
                                <div class="row col-md-4 col-xs-4"></div>
                                <div class="row col-md-4 col-xs-4 text-center">
                                    <button type="submit" class="btn btn-success" name="valider" value="valider">Enregistrer</button>
                                </div>
                                <div class="row col-md-4 col-xs-4"></div>
                            </div>
                        </form>
                        
                    </div>
                    
                    <hr>
                    
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