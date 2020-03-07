<%-- 
    Document   : LoginA
    Created on : 10 févr. 2020, 15:50:31
    Author     : rsadgal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>ESSA</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="..\Login.css" rel="stylesheet"/>
        <script src="..\js\accueil.js" type="text/javascript"></script>
    </head>
    <body>
        <header> 
            <div id="retour"><a href="..\index.html"><img src="..\\image\\retour.png" alt=retour"/></a></div>
            <div id="logo"> <a href="..\index.html"> <img src="..\\image\\logo2.png" alt="logo"/> </a> </div>
         </header>

        <div id="corps">
            <div id="form">
                <form method="post">
                    <h1>Identifiez-vous<br><text>Administrateur</text></h1>
                    
                    <label>Login: </label><br>
                    <input type="text" name="Contact"><br>
                    <label>Password: </label><br>
                    <input type="password" name="Code"><br>
                    <input type="submit" value="Submit">
                </form> 
                <c:if test="${not empty databaseErrorMessage}">
                        <span style="color: red;">${databaseErrorMessage}</span>
                </c:if>
            </div>
        </div>
    </body>
</html>
