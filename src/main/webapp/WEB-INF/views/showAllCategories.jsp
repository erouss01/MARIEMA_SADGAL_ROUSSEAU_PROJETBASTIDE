<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
	<title>ESSA</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="..\css\categories.css" rel="stylesheet"/>
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
        <a href="Profil"><div id="profil">Accéder à mon profil </div></a>
        <a href=""><div id="historique">Historique des commandes</div></a>
        <a href="..\index.html"><div id="deconnexion">Déconnexion</div></a>
    </div>

    <div id="voile">
            .
    </div>

    <div id="corps"> 
        <h1> Tous nos rayons </h1>
        <div id="rayon">

        <%int nb=1;%>
        <c:forEach var="categorie" items="${categories}">
            <% 
                String debut_nom="../image/r";
                String fin_nom=".jpg ";
                String nom=debut_nom+nb+fin_nom;
            %>
            <button><img alt=${categorie.code} src=<%out.print(nom); %>/><br>
                ${mvc.encoders.html(categorie.libelle)}<br>
                ${mvc.encoders.html(categorie.description)}
            </button>
            <%
                if(nb%4==0){
            %>
            <br>                
            <% }
                nb=nb+1;
            %>
        </c:forEach>

        </div>
        <%--<a href="${pageContext.request.contextPath}">Retour au menu</a>--%>
    </div>

    <script src="../js/accueil.js" type="text/javascript"></script>
</body>

</html>