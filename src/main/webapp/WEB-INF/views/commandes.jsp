<%-- 
    Document   : Commande
    Created on : 5 mars 2020, 16:06:45
    Author     : erouss01
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>commandes</title>
    </head>
    <body>
       <h1>Commandes pour le client ${client.societe}</h1>
       <table border='1'>
           <tr><th>Numéro</th><th>Saisie le</th><th>nb. lignes</th></tr>
  <%-- Pour chaque commande, une ligne dans la table HTML --%>
          <c:forEach var="commande" items="${client.commandeCollection}">
            <tr>
                <td>${commande.numero}</td>
                <td>${commande.saisieLe}</td>
                <td>${commande.ligneCollection.size()}</td>
            </tr>
         </c:forEach>
        </table>
    </body>
</html>
