/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.includes;

import app.models.User;
import app.network.AppSession;
import java.sql.SQLException;

/**
 *
 * @author ldumay
 */
public class ElementsPages {
    
    //-Attributs de base
    private AppSession session;
    private User userConnect;
    private String headBody;
    private String headerContent;
    private String headercontentLogin;
    private String navbarContent;
    private String footerContent;
    private String footBody;
    
    /**
     * Constructor
     * @throws java.sql.SQLException
     */
    public ElementsPages() throws SQLException{
        
        session = new AppSession("superAdmin","superAdmin");
        userConnect = session.getUserConnect();
        
        //Création de la head du contenu de la page HTML
        this.headBody = ""
            +"<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//FR\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"
            +"<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"fr\">\n"
            +"<head>\n"
                +"<!-- Title -->\n"
                +"<title>Seoladh Web - [Java JEE]</title>\n"
                +"<!-- ./Title -->\n"
                +"\n"
                +"<!-- MetasDatas -->\n"
                +"<meta http-equiv=\"Content-Type\" content=\"text/html, charset=UTF-8\" />\n"
                +"<meta name=\"Content-Language\" content=\"fr\" />\n"
                +"<meta name=\"keywords\" content=\"ITESCIA, ESIEE-IT, Projet, Licence, L3\" />\n"
                +"\n"
                +"<meta content=\"IE=edge\" http-equiv=\"X-UA-Compatible\" />\n"
                +"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n"
                +"\n"
                +"<!-- ./MetasDatas -->\n"
                +"\n"
                +"<!-- Favicon -->\n"
                +"<link rel=\"shortcut icon\" href=\"https://dev.ldumay.fr/resources/img/favicons/favicon.png\"/>\n"
                +"<!-- ./Favicon -->\n"
                +"\n"
                +"<!-- Apple Icon -->\n"
                +"<link rel=\"apple-touch-icon\" href=\"https://dev.ldumay.fr/resources/img/favicons/favicon_apple.png\"/>\n"
                +"<!-- ./Apple Icon -->\n"
                +"\n"
                +"<!-- Icons -->\n"
                +"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://glyphsearch.com/bower_components/font-awesome/css/all.min.css\"/>\n"
                +"\n"
                +"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://dev.ldumay.fr/resources/icons/font-awesome/font-awesome.css\"/>\n"
                +"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://dev.ldumay.fr/resources/icons/foundation-icons/foundation-icons.css\"/>\n"
                +"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://dev.ldumay.fr/resources/icons/ico-moon/ico-moon.css\"/>\n"
                +"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://dev.ldumay.fr/resources/icons/ion-icons/ion-icons.css\"/>\n"
                +"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://dev.ldumay.fr/resources/icons/material-design-icons/material-design-icons.css\"/>\n"
                +"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://dev.ldumay.fr/resources/icons/oct-icons/oct-icons.css\"/>\n"
                +"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://dev.ldumay.fr/resources/icons/pe7-stroke-icons/pe-icon-7-stroke.css\"/>\n"
                +"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://dev.ldumay.fr/resources/icons/simple-line-icons/simple-line-icons.css\"/>\n"
                +"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://dev.ldumay.fr/resources/icons/themify-icons/themify-icons.css\"/>\n"
                +"<!-- ./Icons -->\n"
                +"\n"
                +"<!-- Bootstrap core CSS -->\n"
                +"<!-- v5.0.2 -->\n"
                +"<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\n"
                +"\n"
                +"<!-- GoogleFonts -->\n"
                +"<link rel=\"stylesheet\" type=\"text/css\" href=\"https://fonts.googleapis.com/css?family=Poiret+One&family=Alatsi&family=Roboto&family=Righteous\"/>\n"
                +"<!-- ./GoogleFonts -->\n"
                +"\n"
                +"<!-- StylesCustom -->\n"
                +"<link rel=\"stylesheet\" type=\"text/css\" href=\"css/styles.css\"/>\n"
                +"<link rel=\"stylesheet\" type=\"text/css\" href=\"css/fonts.css\"/>\n"
                +"<link rel=\"stylesheet\" type=\"text/css\" href=\"css/navbar.css\"/>\n"
                +"<link rel=\"stylesheet\" type=\"text/css\" href=\"css/breadcrumb.css\"/>\n"
                +"<link rel=\"stylesheet\" type=\"text/css\" href=\"css/logo.css\"/>\n"
                +"<link rel=\"stylesheet\" type=\"text/css\" href=\"css/medias_queries.css\"/>\n"
                +"<!-- ./StylesCustom -->\n"
            +"</head>";
        
        //Création du header du contenu de la page HTML
        this.headerContent = ""
            +"<div id=\"logo\" class=\"row\">\n"
                +"<div class=\"col-md-12 col-xs-12 logo\">\n"
                    +"<a href=\"home\">\n"
                        +"<img src=\"images/logo/Seoladh_4.png\"/>\n"
                    +"</a>\n"
                +"</div>\n"
            +"</div>";
        
        //Création du header des pages de logins du contenu de la page HTML
        this.headercontentLogin = ""
            +"<div id=\"logo-login\" class=\"row\">\n"
                +"<div class=\"col-md-12 col-xs-12 logo\">\n"
                    +"<img src=\"images/logo/Seoladh_4.png\"/>\n"
                +"</div>\n"
            +"</div>";
        
        //Création de navbar du contenu de la page HTML
        this.navbarContent = ""
            +"<div id=\"nav-bar\">\n"
                +"<div class=\"row\">\n"
                    +"<div class=\"col-md-12 col-xs-12\">\n"
                    +"\n"
                    +"<nav class=\"navbar navbar-expand-lg navbar-light bg-light rounded\" aria-label=\"Twelfth navbar example\">\n"
                        +"<div class=\"container-fluid\">\n"
                            +"<button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarsExample10\" aria-controls=\"navbarsExample10\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n"
                                +"<span class=\"navbar-toggler-icon\"></span>\n"
                            +"</button>\n"
                            +"\n"
                            +"<div class=\"collapse navbar-collapse justify-content-md-center\" id=\"navbarsExample10\">\n"
                                +"<ul class=\"navbar-nav\">\n"
                                    +"<!-- Accueil -->\n"
                                    +"<li class=\"nav-item\">"
                                        +"<a class=\"nav-link active\" href=\"home\">Accueil</a>"
                                    +"</li>\n"
                                    +"\n"
                                    +"<!-- Campagnes -->\n"
                                    +"<li class=\"nav-item dropdown\">\n"
                                        +"<a class=\"nav-link dropdown-toggle\" id=\"campagnes\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">Campagnes</a>\n"
                                        +"<ul class=\"dropdown-menu\" aria-labelledby=\"campagnes\">\n"
                                            +"<li><a class=\"dropdown-item\" href=\"campaigns\">Liste des campagnes</a></li>\n"
                                            +"<li><a class=\"dropdown-item\" href=\"campaigns-new\">Nouvel campagne</a></li>\n"
                                            +"<li><a class=\"dropdown-item\" href=\"campaigns-import\">Importation des campagnes</a></li>\n"
                                            +"<li><a class=\"dropdown-item\" href=\"campaigns-export\">Exportation des campagnes</a></li>\n"
                                        +"</ul>\n"
                                    +"</li>\n"
                                    +"\n"
                                    +"<!-- ListeDeContacts -->\n"
                                    +"<li class=\"nav-item dropdown\">\n"
                                        +"<a class=\"nav-link dropdown-toggle\" id=\"listesDeContacts\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">Listes de contacts</a>\n"
                                        +"<ul class=\"dropdown-menu\" aria-labelledby=\"listesDeContacts\">\n"
                                            +"<li><a class=\"dropdown-item\" href=\"lists-contacts\">Listes de contacts</a></li>\n"
                                            +"<li><a class=\"dropdown-item\" href=\"lists-contacts-new\">Nouvelle liste de contacts</a></li>\n"
                                            +"<li><a class=\"dropdown-item\" href=\"lists-contacts-clean\">Nettoyage des doublons et erreurs d'emails</a></li>\n"
                                            +"<li><a class=\"dropdown-item\" href=\"lists-contacts-import\">Importation de listes de contacts</a></li>\n"
                                            +"<li><a class=\"dropdown-item\" href=\"lists-contacts-export\">Exportation de listes de contacts</a></li>\n"
                                        +"</ul>\n"
                                    +"</li>\n"
                                    +"\n"
                                    +"<!-- ListeDesEmails -->\n"
                                    +"<li class=\"nav-item dropdown\">\n"
                                        +"<a class=\"nav-link dropdown-toggle\" id=\"listeDesEmails\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">Contacts</a>\n"
                                        +"<ul class=\"dropdown-menu\" aria-labelledby=\"listeDesEmails\">\n"
                                            +"<li><a class=\"dropdown-item\" href=\"contacts\">Contacts</a></li>\n"
                                            +"<li><a class=\"dropdown-item\" href=\"contacts-blacklist\">Liste noir des contacts</a></li>\n"
                                            +"<li><a class=\"dropdown-item\" href=\"contacts-new\">Nouveau contact</a></li>\n"
                                            +"<li><a class=\"dropdown-item\" href=\"contacts-import\">Importation des contacts</a></li>\n"
                                            +"<li><a class=\"dropdown-item\" href=\"contacts-export\">Exportation des contacts</a></li>\n"
                                        +"</ul>\n"
                                    +"</li>\n"
                                    +"\n"
                                    +"<!-- Administration -->\n"
                                    +"<li class=\"nav-item dropdown\">\n"
                                        +"<a class=\"nav-link dropdown-toggle\" id=\"administation\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">Administration</a>\n"
                                        +"<ul class=\"dropdown-menu\" aria-labelledby=\"administation\">\n"
                                            +"<li><a class=\"dropdown-item\" href=\"admin\">Administration</a></li>\n"
                                            +"<li><a class=\"dropdown-item\" href=\"admin-accounts\">Gestion des comptes</a></li>\n"
                                            +"<li><a class=\"dropdown-item\" href=\"admin-roles\">Gestion des rôles</a></li>\n"
                                            +"<li><a class=\"dropdown-item\" href=\"admin-server\">Serveur SMTP</a></li>\n"
                                        +"</ul>\n"
                                    +"</li>\n"
                                    +"\n"
                                    +"<li class=\"nav-item\">"
                                        +"<a class=\"nav-link \" href=\"profile\">Profil</a>"
                                    +"</li>\n"
                                    +"\n"
                                    +"<!-- Authentification -->\n"
                                    +"<li class=\"nav-item dropdown\">\n"
                                        +"<a class=\"nav-link dropdown-toggle\" id=\"administation\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">Authentification</a>\n"
                                        +"<ul class=\"dropdown-menu\" aria-labelledby=\"administation\">\n"
                                            +"<li><a class=\"dropdown-item\" href=\"auth_register\">Inscription</a></li>\n"
                                            +"<li><a class=\"dropdown-item\" href=\"auth_login\">Connexion</a></li>\n"
                                            +"<li><a class=\"dropdown-item\" href=\"auth_logout\">Déconnexion</a></li>\n"
                                        +"</ul>\n"
                                    +"</li>\n"
                                +"</ul>\n"
                            +"</div>\n"
                        +"</div>\n"
                    +"</nav>\n"
                    +"\n"
                    +"</div>\n"
                +"</div>\n"
            +"</div>";
        
        //Création du pied du contenu de la page HTML
        this.footerContent = ""
            +"<div id=\"footer\" class=\"row\">\n"
                +"<div class=\"col-md-12 col-xs-12\">\n"
                    +"<p>Seoladh © Copyright 2021\n"
                        +"<br>Créer par <a target=\"_blank\" href=\"https://ldumay.fr/\">Loïc DUMAY</a>, Timothey CAUCHOIS, Guillaume NORGOL,\n"
                        +"<br>Benjamin TESSIER, Jonathan DEGARDIN, Lihes CHERIET\n"
                    +"</p>\n"
                +"</div>\n"
            +"</div>";
        
        //Création du pied de la page HTML
        this.footBody = ""
            +"<!-- Javascript -->\n"
            +"<!-- Javascript_And_JQuery_Importations -->\n"
            +"\n"
            +"<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\n"
            +"<!-- <script src=\"js/jquery/1.11.3/jquery.min.js\"></script> -->\n"
            +"<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n"
            +"\n"
            +"<!-- BootstrapCoreJS -->\n"
            +"<!-- Latest compiled and minified JavaScript -->\n"
            +"<!--\n"
            +"<script type=\"text/javascript\" src=\"https://dev.ldumay.fr/resources/bootstrap/4.1.3/js/bootstrap.js\"></script>\n"
            +"-->\n"
            +"<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\" crossorigin=\"anonymous\"></script>\n"
            +"<!-- ./BootstrapCoreJS -->\n"
            +"\n"
            +"<!-- Javascript Custom -->\n"
            +"<script type=\"text/javascript\" src=\"js/index.js\"></script>\n"
            +"\n"
            +"<!-- ./Javascript_And_JQuery_Importations -->\n"
            +"<!-- ./Javacsript -->\n";
    }

    // The methods of basic getter below.
    public AppSession getSessionApp() { return session; }
    public User getUserConnect() { return userConnect; }
    public String getHeadBody() { return headBody; }
    public String getHeaderContent() { return headerContent; }
    public String getHeaderContentLogin() { return headercontentLogin; }
    public String getNavbarContent() { return navbarContent; }
    public String getFooterContent() { return footerContent; }
    public String getFootBody() { return footBody; }

    /**
     * toString
     * @return String
     */
    @Override
    public String toString() {
        return "Nope ! Ne peux être lu.";
    }
}
