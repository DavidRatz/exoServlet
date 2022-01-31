<%@ include file="../../WEB-INF/jsp/head.jsp" %>

<form action="<%= request.getContextPath()%>/addition/solve" method="get">
    <input type="number" name="m1" placeholder="membre 1">
    <input type="number" name="m2" placeholder="membre 2">
    <select name="save-in">
        <option value="session">session</option>
        <option value="request">request</option>
    </select>

    <button type="submit">additionner</button>
</form>

<%@ include file="../../WEB-INF/jsp/foot.jsp" %>
