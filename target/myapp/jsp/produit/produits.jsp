<%@ include file="../../WEB-INF/jsp/head.jsp" %>

<%@ page import="model.Produit" %>
<%@ page import="java.util.List" %>

<a href="<%= request.getContextPath()%>/produit/add">Ajouter un produit</a>

<% List<Produit> list = (List<Produit>) request.getAttribute("listeProduit"); 
    for(Produit p: list){
%>
 
  <p><%= p.getNom() %></p> 

<%}%>

<a href="<%= request.getContextPath()%>">Retour</a>

<%@ include file="../../WEB-INF/jsp/foot.jsp" %>