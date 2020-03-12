<%-- 
    Document   : Password
    Created on : 5 mars 2020, 16:04:10
    Author     : erouss01
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>ESSA</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="..\css\password.css" rel="stylesheet"/>
    </head>
    <body>
        
        <header> 
            <div id="retour"><a href="Profil"><img src="..\\image\\retour.png" alt=retour"/></a></div>
            <div id="logo"><img src="..\\image\\logo2.png" alt="logo"/></div>
         </header>
        
        <div id="corps">
            <div id="form">
                <form  method="post">
                    <h1>Changer de mot de passe</h1>
                    Mot de passe actuel: <input type="password" name="Code1"><br>
                    Nouveau mot de passe: <input type="password" name="Code2"><br>
                    Confirmer mot de passe: <input type="password" name="Code3"><br>
                    <input type="submit" value="Valider">
                </form>
            </div>
        </div>
    </body>
</html>
