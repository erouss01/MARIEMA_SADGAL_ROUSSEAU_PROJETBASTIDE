<%-- 
    Document   : Commande
    Created on : 5 mars 2020, 16:06:45
    Author     : erouss01
--%>
<%--  <h1>Commandes pour le client ${client.societe}</h1>
       <table border='1'>
           <tr><th>Numéro</th><th>Saisie le</th><th>nb. lignes</th></tr>
  Pour chaque commande, une ligne dans la table HTML 
          <c:forEach var="commande" items="${client.commandeCollection}">
            <tr>
                <td>${commande.numero}</td>
                <td>${commande.saisieLe}</td>
                <td>${commande.ligneCollection.size()}</td>
            </tr>
         </c:forEach>
        </table>--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>ESSA</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="..\css\commande.css" rel="stylesheet"/>
    </head>
    <body>
        
        <header onload="afficher();"> 
            <div id="logo"> <a href="categories"> <img src="..\\image\\logo1.png" alt="Accueil"/> </a> </div>
            <div id="articles" ><a href=produits> <img src="..\\image\\plus.png" alt="articles"/> <br>Tous les articles </a></div>
            <div id="compte" onclick="afficher();"> <img src="..\\image\\profil.png" alt="Compte"/><br>
                    Mon ESSA 
            </div> 
            <div id="panier"> <a href="Panier"> <img src="..\\image\\panier.png" alt="panier"/><br>Mon panier </a> </div>
        </header>
        
        <div id="favDialog">
            <a href="Profil"><div id="profil">Accéder à mon profil <img src="..\\image\\fleche.png" alt="Profil"/></div></a>
            <a href="Historique"><div id="historique">Historique des commandes <img src="..\\image\\fleche.png" alt="Historique"/></div></a>
            <a href="Logout"><div id="deconnexion">Déconnexion <img src="..\\image\\croix.png" alt="Deconnexion"/></div></a>
        </div>

        <div id="voile">
                .
        </div>
        <div id="corps">
            <c:if test="${not empty ligne}">
                <a href="Historique"><img id="imgretour" alt=retour src=../image/retourcommande.png /></a> &nbsp; 
            <h1>Commande n°${commande.numero}</h1><br>
                <div id="divadresse">
                    <h2>Adresse de livraison </h2><br>
                    ${commande.destinataire}<br><br>
                    ${commande.adresseLivraison} <br>
                    ${commande.regionLivraison}
                    ${commande.villeLivraison}&nbsp;-&nbsp;${commande.codePostalLivrais}&nbsp;${commande.paysLivraison}
                    
                </div>
                <div id="commande">
	
                    <c:forEach var="produit" items="${produit}">
                        <c:forEach var="ligne" items="${ligne}">
                            <c:if test="${produit.reference==ligne.lignePK.produit}">
                        <div class="blockcommande">
                           
                           <div class="divimg">
                               <img class="imgproduit" alt=${produit.reference} src=../image/${produit.reference}.jpg />
                           </div>
                           <div class="divproduit">
                               <br><br><br>
                               <h3>${produit.nom}</h3>
                               X ${ligne.quantite}
                           </div>
                           <div class="divprix">
                               <h4>Prix à l'unité :</h4>
                               <text class="prix">${produit.prixUnitaire}&nbsp;€</text><br>
                           </div>

                       </div>
                            </c:if >
                        </c:forEach>
                   </c:forEach> 
                </div>
            </c:if> 
                
        </div>
        
        <script src="../js/accueil.js" type="text/javascript"></script>
    </body>
</html>
