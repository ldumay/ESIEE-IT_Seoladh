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
                                        <li class="breadcrumb-item active">Listes de contact</li>
                                    </ol>
                                </nav>
                            </div>
                            <br><br>
                            
                            <!-- Page - Title -->
                            <div class="row col-md-12 col-xs-12 text-center"><h3>Listes de contact</h3></div>
                            <hr>
                            
                            <!-- Page - Content -->
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
                                        <td colspan="2">Larry the Bird</td>
                                        <td>@twitter</td>
                                    </tr>
                                </tbody>
                            </table>
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