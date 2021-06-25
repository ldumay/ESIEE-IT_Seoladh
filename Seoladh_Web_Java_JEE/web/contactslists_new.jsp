<%-- 
    Document   : contactlists.jsp
    Created on : 25 juin 2021, 11:01:30
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
                <%@ include file="includes/header.jsp" %>
                <!-- ./Header -->
                
                <!-- Header -->
                <%@ include file="includes/navbar.jsp" %>
                <!-- ./Header -->
                
                <div id="sub-container">

                    <div id="content" class="row">
                        <div class="col-md-12 col-xs-12">
                            
                            <!-- Page - Breadcrumb -->
                            <div class="row col-md-12 col-xs-12">
                                <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="index.jsp">Accueil</a></li>
                                        <li class="breadcrumb-item"><a href="contactslists.jsp">Listes de contact</a></li>
                                        <li class="breadcrumb-item active">Nouvelle listes de contact</li>
                                    </ol>
                                </nav>
                                <br>
                            </div>
                            <br><br>
                            
                            <!-- Page - Title -->
                            <div class="row col-md-12 col-xs-12 text-center"><h3>Nouvelle listes de contact</h3></div>
                            <hr>
                            
                            <!-- Page - Content -->
                            <form method="post" action="#">
                                <div class="row col-md-12 col-xs-12">
                                        <div class="row col-md-1 col-xs-1"></div>
                                        <div class="row col-md-9 col-xs-9 text-right">

                                            <!-- NomDeLaListDeContacts -->
                                            <label class="col-sm-4 col-form-label" for="nomDeLaListDeContacts">Nom de la list de contacts</label>
                                            <div class="col-sm-6"><input type="text" class="form-control" id="nomDeLaListDeContacts" name="nomDeLaListDeContacts"></div>
                                            <br><br>

                                            <!-- Contact_1_DeLaListDeContacts -->
                                            <label class="col-sm-4 col-form-label" for="contact_1_DeLaListDeContacts">Contact #1 De La List De Contacts</label>
                                            <div class="col-sm-6 input-group">
                                                <select class="form-select" aria-label="Default select example">
                                                    <option selected>Choisissez un contact</option>
                                                    <option value="contact_1">Contact 1</option>
                                                    <option value="contact_2">Contact 2</option>
                                                    <option value="contact_3">Contact 3</option>
                                                </select>
                                                <button type="button" class="btn btn-primary" name="nouveau_contact" value="nouveau_contact">+ Ajouter un contact</button>
                                            </div>
                                            <br><br>

                                        </div>
                                        <div class="row col-md-1 col-xs-1"></div>
                                </div>
                                
                                <br>

                                <div class="row col-md-12 col-xs-12">
                                    <div class="row col-md-4 col-xs-4"></div>
                                    <div class="row col-md-4 col-xs-4 text-center">
                                        <button type="submit" class="btn btn-success" name="valider" value="valider">Enregistrer</button>
                                    </div>
                                    <div class="row col-md-4 col-xs-4"></div>
                                </div>
                            </form>
                            
                        </div>
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