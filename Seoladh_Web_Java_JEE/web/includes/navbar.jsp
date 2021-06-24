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
                                    <li><a class="dropdown-item" href="campaigns.jsp">[OK] Liste des campagnes</a></li>
                                    <li><a class="dropdown-item" href="campaigns_new.jsp">[404] Nouvel campagne</a></li>
                                    <li><a class="dropdown-item" href="campaigns_import.jsp">[404] Importation des campagnes</a></li>
                                    <li><a class="dropdown-item" href="campaigns_export.jsp">[404] Exportation des campagnes</a></li>
                                </ul>
                            </li>

                            <!-- ListeDeContacts -->
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" id="listesDeContacts" data-bs-toggle="dropdown" aria-expanded="false">Listes de contacts</a>
                                <ul class="dropdown-menu" aria-labelledby="listesDeContacts">
                                    <li><a class="dropdown-item" href="#">[404] Tous les contacts</a></li>
                                    <li><a class="dropdown-item" href="#">Nouvel liste de contacts</a></li>
                                    <li><a class="dropdown-item" href="#">Importation des listes</a></li>
                                    <li><a class="dropdown-item" href="#">Exportation des listes</a></li>
                                </ul>
                            </li>

                            <!-- ListeDesEmails -->
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" id="listeDesEmails" data-bs-toggle="dropdown" aria-expanded="false">Liste Des Emails</a>
                                <ul class="dropdown-menu" aria-labelledby="listeDesEmails">
                                    <li><a class="dropdown-item" href="#">Tous les emails</a></li>
                                    <li><a class="dropdown-item" href="#">Blacklists</a></li>
                                    <li><a class="dropdown-item" href="#">Nouvel email</a></li>
                                    <li><a class="dropdown-item" href="#">Nettoyage & tri des emails</a></li>
                                    <li><a class="dropdown-item" href="#">Importation des emails</a></li>
                                    <li><a class="dropdown-item" href="#">Exportation des emails</a></li>
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
                                    <li><a class="dropdown-item" href="configs.jsp">[404] Paramètres</a></li>
                                    <li><a class="dropdown-item" href="configs_server_smtp.jsp">[404] Serveur SMTP Défaut</a></li>
                                </ul>
                            </li>

                            <!-- Inscription/Connexion -->
                            <li class="nav-item"> <a class="nav-link" href="register.jsp">[Ok] Inscription</a> </li>
                            <li class="nav-item"> <a class="nav-link" href="login.jsp">[Ok] Connexion</a> </li>
                            
                            <!-- Deconnexion -->
                            <li class="nav-item"> <a class="nav-link" href="logout.jsp">[404] Déconnexion</a> </li>
                        </ul>
                    </div>
                </div>
            </nav>

        </div>
    </div>
</div>