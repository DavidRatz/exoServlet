<%@ include file="../WEB-INF/jsp/head.jsp" %>
    
    <h1>Les tags</h1>
    <h2>Les tags d'expression</h2>
    <p>Valeur de l'expression 1+1 = <%= 1+1 %></p>
    <h2>Les tags de scriplet</h2>
    <% for(int i = 0;i<5;i++){ %> <%--  in servlet class and in service --%>
           <p>salut - <%= a+i %></p>
           
    <% } %>
    <% salut(); %>
    <h2>Les tags de déclaration</h2>
    <%! // in servlet class but out of service
        int a = 5;
        Produit p = new Produit(1,"nom_prod","marque_prod",5);
        private void salut(){
            a = 10;
        }
    %>
    <h2>les tags de directives</h2>
    <h3>page</h3>
    
    <%@ page import="model.Produit" %>
    <%@ page buffer="8kb" autoFlush="true" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%-- <%@ page extends="jakarta.servlet.http.HttpServlet" %> --%>
    <%@ page errorPage="./error.jsp" %>
    
    <h3>include</h3>
    
    <h2>Les données accessible</h2>

    <%
        request
        response
        out

    %>

<%@ include file="../WEB-INF/jsp/foot.jsp" %>

