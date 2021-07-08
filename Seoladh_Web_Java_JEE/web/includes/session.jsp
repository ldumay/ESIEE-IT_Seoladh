<%-- 
    Document   : session
    Created on : 7 juil. 2021, 17:30:21
    Author     : ldumay
--%>

<% System.out.println("Session - Loading !"); %>

<%@page import="java.sql.SQLException"%>
<%@page import="java.lang.InstantiationException"%>

<%@page import="fr.esiee_it.projet.main.AppSession"%>
<%@page import="fr.esiee_it.projet.mvc_models.User"%>


<%-- Permet l'appel ou l'instanciation d'une donnée complexe dans un bean --%>
<jsp:useBean id="appSession" scope="application" class="AppSession" />
<%-- Paramettrage du bean de la JSP --%>
<jsp:setProperty name="appSession" property="*" />

<% appSession.clientDemo(); %>
<% System.out.println(appSession.userConnect.getContactInfos().getNom()); %>
<% User userConnect = appSession.getUserConnect(); %>

<%!
    /*
    AppSession session = new AppSession(null, null);
    User userConnect = AppSession.getUserConnect();
    */
%>

<% System.out.println("Session - Loaded !"); %>