<%@ include file="../../WEB-INF/jsp/head.jsp" %>
    <p>resultat dans la session: <%= session.getAttribute("rslt") %></p>
    <p>resultat dans la requete: <%= request.getAttribute("rslt") %></p>
    
<%@ include file="../../WEB-INF/jsp/foot.jsp" %>
