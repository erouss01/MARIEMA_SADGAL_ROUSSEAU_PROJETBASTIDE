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
            <div id="panier"> <a href=""> <img src="..\\image\\panier.png" alt="panier"/><br>Mon panier </a> </div>
        </header>
        
        <div id="favDialog">
            <a href="Profil"><div id="profil">Accéder à mon profil <img src="..\\image\\fleche.png" alt="panier"/></div></a>
            <a href=""><div id="historique">Historique des commandes <img src="..\\image\\fleche.png" alt="panier"/></div></a>
            <a href="Logout"><div id="deconnexion">Déconnexion <img src="..\\image\\croix.png" alt="panier"/></div></a>
        </div>

        <div id="voile">
                .
        </div>
        
        
        <div id="corps">
            <h1>Tous nos articles</h1>
            <div id="rayon">
                
                <%int nb=1;%>
                 <c:forEach var="produit" items="${produits}">
                    <% 
                        String debut_nom="../image/";
                        String fin_nom=".jpg ";
                        String nom=debut_nom+nb+fin_nom;
                    %>
                    <div>
                        <h3>${mvc.encoders.html(produit.nom)}</h3>
                        <br>
                        <img class="produit" alt=${produit.reference} src=<%out.print(nom); %>/><br>
                        
                        <h4>${mvc.encoders.html(produit.prixUnitaire)}€</h4>
                        <button class="addpanier" value=${produit.reference} onclick="ajouter_panier(this);"><img src="../image/caddie.jpg"/></button>
                        <div class="modifpanier" id=${produit.reference}>
                            <button onclick="add(this);" value=${produit.reference}> + </button>
                            <button id="disabled">1</button>
                            <button onclick="rem(this,${produit.reference});" value=${produit.reference}> - </button>
                            
                        </div>
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
