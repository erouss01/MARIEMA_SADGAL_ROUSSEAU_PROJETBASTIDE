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
        <title>ESSA</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="..\css\produit.css" rel="stylesheet"/>
    </head>
    <body>
        <header onload="afficher();"> 
            <div id="logo"> <a href="categories"> <img src="..\\image\\logo1.png" alt="logo"/> </a> </div>
            <div id="articles" ><a href=#> <img src="..\\image\\plus.png" alt="articles"/> <br>Tous les articles </a></div>
            <div id="compte" onclick="afficher();"> <img src="..\\image\\profil.png" alt="profil"/><br>
                    Mon ESSA 
            </div> 
                    
            <c:choose>
                <c:when test="${empty inpanier}">
                    <div id="panier"> <a href="Panier"> <img src="..\\image\\panier.png" alt="panier"/><br>Mon panier </a> </div>
                </c:when>    
                <c:otherwise>
                    <div id="panier"> <a href="Panier"> <img src="..\\image\\panier2.png" alt="panier"/><br>Mon panier </a> </div>  
                </c:otherwise>
            </c:choose>
        </header>
        
        <div id="favDialog">
            <a href="Profil"><div id="profil">Accéder à mon profil <img src="..\\image\\fleche.png" alt="panier"/></div></a>
            <a href="Historique"><div id="historique">Historique des commandes <img src="..\\image\\fleche.png" alt="panier"/></div></a>
            <a href="Login"><div id="deconnexion">Déconnexion <img src="..\\image\\croix.png" alt="panier"/></div></a>
        </div>

        <div id="voile">
                .
        </div>
        
        <div id="corps">
            <h1>Tous nos articles</h1>
            <c:if test="${not empty databaseErrorMessage}">
			<span style="color: red;">${databaseErrorMessage}</span>
            </c:if>
            <div id="rayon">
                <form id="ajoutPanier" method="post" >
                    <input id="articlepanier" name=article type="text"/>
                </form>
                <%
                  int nb=1;
                  int in=0;
                %>
                
                 <c:forEach var="produit" items="${produits}">
                    <% in=0; %>
                   
                    <div>
                        <h3 id=h${produit.reference}>${mvc.encoders.html(produit.nom)}</h3>
                        <br>
                        <img class="produit" alt=${produit.reference} src=../image/${produit.reference}.jpg /><br>
                        
                        <h4 id=h${produit.reference}>${mvc.encoders.html(produit.prixUnitaire)}€</h4>
                        <c:if test="${not empty inpanier}">
                            <c:forEach var="prod" items="${inpanier}">
                                <c:if test="${produit.nom==prod}">
                                    <% in=1; %>
                                </c:if>
                            </c:forEach>
                        </c:if>
                        
                        <%
                          if(in==0){  
                        %>
                        <button id=btn${produit.reference} class="addpanier" value=${produit.reference} onclick="ajouter_panier(this);"><img src="../image/caddie.jpg"/></button>
                        <%
                            }else{  
                        %>
                        <button id=btn${produit.reference} class="addpanier" value=${produit.reference} onclick="ajouter_panier(this); " disabled="true"><img src="../image/caddieok.jpg" title="Pour supprimer cette article rendez-vous dans votre panier!"/></button>
                        <%
                            }  
                        %>
                    </div>

                    <%
                        if(nb%4==0){
                    %>
                    <br>                
                    <% }
                        nb=nb+1;
                    %>
                </c:forEach>
            </div>
        </div>
        
        <script src="../js/accueil.js" type="text/javascript"></script>
    </body>
</html>
