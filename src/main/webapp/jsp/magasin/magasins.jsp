<%@ include file="../../WEB-INF/jsp/head.jsp" %>

<%@ page import="model.Magasin" %>
<%@ page import="java.util.List" %>

<h1>Liste des magasins</h1>

<a href="<%= request.getContextPath()%>/magasin/add">Ajouter un magasin</a>

<% List<Magasin> list = (List<Magasin>) request.getAttribute("listMagasin"); 
    for(Magasin m: list){
%>
 
  <p><%= m.getNom() %></p> 

  <a href="<%= request.getContextPath() %>/produitmagasin/add?nom=<%= m.getNom() %>">Ajouter un produit</a>

<%}%>

<a href="<%= request.getContextPath()%>">Retour</a>

<%@ include file="../../WEB-INF/jsp/foot.jsp" %>