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
                            <li class="nav-item"> <a class="nav-link active" href="accueil.jsp">Accueil</a> </li>

                            <!-- Campagnes -->
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" id="campagnes" data-bs-toggle="dropdown" aria-expanded="false">Campagnes</a>
                                <ul class="dropdown-menu" aria-labelledby="campagnes">
                                    <li><a class="dropdown-item" href="campaigns.jsp">Liste des campagnes</a></li>
                                    <li><a class="dropdown-item" href="#">Importation des campagnes</a></li>
                                    <li><a class="dropdown-item" href="#">Exportation des campagnes</a></li>
                                </ul>
                            </li>

                            <!-- ListeDeContacts -->
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" id="listesDeContacts" data-bs-toggle="dropdown" aria-expanded="false">Listes de contacts</a>
                                <ul class="dropdown-menu" aria-labelledby="listesDeContacts">
                                    <li><a class="dropdown-item" href="#">Tous les contacts</a></li>
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
                                    <li><a class="dropdown-item" href="#">Gestion des comptes</a></li>
                                    <li><a class="dropdown-item" href="#">Gestion des rôles</a></li>
                                </ul>
                            </li>

                            <!-- Paramètres -->
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" id="paramteres" data-bs-toggle="dropdown" aria-expanded="false">Paramètres</a>
                                <ul class="dropdown-menu" aria-labelledby="paramteres">
                                    <li><a class="dropdown-item" href="#">Serveur SMTP Défaut</a></li>
                                </ul>
                            </li>

                            <!-- Déconnexion -->
                            <li class="nav-item"> <a class="nav-link" href="login.jsp">Déconnexion</a> </li>
                        </ul>
                    </div>
                </div>
            </nav>

        </div>
    </div>
</div>