<%-- 
    Document   : Panier
    Created on : 22 mars 2020, 12:25:42
    Author     : Kency
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>ESSA</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="..\css\Panier.css" rel="stylesheet"/>
    </head>
    <body>
        <header> 
            <div id="retour"><a href="produits"><img src="..\\image\\retour2.png" alt=retour"/></a></div>
            <div id="logo"> <a href="categories"> <img src="..\\image\\logo2.png" alt="logo"/> </a> </div>
         </header>
        <c:if test="${not empty test}">
            ${test}
        </c:if>
       <div id="corps">
           <form id="modifPanier" method="post">
                <input id="articlepanier" name=prdt type="text"/>
            </form>
            <c:if test="${not empty panier}">
                <h1>Votre panier</h1>
                <div id="liste">
                <c:forEach var="article" items="${panier}">
                    <div class="blockarticle">
                        <div class="divimg">
                        <img class="imgproduit" alt=${article[1]} src=../image/${article[1]}.jpg />
                        </div>
                        <div class="divproduit">
                            <h3>${article[2]}  </h3>
                            ${article[3]} 
                        </div>
                        <div class="divqte" id=${article[0]}>
                            <img class="imgpoubelle" onclick="doPostdel(this);" alt=imgsupp src=../image/poubelle.png /><br>
                            <div class="divprix">
                                <text class="prix">${article[5]}&nbsp;€</text>
                                <div class="divblocknb">
                                    <button class="moins" onclick="doPostmoins(this,${article[4]},${article[6]})">
                                        -
                                    </button>
                                    <div class="divnb">
                                        ${article[4]}
                                    </div>
                                    <button class="plus" onclick="doPostplus(this,${article[4]},${article[6]})">
                                        +
                                    </button>
                                </div>
                            </div>
                        </div>

                    </div>

                </c:forEach>
                </div>
                <div id="recap">
                    <div>
                    Détail commande<br>
                    <p>Sous-total <text>${total[0]}€</text></p>
                    Total <text>${total[0]}€<text>
                    </div>
                    <div id="valider">
                        <button onclick="doPostcom();">Commander</button>
                        <button onclick="doPostvider();">Vider le panier</button>
                    </div>
                </div>
            </c:if>
                <c:if test="${empty panier}">
                    <style>
                        #corps{
                            background:#f7f7f7;
                        }
                    </style>
                    <img id="paniervide" src="../image/paniervide.PNG" alt="logo"/>
                </c:if>
                
                
            
        </div>
        <script src="../js/panier.js" type="text/javascript"></script>
    </body>
</html>
