<%-- 
    Document   : admin_role.jsp
    Created on : 23 juin 2021, 18:03:00
    Author     : ldumay,tcauchois
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
                                <li class="breadcrumb-item"><a href="admin.jsp">Administration</a></li>
                                <li class="breadcrumb-item active">Gestion des rôles</li>
                            </ol>
                        </nav>
                    </div>
                    <br><br>

                    <!-- Page - Title -->
                    <div class="row col-md-12 col-xs-12 text-center"><h3>Gestion des rôles</h3></div>
                    <hr>

                    <!-- Page - Content -->
                    <div class="row col-md-12 col-xs-12 text-center">

                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">First</th>
                                    <th scope="col">Last</th>
                                    <th scope="col">Handle</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th scope="row">1</th>
                                    <td>Mark</td>
                                    <td>Otto</td>
                                    <td>@mdo</td>
                                </tr>
                                <tr>
                                    <th scope="row">2</th>
                                    <td>Jacob</td>
                                    <td>Thornton</td>
                                    <td>@fat</td>
                                </tr>
                                <tr>
                                    <th scope="row">3</th>
                                    <td>Larry</td>
                                    <td>the Bird</td>
                                    <td>@twitter</td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="col text-center">
                            <button type="button" class="btn btn-secondary">Sauvegarder</button>
                        </div>
                    </div>
                    
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