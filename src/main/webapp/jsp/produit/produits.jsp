<%@ include file="../../WEB-INF/jsp/head.jsp" %>

<%@ page import="model.Produit" %>
<%@ page import="java.util.List" %>

<h1>Liste des produits</h1>

<a href="<%= request.getContextPath()%>/produit/add">Ajouter un produit</a>

<table>
<thead>
  <tr>
    <td>Id</td>
    <td>Nom</td>
    <td>Marque</td>
    <td>Prix</td> 
  </tr>
</thead>
<tbody>
<% List<Produit> list = (List<Produit>) request.getAttribute("listeProduit"); 
    for(Produit p: list){
%>
 <tr>
  <td><%= p.getId() %></td> 
  <td><%= p.getNom() %></td> 
  <td><%= p.getMarque() %></td> 
  <td><%= p.getPrix() %></td> 

</tr>
<%}%>
</tbody>
</table>

<a href="<%= request.getContextPath()%>">Retour</a>

<%@ include file="../../WEB-INF/jsp/foot.jsp" %>