/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 * Created on : 03 mars 2020, 15:30:22
    Author     : Kency
 */
var disp="none";

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
    p.style.display="none";
    var aff=p.value;
    document.getElementById(aff).style.display="inline-block";
}

function add(c){
    var aff=c.value;
    var n=document.getElementById(aff).children[1].innerText;
    n=parseInt(n,10)+1;
    document.getElementById(aff).children[1].innerText=n;
}

function rem(c,aff){
    var aff=c.value;
    var n=document.getElementById(aff).children[1].innerText;
    if(n>"0"){
        n=parseInt(n,10)-1;
        document.getElementById(aff).children[1].innerText=n;
    }
    if(n=="0"){
        document.getElementById(aff).style.display="none";
        document.getElementById(aff).previousElementSibling.style.display="block";
        n="1";
        document.getElementById(aff).children[1].innerText=n;
        
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