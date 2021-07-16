<%-- 
    Document   : campaigns.jsp
    Created on : 24 juin 2021, 10:59:05
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

                    <div id="content" class="row">
                        <div class="col-md-12 col-xs-12">
                            
                            <!-- Page - Breadcrumb -->
                            <div class="row col-md-12 col-xs-12">
                                <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="index.jsp">Accueil</a></li>
                                        <li class="breadcrumb-item active">Campagnes</li>
                                    </ol>
                                </nav>
                            </div>
                            <br><br>
                            
                            <!-- Page - Title -->
                            <div class="row col-md-12 col-xs-12 text-center"><h3>Campagnes</h3></div>
                            <hr>
                            
                            <!-- Page - Content -->
                            <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
                                
                                <!-- Item -->
                                <div class="col">
                                    <div class="card shadow-sm">
                                        <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"></rect><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>

                                        <div class="card-body">
                                            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                                            <div class="d-flex justify-content-between align-items-center">
                                                <div class="btn-group">
                                                    <button type="button" class="btn btn-sm btn-outline-success">View</button>
                                                    <button type="button" class="btn btn-sm btn-outline-primary">Edit</button>
                                                    <button type="button" class="btn btn-sm btn-outline-danger">Delete</button>
                                                </div>
                                                <small class="text-muted">9 mins</small>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                
                                <!-- Item -->
                                <div class="col">
                                    <div class="card shadow-sm">
                                        <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"></rect><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>

                                        <div class="card-body">
                                            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                                            <div class="d-flex justify-content-between align-items-center">
                                                <div class="btn-group">
                                                    <button type="button" class="btn btn-sm btn-outline-success">View</button>
                                                    <button type="button" class="btn btn-sm btn-outline-primary">Edit</button>
                                                    <button type="button" class="btn btn-sm btn-outline-danger">Delete</button>
                                                </div>
                                                <small class="text-muted">9 mins</small>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                
                                <!-- Item -->
                                <div class="col">
                                    <div class="card shadow-sm">
                                        <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"></rect><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>

                                        <div class="card-body">
                                            <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                                            <div class="d-flex justify-content-between align-items-center">
                                                <div class="btn-group">
                                                    <button type="button" class="btn btn-sm btn-outline-success">View</button>
                                                    <button type="button" class="btn btn-sm btn-outline-primary">Edit</button>
                                                    <button type="button" class="btn btn-sm btn-outline-danger">Delete</button>
                                                </div>
                                                <small class="text-muted">9 mins</small>
                                            </div>
                                        </div>
                                    </div>
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