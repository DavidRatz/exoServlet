<%@ include file="../../WEB-INF/jsp/head.jsp" %>

<%@ page import="model.Produit" %>
<%@ page import="java.util.List" %>

<h1>Ajouter un produit à un magasin</h1>

<p><%= request.getAttribute("nomMagasin") %></p>

<form action="<%= request.getContextPath()%>/produitmagasin/add" method="post">

    <select name="id" id="">

    <% List<Produit> list = (List<Produit>) request.getAttribute("listProduit"); 
        for(Produit p: list){
    %>
        <option value="<%= p.getId() %>"><%= p.getNom() %></option>
    <%}%>
    </select>
    <input type="hidden" name ="nomMagasin" value="<%= request.getAttribute("nomMagasin") %>"><br>
    <button type="submit">Ajouter</button>
</form>

<a href="<%= request.getContextPath()%>">Retour</a>

<%@ include file="../../WEB-INF/jsp/foot.jsp" %>