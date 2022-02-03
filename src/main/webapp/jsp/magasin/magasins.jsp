<%@ include file="../../WEB-INF/jsp/head.jsp" %>

<%@ page import="model.Magasin" %>
<%@ page import="java.util.List" %>

<h1>Liste des magasins</h1>

<a href="<%= request.getContextPath()%>/magasin/add">Ajouter un magasin</a>

<table>
<thead>
  <tr>
    <td>Id</td>
    <td>Nom</td>
    <td>Rue</td>
    <td>Ville</td> 
    <td>CodePostal</td>
    <td>Numero</td>
    <td>Superficie</td>
    <td>Produit Disponibles</td>
  </tr>
</thead>
<tbody>
<% List<Magasin> list = (List<Magasin>) request.getAttribute("listMagasin"); 
    for(Magasin m: list){
%>
 <tr>
  <td><%= m.getId() %></td>
  <td><%= m.getNom() %></td> 
  <td><%= m.getRue() %></td> 
  <td><%= m.getVille() %></td> 
  <td><%= m.getCodePostal() %></td>
  <td><%= m.getNumero() %></td>
  <td><%= m.getSuperficie() %></td>
  <td><%= m.getProduitDisponibles() %></td>
  <td><a href="<%= request.getContextPath() %>/produitmagasin/add?nom=<%= m.getNom() %>">Ajouter un produit</a></td>
  <td><a href="<%= request.getContextPath() %>/produitmagasin/delete?nom=<%= m.getNom() %>">Supprimer un produit</a></td>
</tr>
<%}%>
</tbody>
</table>
<a href="<%= request.getContextPath()%>">Retour</a>

<%@ include file="../../WEB-INF/jsp/foot.jsp" %>