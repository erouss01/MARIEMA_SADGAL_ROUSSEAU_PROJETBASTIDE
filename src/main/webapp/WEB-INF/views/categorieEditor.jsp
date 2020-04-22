<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
        <title>ESSA</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="..\css\editor.css" rel="stylesheet"/><!-- On charge JQuery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<!-- On charge l'API Google -->
	<script type="text/javascript" src="https://www.google.com/jsapi"></script>
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        
        <script type="text/javascript">
            // Chargement de l'API Google Charts
            google.charts.load('current', {

              // Définition du package pour le graphique
              packages: ['corechart']
            });
            
              // Fonction à exécuter lorsque l'API est téléchargée
            function draw(result) {
                // Création de la visualisation "PieChart, LineChart,ColumnChart,AreaChart,ScatterChart, BarChart"
                var chart = new google.visualization.PieChart(document.getElementById('graphique'));
                // Formatage des options du graphique
                var options = {
                  width:700,
                  height:500,
                  backgroundColor:'#f5f4f2',
                  is3D:true
                };
                // Formatage des données
                var data =[['Produit','Unités Vendues']];
                result.forEach(ligne => data.push([ligne.libelle,ligne.unites]));
                var dataTable=google.visualization.arrayToDataTable(data);
                 // Dessin du graphique avec les données et les options
                chart.draw(dataTable, options);
            }
            
            function doAjaxCat(){
                var minDate=document.getElementById("minCat").value;
                var maxDate=document.getElementById("maxCat").value;
                if(minDate!="" && maxDate!=""){
                    document.getElementById("titregraph").textContent="Produits vendus par Catégorie pour la période du "+minDate+" au "+maxDate;
                    $.ajax({
                       url:"service/unitesVendues/produits",
                       //données du form
                       data:$('#formulaireCategorie').serialize(),
                       dataType:"json",
                       success:draw,
                       error:showError
                    });
                }
            }
              
            function doAjaxPays(){
                var minDate=document.getElementById("minPays").value;
                var maxDate=document.getElementById("maxPays").value;
                if(minDate!="" && maxDate!=""){
                    document.getElementById("titregraph").textContent="Produits vendus par Pays pour la période du "+minDate+" au "+maxDate;
                    $.ajax({
                       url:"service/unitesVendues/pays",
                       //données du form
                       data:$('#formulairePays').serialize(),
                       dataType:"json",
                       success:draw,
                       error:showError
                    });
                }
            }
              
            function doAjaxClient(){
                var minDate=document.getElementById("minClient").value;
                var maxDate=document.getElementById("maxClient").value;
                if(minDate!="" && maxDate!=""){
                    document.getElementById("titregraph").textContent="Produits vendus par Client pour la période du "+minDate+" au "+maxDate;
                    $.ajax({
                       url:"service/unitesVendues/client",
                       //données du form
                       data:$('#formulaireClient').serialize(),
                       dataType:"json",
                       success:draw,
                       error:showError
                    });
                }
            }

            function doAjaxDate(){
                var minDate =document.getElementById("minDate").value;
                var maxDate =document.getElementById("maxDate").value;
                if(minDate.length==10 && maxDate.length==10 && minDate<=maxDate){
                    document.getElementById("minCat").value=minDate;
                    document.getElementById("minClient").value=minDate;
                    document.getElementById("minPays").value=minDate;
                    
                    document.getElementById("maxCat").value=maxDate;
                    document.getElementById("maxClient").value=maxDate;
                    document.getElementById("maxPays").value=maxDate;
                    if(choix==="categorie" && document.getElementById("selectCat").value!="#"){
                        doAjaxCat();
                    }if(choix==="client" && document.getElementById("selectClient").value!="#"){
                        doAjaxClient();
                    }if(choix==="pays" && document.getElementById("selectPays").value!="#"){
                        doAjaxPays();
                    }
                }
                
            }

            function showError(xhr, status, message){
                alert("Error : "+status+","+message);
            }
              
        </script>
    </head>
        <body>

            <header> 
                <div id="logo"> <img src="..\\image\\logo2.png" alt="logo"/> </div>
                <div id="deconnexion"><a href="..\index.html"><img src="..\\image\\logout.png" alt=retour"/></a></div>
            </header>
            <div id="corps">
                <div id="gauche">
                    <h1>Visualisation des chiffres d'affaires </h1>
                    <h2>Trier par </h2><br>
                    <div id="tri">
                        <button id="btncat" onclick="tri('categorie');">catégorie</button>
                        <button id="btnpays" onclick="tri('pays');">pays</button>
                        <button id="btncli" onclick="tri('client');">client</button>
                    </div>
                    
                    <div id="ligne">
                        <div class="ligne">
                            <h2>Période souhaitée</h2>
                            <div id="date">
                                <form id="formulaireDate" onchange="doAjaxDate();">
                                    <input id="minDate" name=minDate type="date"/>
                                    <input id="maxDate" name=maxDate type="date"/>
                                </form>
                            </div>
                        </div>

                        <div class="ligne">
                            <div id="parCategorie">
                                <h2> Catégorie </h2>
                                <form id="formulaireCategorie">
                                    <select id='selectCat' name='codeCat' onchange='doAjaxCat();'>
                                        <option value='#'>Sélectionner une catégorie</option>
                                        <c:forEach var="categorie" items="${categories}">
                                            <option value='${categorie.code}'>${categorie.libelle}</option>
                                        </c:forEach>
                                    </select>
                                    <input id="minCat" name=minCat type="date" />
                                    <input id="maxCat" name=maxCat type="date" />
                                </form>
                            </div>
                            <div id="parPays">
                                <h2> Pays </h2>
                                <form id="formulairePays">
                                    <select id='selectPays' name='codePays' onchange='doAjaxPays();'>
                                        <option value='#'>Sélectionner un pays</option>
                                        <c:forEach var="pays" items="${payss}">
                                            <option value='${pays}'>${pays}</option>
                                        </c:forEach>
                                    </select>
                                    <input id="minPays" name=minPays type="date" />
                                    <input id="maxPays" name=maxPays type="date" />
                                </form>
                            </div>
                            <div id="parClient">
                                <h2> Client </h2>
                                <form id="formulaireClient">
                                    <select id='selectClient' name='codeClient' onchange='doAjaxClient();'>
                                        <option value='#'>Sélectionner une société</option>
                                        <c:forEach var="client" items="${clients}">
                                            <option value='${client.code}'>${client.societe}</option>
                                        </c:forEach>
                                    </select>
                                    <input id="minClient" name=minClient type="date" />
                                    <input id="maxClient" name=maxClient type="date" />
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="droite">
                    <p id='titregraph'></p>
                    <div id="graphique" ></div>
                </div>
            </div>
            <script src="../js/editor.js" type="text/javascript"></script>
        </body>
</html>