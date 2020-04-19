/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * Created on : 03 mars 2020, 15:30:22
    Author     : Kency
 */
var disp="none";


var date=document.getElementsByClassName("date");
for(i=0;i<date.length;i++){
    var dateD=date[i].textContent;
    var tab=dateD.split(" ");
    var dateI=tab[0]+" "+tab[2]+" "+tab[1]+" "+tab[5];
    date[i].textContent=dateI;
}

function afficher(){
    if(disp==="none"){
        document.getElementById("favDialog").style.display="block";
        document.getElementById("voile").style.display="block";
        disp="block";
    }else{
        document.getElementById("favDialog").style.display="none";
        document.getElementById("voile").style.display="none";
        disp="none";
    }
}


function ajouter_panier(p){
    var ref=p.value;
    document.getElementById("articlepanier").value=ref;
    
    setTimeout(envoyer_panier,500);
}

function envoyer_panier(){
    document.getElementById("ajoutPanier").submit();
}

function add(c){
    var num=c.value;
    var n=document.getElementById(num).children[1].innerText;
    n=parseInt(n,10)+1;
    document.getElementById(num).children[1].innerText=n;
    
    var h3="h3#h"+num;
    var nom=document.querySelector(h3).textContent;
    document.getElementById("articlepanier").value=num+","+nom+","+n;
}

function rem(c,aff){
    var num=c.value;
    var n=document.getElementById(num).children[1].innerText;
    if(n>"0"){
        n=parseInt(n,10)-1;
        document.getElementById(num).children[1].innerText=n;
        var h3="h3#h"+num;
        var nom=document.querySelector(h3).textContent;
        document.getElementById("articlepanier").value=num+","+nom+","+n;
    }
    if(n=="0"){
        document.getElementById(num).style.display="none";
        document.getElementById(num).previousElementSibling.style.display="block";
        n="1";
        document.getElementById(num).children[1].innerText=n;
        
    }
}


function tri(c){
    document.getElementById('tri').children[0].style.background="none";
    document.getElementById('tri').children[1].style.background="none";
    document.getElementById('tri').children[2].style.background="none";
    c.style.background="#abcdef";
}

   
    (function (global) {
    document.getElementById("article").addEventListener("click", function () {
        global.localStorage.setItem("SharedData", document.getElementById("nom").innerHTML);
       window.location='showAllProduits.jsp'
    }, false);
}(window));

(function (global) {
    document.getElementById("produitP").innerHTML = global.localStorage.getItem("mySharedData");

}(window));


function voir(commande){
    document.getElementById("numeroCommande").value=commande;
    setTimeout(envoyer,500);
}

function envoyer(){
    document.getElementById("voirCommande").submit();
}
