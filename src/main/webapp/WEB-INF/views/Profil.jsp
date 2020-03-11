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
        <div id="logo"> <a href="../index.html"> <img src="..\\image\\logo1.png" alt="logo"/> </a> </div>
        <div id="articles" ><a href=#> <img src="..\\image\\plus.png" alt="articles"/> <br>Tous les articles </a></div>
        <div id="compte" onclick="afficher();"> <img src="..\\image\\profil.png" alt="profil"/><br>
                Mon ESSA 
        </div> 
        <div id="panier"> <a href=""> <img src="..\\image\\panier.png" alt="panier"/><br>Mon panier </a> </div>

        </header>
        
        <div id="favDialog">
            <a href="Profil"><div id="admin">Accéder à mon profil </div></a>
            <a href="..\index.html"><div id="client">Déconnexion</div></a>
        </div>

        <div id="voile">
                .
        </div>
        
        <div id="corps">
            <h1>Profil</h1>
            <div id="profil">
                <form>

                    <p id="un">
                        Nom: <input type="text" name="Contact"><br>
                        Fonction: <input type="text" name="Fonction"><br>
                        Société: <input type="text" name="Societe"><br>
                        Adresse: <input type="text" name="Adresse"><br>
                        Code Postal: <input type="text" name="Code_Postal"><br>
                    </p>
                    <p id="deux">
                        Ville: <input type="text" name="Ville"><br>
                        Région: <input type="text" name="Region"><br>
                        Pays: <input type="text" name="Pays"><br>
                        Téléphone: <input type="text" name="Telephone"><br>
                        Fax: <input type="text" name="Fax"><br>
                    </p>
                    <br>
                    <input type="submit" value="Valider">
                </form>
            </div>
            <a href="Password">
                <div id="motdepasse">
                    CHANGER MOT DE PASSE
                </div>
            </a>
        </div>
        
        <script src="../js/accueil.js" type="text/javascript"></script>
    </body>
</html>