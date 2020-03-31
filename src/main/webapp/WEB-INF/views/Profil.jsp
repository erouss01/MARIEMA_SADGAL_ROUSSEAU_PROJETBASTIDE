<%-- 
    Document   : Profil
    Created on : 5 mars 2020, 16:03:18
    Author     : erouss01
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>ESSA</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="..\css\profil.css" rel="stylesheet"/>
    </head>
    <body> 
        
        <header onload="afficher();"> 
        <div id="logo"> <a href="categories"> <img src="..\\image\\logo1.png" alt="logo"/> </a> </div>
        <div id="articles" ><a href="produits"> <img src="..\\image\\plus.png" alt="articles"/> <br>Tous les articles </a></div>
        <div id="compte" onclick="afficher();"> <img src="..\\image\\profil.png" alt="profil"/><br>
                Mon ESSA 
        </div> 
        <div id="panier"> <a href=""> <img src="..\\image\\panier.png" alt="panier"/><br>Mon panier </a> </div>

        </header>
        
        <div id="favDialog">
            <a href=#><div id="profil">Accéder à mon profil <img src="..\\image\\fleche.png" alt="panier"/></div></a>
            <a href=""><div id="historique">Historique des commandes <img src="..\\image\\fleche.png" alt="panier"/></div></a>
            <a href="Logout"><div id="deconnexion">Déconnexion <img src="..\\image\\croix.png" alt="panier"/></div></a>
        </div>

        <div id="voile">
                .
        </div>
        <text class="info">${codeclient.contact}</text>
        <text class="info">${codeclient.fonction}</text>
        <text class="info">${codeclient.societe}</text>
        <text class="info">${codeclient.telephone}</text>
        <text class="info">${codeclient.fax}</text>
        <text class="info">${codeclient.adresse}</text>
        <text class="info">${codeclient.codePostal}</text>
        <text class="info">${codeclient.ville}</text>
        <text class="info">${codeclient.region}</text>
        <text class="info">${codeclient.pays}</text>
        
        <div id="corps">
            <h1>Mes coordonnées</h1>
            
            <form method="post">
                <p>
                    <label>Nom</label> <br> <input type="text" name="Contact"><br>
                    <label>Fonction</label> <br> <input type="text" name="Fonction"><br>
                    <label>Société</label> <br> <input type="text" name="Societe"><br>
                    <label>Téléphone</label> <br><input type="text" name="Telephone"><br>
                    <label>Fax</label> <br> <input type="text" name="Fax"><br>
                </p>
                <br>
                <input type="submit" value="VALIDER">
           

            <h1 id="titredeux">Mon adresse</h1>
	
                <p>
                    <label>Adresse</label> <br> <input type="text" name="Adresse"><br>
                    <label>Code Postal</label> <br> <input type="text" name="Code_Postal"><br>
                    <label>Ville</label> <br> <input type="text"<jsp:useBean id="b1" scope="page" class="controller.ProfilController" /> name="Ville"><br>
                    <label>Région</label> <br> <input type="text" name="Region"><br>
                    <label>Pays</label> <br> <input type="text" name="Pays"><br>
                </p>
                <br>
                <input type="submit" value="VALIDER">
            </form>
            
            <a href="Password">
                <div id="motdepasse">
                    <img src="..\\image\\modifier.png" alt="panier"/>
                </div>
            </a>
        </div>
        
        <script src="../js/Profil.js" type="text/javascript"></script>
    </body>
</html>