<%-- 
    Document   : Profil
    Created on : 5 mars 2020, 16:03:18
    Author     : erouss01
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profil</title>
    </head>
    <body>   
        <h1>Profil</h1>
        <form>
            Nom: <input type="text" name="Contact"><br>
            Fonction: <input type="text" name="Fonction"><br>
            Société: <input type="text" name="Societe"><br>
            Adresse: <input type="text" name="Adresse"><br>
            Code Postal: <input type="text" name="Code_Postal"><br>
            Ville: <input type="text" name="Ville"><br>
            Région: <input type="text" name="Region"><br>
            Pays: <input type="text" name="Pays"><br>
            Téléphone: <input type="text" name="Telephone"><br>
            Fax: <input type="text" name="Fax"><br>
        </form>
        <a href="Password">Changer de mot de passe</a><br>
        <input type="submit" value="Valider">
    </body>
</html>