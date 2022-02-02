<%@ include file="../../WEB-INF/jsp/head.jsp" %>

<h1>Ajout d'un produit</h1>

<form action="<%= request.getContextPath()%>/produit/add" method="post">
    <input type="number" name="id" placeholder="id"><br>
    <input type="text" name ="nom" placeholder="nom"><br>
    <input type="text" name ="marque" placeholder="marque"><br>
    <input type="text" name ="prix" placeholder="prix"><br>

    <button type="submit">Ajouter</button>
</form>



<%@ include file="../../WEB-INF/jsp/foot.jsp" %>