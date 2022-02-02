<%@ include file="../../WEB-INF/jsp/head.jsp" %>

<%@ page import="model.Magasin" %>
<%@ page import="java.util.List" %>

<h1>Ajout d'un magasin</h1>

<form action="<%= request.getContextPath()%>/magasin/add" method="post">
    <input type="number" name="id" placeholder="magasin id"><br>
    <input type="text" name ="nom" placeholder="magasin nom"><br>
    <input type="text" name ="rue" placeholder="magasin rue"><br>
    <input type="text" name ="numero" placeholder="magasin numero"><br>
    <input type="text" name ="ville" placeholder="magasin ville"><br>
    <input type="number" name ="codePostal" placeholder="magasin code postal"><br>
    <input type="number" name ="superficie" placeholder="magasin supercie"><br>
    <%-- <input type="number" name ="produitDispos" placeholder="magasin produitDispo"><br> --%>

    <button type="submit">Ajouter</button>
</form>



<%@ include file="../../WEB-INF/jsp/foot.jsp" %>