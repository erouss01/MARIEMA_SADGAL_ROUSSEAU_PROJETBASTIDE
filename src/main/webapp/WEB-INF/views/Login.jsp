<%-- 
    Document   : Login
    Created on : 3 févr. 2020, 10:05:30
    Author     : rsadgal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
       
 <form  method="post">
            Login: <input type="text" name="contact"><br>
            Password: <input type="password" name="code"><br>
            <input type="submit" value="Submit">
        </form> 
 
        	<c:if test="${not empty databaseErrorMessage}">
			<span style="color: red;">${databaseErrorMessage}</span>
		</c:if>
    </body>
</html>
