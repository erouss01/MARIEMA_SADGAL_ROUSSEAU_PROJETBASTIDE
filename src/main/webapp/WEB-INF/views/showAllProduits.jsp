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
        <h1>Liste des produits</h1>
	<table border='1'>
		<tr>
                    <th>Référence</th>
                    <th>Nom</th>
                    <th>Catégorie</th>
                    <th>Prix unitaire</th>
                </tr>
		<%-- Pour chaque catégorie, une ligne dans la table HTML --%>
		<c:forEach var="produit" items="${produits}">
			<tr>
				<td>${produit.reference}</td>
				<%-- Le libellé ou la description peuvent contenir des caractères spéciaux HTML ! --%>
				<td>${mvc.encoders.html(produit.nom)}</td>
				<td>${mvc.encoders.html(produit.categorie)}</td>
				<td>${mvc.encoders.html(produit.prixUnitaire)}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}">Retour au menu</a>
    </body>
</html>
