/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var choix=null;
tri("categorie");

function tri(par){
    document.getElementById('selectCat').selectedIndex=0;
    document.getElementById('selectClient').selectedIndex=0;
    document.getElementById('selectPays').selectedIndex=0;
    document.querySelector("#btnpays").style.backgroundColor="transparent";
    document.querySelector("#btncat").style.backgroundColor="transparent";
    document.querySelector("#btncli").style.backgroundColor="transparent";
    
    document.getElementById("parCategorie").style.display="none";
    document.getElementById("parCategorie").style.visibility="hidden";
    document.getElementById("parPays").style.display="none";
    document.getElementById("parPays").style.visibility="hidden";
    document.getElementById("parClient").style.display="none";
    document.getElementById("parClient").style.visibility="hidden";
    if(par==="categorie"){
        choix=par;
        document.querySelector("#btncat").style.backgroundColor="#abcedf";
        document.getElementById("parCategorie").style.display="block";
        document.getElementById("parCategorie").style.visibility="visible";
    }if(par==="client"){
        choix=par;
        document.querySelector("#btncli").style.backgroundColor="#abcedf";
        document.getElementById("parClient").style.display="block";
        document.getElementById("parClient").style.visibility="visible";
    }if(par==="pays"){
        choix=par;
        document.querySelector("#btnpays").style.backgroundColor="#abcedf";
        document.getElementById("parPays").style.display="block";
        document.getElementById("parPays").style.visibility="visible";
    }
  }