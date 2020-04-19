<%-- 
    Document   : Historique
    Created on : 18 avr. 2020, 12:04:33
    Author     : Kency
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>ESSA</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="..\css\historique.css" rel="stylesheet"/>
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
        <form id="voirCommande" method="post">
            <input id="numeroCommande" name=numero type="text"/>
        </form>
        <div id="corps">
            <h1>Mes commandes</h1>
            <c:if test="${not empty historique}">
                <div id="commande">
                <c:forEach var="commande" items="${historique}">
                    <div class="blockcommande">
                        <h2> Commande n°${commande[0]} </h2><br>
                        <div class="divdetail">
                            <h3>Expédiée le :</h3>
                            <text class="date">${commande[1]}</text><br>
                            <h3>Destinataire :</h3>
                            ${commande[3]}
                        </div>
                        <div class="divadresse"><br>
                            <h3>Adresse de livraison : </h3><br>
                            ${commande[4]} <br>
                            ${commande[6]}
                            ${commande[5]}&nbsp;-&nbsp;${commande[7]}&nbsp;${commande[8]}
                        </div>
                        <div class="divprix">
                            <text class="prix">${commande[2]}&nbsp;€</text><br>
                            <button class="details" onclick="voir(${commande[0]});">Voir</button>
                        </div>
                    </div>
                    
                </c:forEach>
                </div>
            </c:if> 
            <c:if test="${empty historique}">
                <img id="commandevide" src="../image/commandevide.PNG" alt="aucune commande"/>
            </c:if> 
                
        </div>
        
        <script src="../js/accueil.js" type="text/javascript"></script>
    </body>
</html>
