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
        document.getElementById("voile").style.backgroundColor="rgba(0,0,0,0.5)";
        disp="block";
    }else{
        document.getElementById("favDialog").style.display="none";
        disp="none";
        document.getElementById("voile").style.backgroundColor="transparent";
    }
}
