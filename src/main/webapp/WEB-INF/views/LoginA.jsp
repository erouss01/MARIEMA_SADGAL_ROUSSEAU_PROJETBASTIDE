<%-- 
    Document   : LoginA
    Created on : 10 févr. 2020, 15:50:31
    Author     : rsadgal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post">
            Login: <input type="text" name="Contact"><br>
            Password: <input type="password" name="Code"><br>
            <input type="submit" value="Submit">
        </form> 
        <c:if test="${not empty databaseErrorMessage}">
			<span style="color: red;">${databaseErrorMessage}</span>
		</c:if>
    </body>
</html>
