<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
        <title>ESSA</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="..\css\editor.css" rel="stylesheet"/>
        <script src="https://www.gstatic.com/charts/loader.js"></script>
        <script>

            // Chargement de l'API Google Charts
            google.charts.load('current', {

              // Définition du package pour le graphique
              packages: ['corechart'],

              // Fonction à exécuter lorsque l'API est téléchargée
              callback: function() {

                // Création de la visualisation "PieChart, LineChart,ColumnChart,AreaChart,ScatterChart, BarChart"
                var chart = new google.visualization.PieChart(document.getElementById('graphique'));

                // Formatage des options du graphique
                var options = {
                  width : 500,
                  height: 300
                };

                // Formatage des données
                var data = new google.visualization.DataTable();

                data.addColumn('string', 'Libellé de série');
                data.addColumn('number', 'Valeurs de série 1');
                data.addColumn('number', 'Valeurs de série 2');
                data.addRows([
                  ['Valeur 1', 1, 2],
                  ['Valeur 2', 2, 3],
                  ['Valeur 3', 3, 4],
                  ['Valeur 4', 4, 5],
                  ['Valeur 5', 5, 6],
                ]);

                // Dessin du graphique avec les données et les options
                chart.draw(data, options);

              }
            });
        </script>
    </head>

	<body>
            
            <header> 
                <!-- <div id="retour"><a href="Profil"><img src="..\\image\\retour.png" alt=retour"/></a></div> -->
                <div id="logo"> <img src="..\\image\\logo2.png" alt="logo"/> </div>
                <div id="deconnexion"><a href="..\index.html"><img src="..\\image\\logout.png" alt=retour"/></a></div>
            </header>
            
            
            <div id="corps">
                <div id="form">

                    <form method="POST"> <%-- L'action par défaut est de revenir à l'URL du contrôleur --%>
                        <h1>Edition des catégories</h1>
                        <input type="text" name="libelle" placeholder="Libellé de la catégorie"><br>		
                        <input type="text" name="description" placeholder="Description de la catégorie"><br>
                        <input type="submit" value="ajouter une nouvelle catégorie">
                    </form>
                    <%-- Est-ce qu'on a un message d'erreur à afficher ? --%>
                    <c:if test="${not empty databaseErrorMessage}">
                            <h2>Erreur !</h2>
                            <span style="color: red;">${databaseErrorMessage}</span>
                    </c:if>
                    <table border='1'>
                            <tr><th>Code</th><th>Libellé</th><th>Description</th></tr>
                                            <%-- Pour chaque categorie, une ligne dans la table HTML --%>
                                            <c:forEach var="categorie" items="${categories}">
                                    <tr>
                                            <td>${categorie.code}</td>
                                            <td>${mvc.encoders.html(categorie.libelle)}</td>
                                            <td>${mvc.encoders.html(categorie.description)}</td>
                                    </tr>
                            </c:forEach>
                    </table>
                </div>
                                            
                <div id="chiffre">
                    <h1>Visualisation des chiffres d'affaires </h1>
                    <h2>Trier par </h2><br>
                    <div id="tri">
                        <button onclick="tri(this);">catégorie</button>
                        <button onclick="tri(this);">pays</button>
                        <button onclick="tri(this);">client</button>
                    </div>
                    
                    <div id="ligne">
                        <div class="ligne">
                            <h2>Période souhaitée</h2>
                            <div id="date">
                                <input type="date"/>
                                <input type="date"/>
                            </div>
                        </div>

                        <div class="ligne">
                            <h2> Type de graphique</h2>
                            <div id="type">
                                <select>
                                    <option>PieChart</option>
                                    <option>LineChart</option>
                                    <option>ColumnChart</option>
                                    <option>AreaChart</option>
                                    <option>ScatterChart</option>
                                    <option>BarChart</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <h2> Graphique </h2>
                    <div id="graphique">
                    </div>
                </div>
            </div>
            
            <script src="../js/accueil.js" type="text/javascript"></script>
	</body>
</html>