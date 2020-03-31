/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

window.addEventListener("load",information);

function information(){
    document.forms[0].elements["Contact"].value=document.getElementsByClassName("info")[0].textContent;
    document.forms[0].elements["Fonction"].value=document.getElementsByClassName("info")[1].textContent;
    document.forms[0].elements["Societe"].value=document.getElementsByClassName("info")[2].textContent;
    document.forms[0].elements["Telephone"].value=document.getElementsByClassName("info")[3].textContent;
    document.forms[0].elements["Fax"].value=document.getElementsByClassName("info")[4].textContent;
    document.forms[0].elements["Adresse"].value=document.getElementsByClassName("info")[5].textContent;
    document.forms[0].elements["Code_Postal"].value=document.getElementsByClassName("info")[6].textContent;
    document.forms[0].elements["Ville"].value=document.getElementsByClassName("info")[7].textContent;
    document.forms[0].elements["Region"].value=document.getElementsByClassName("info")[8].textContent;
    document.forms[0].elements["Pays"].value=document.getElementsByClassName("info")[9].textContent;
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

