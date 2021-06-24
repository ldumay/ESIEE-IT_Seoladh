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
                            <h2>Pages en cours</h2>
                            <hr>
                            <ul>
                                <li><a href="register.jsp">[AUTH] > Page d'inscription</a></li>
                                <li><a href="login.jsp">[AUTH] > Page de connexion</a></li>
                            </ul>
                            <ul>
                                <li><a href="home.jsp">[InAPP] > Accueil</a></li>
                            </ul>
                            <ul>
                                <li><a href="campaigns.jsp">[InAPP] > Campagnes - Toutes les campagnes</a></li>
                                <li><a href="campaigns_new.jsp">[InAPP] > Campagnes - Nouvel campagne</a></li>
                                <li><a href="campaigns_import.jsp">[InAPP] > Campagnes - Importation</a></li>
                                <li><a href="campaigns_export.jsp">[InAPP] > Campagnes - Exportation</a></li>
                            </ul>
                            <ul>
                                <li><a href="contactslists.jsp">[InAPP] > Listes de contacts - Toutes les listes de contacts</a></li>
                                <li><a href="contactslists_new.jsp">[InAPP] > Listes de contacts - Nouvel liste de contacts</a></li>
                                <li><a href="contactslists_clean_doublons.jsp">[InAPP] > Listes de contacts - Nettoyage des doublons</a></li>
                                <li><a href="contactslists_blacklist.jsp">[InAPP] > Listes de contacts - Blacklist</a></li>
                                <li><a href="contactslists_import.jsp">[InAPP] > Listes de contacts - Importation</a></li>
                                <li><a href="contactslists_export.jsp">[InAPP] > Listes de contacts - Exportation</a></li>
                            </ul>
                            <ul>
                                <li><a href="contacts.jsp">[InAPP] > Contacts - La liste de tous les contacts</a></li>
                                <li><a href="contacts_new.jsp">[InAPP] > Contacts - Nouveau contact</a></li>
                                <li><a href="contacts_import.jsp">[InAPP] > Contacts - Importation</a></li>
                                <li><a href="contacts_export.jsp">[InAPP] > Contacts - Exportation</a></li>
                            </ul>
                            <ul>
                                <li><a href="emails.jsp">[InAPP] > Liste des emails - La liste de tous les emails</a></li>
                                <li><a href="emails_import.jsp">[InAPP] > Liste des emails - Importations</a></li>
                                <li><a href="emails_export.jsp">[InAPP] > Liste des emails - Exportations</a></li>
                            </ul>
                            <ul>
                                <li><a href="admin.jsp">[InAPP] > Administration</a></li>
                                <li><a href="admin_management_accounts.jsp">[InAPP] > Administration - Gestion des Comptes</a></li>
                                <li><a href="admin_management_roles.jsp">[InAPP] > Administration - Gestion des rôles</a></li>
                            </ul>
                            <ul>
                                <li><a href="configs.jsp">[InAPP] > Paramètre</a></li>
                                <li><a href="configs_server_smtp.jsp">[InAPP] > Paramètre - Serveur sSMTP</a></li>
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