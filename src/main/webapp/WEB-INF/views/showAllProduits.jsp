<%-- 
    Document   : showAllProduits
    Created on : 5 mars 2020, 16:06:06
    Author     : erouss01
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Affiche tous les produits</title>
    </head>
    <body>
        <h1>Tous nos articles</h1>
        <%int nb=1;%>
         <c:forEach var="produit" items="${produits}">
       <% 
                    String debut_nom="../image/";
                    String fin_nom=".jpg ";
                    String nom=debut_nom+nb+fin_nom;
                %>
                 <img alt=${produit.reference} src=<%out.print(nom); %>/><br>
                    ${mvc.encoders.html(produit.nom)}<br>
                
                <%
                    if(nb==4){
                %>
                <br>                
                <% }
                    nb=nb+1;
                %>
        </c:forEach>
	<a href="${pageContext.request.contextPath}">Retour au menu</a>
    </body>
</html>
