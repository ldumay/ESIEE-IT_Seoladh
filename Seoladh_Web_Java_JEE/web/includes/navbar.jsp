<%-- 
    Document   : navbar.jsp
    Created on : 23 juin 2021, 18:03:00
    Author     : ldumay
--%>

<div id="nav-bar">
    <div class="row">
        <div class="col-md-12 col-xs-12">

            <nav class="navbar navbar-expand-lg navbar-light bg-light rounded" aria-label="Twelfth navbar example">
                <div class="container-fluid">
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample10" aria-controls="navbarsExample10" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse justify-content-md-center" id="navbarsExample10">
                        <ul class="navbar-nav">
                            <!-- Accueil -->
                            <li class="nav-item"> <a class="nav-link active" href="home.jsp">Accueil</a> </li>

                            <!-- Campagnes -->
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" id="campagnes" data-bs-toggle="dropdown" aria-expanded="false">Campagnes</a>
                                <ul class="dropdown-menu" aria-labelledby="campagnes">
                                    <li><a class="dropdown-item" href="campaigns.jsp">Liste des campagnes</a></li>
                                    <li><a class="dropdown-item" href="campaigns_new.jsp">Nouvel campagne</a></li>
                                    <li><a class="dropdown-item" href="campaigns_import.jsp">Importation des campagnes</a></li>
                                    <li><a class="dropdown-item" href="campaigns_export.jsp">Exportation des campagnes</a></li>
                                </ul>
                            </li>

                            <!-- ListeDeContacts -->
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" id="listesDeContacts" data-bs-toggle="dropdown" aria-expanded="false">Listes de contacts</a>
                                <ul class="dropdown-menu" aria-labelledby="listesDeContacts">
                                    <li><a class="dropdown-item" href="contactslists.jsp">Listes de contacts</a></li>
                                    <li><a class="dropdown-item" href="contactslists_blacklist.jsp">Liste noir des listes de contacts</a></li>
                                    <li><a class="dropdown-item" href="contactslists_new.jsp">Nouvelle liste de contacts</a></li>
                                    <li><a class="dropdown-item" href="contactslists_clean_doublons.jsp">Nettoyage des doublons et erreurs d'emails</a></li>
                                    <li><a class="dropdown-item" href="contactslists_import.jsp">Importation de listes de contacts</a></li>
                                    <li><a class="dropdown-item" href="contactslists_export.jsp">Exportation de listes de contacts</a></li>
                                </ul>
                            </li>

                            <!-- ListeDesEmails -->
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" id="listeDesEmails" data-bs-toggle="dropdown" aria-expanded="false">Contacts</a>
                                <ul class="dropdown-menu" aria-labelledby="listeDesEmails">
                                    <li><a class="dropdown-item" href="contacts.jsp">Contacts</a></li>
                                    <li><a class="dropdown-item" href="contacts_new.jsp">Nouveau contact</a></li>
                                    <li><a class="dropdown-item" href="contacts_import.jsp">Importation des contacts</a></li>
                                    <li><a class="dropdown-item" href="contacts_export.jsp">Exportation des contacts</a></li>
                                </ul>
                            </li>

                            <!-- Administration -->
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" id="administation" data-bs-toggle="dropdown" aria-expanded="false">Administration</a>
                                <ul class="dropdown-menu" aria-labelledby="administation">
                                    <li><a class="dropdown-item" href="admins.jsp">[404] Administration</a></li>
                                    <li><a class="dropdown-item" href="admin_mamagement_accounts.jsp">[404] Gestion des comptes</a></li>
                                    <li><a class="dropdown-item" href="admin_mamagement_roles.jsp">[404] Gestion des rôles</a></li>
                                </ul>
                            </li>

                            <!-- Paramètres -->
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" id="paramteres" data-bs-toggle="dropdown" aria-expanded="false">Paramètres</a>
                                <ul class="dropdown-menu" aria-labelledby="paramteres">
                                    <li><a class="dropdown-item" href="configs.jsp">Paramètres</a></li>
                                    <li><a class="dropdown-item" href="configs_server_smtp.jsp">Serveur SMTP Défaut</a></li>
                                </ul>
                            </li>
                            
                            <!-- Authentification -->
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" id="administation" data-bs-toggle="dropdown" aria-expanded="false">Authentification</a>
                                <ul class="dropdown-menu" aria-labelledby="administation">
                                    <li><a class="dropdown-item" href="auth_register.jsp">Inscription</a></li>
                                    <li><a class="dropdown-item" href="auth_login.jsp">Connexion</a></li>
                                    <li><a class="dropdown-item" href="auth_logout.jsp">Déconnexion</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>

        </div>
    </div>
</div>