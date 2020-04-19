/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*function doPostplus(qte){
    var url="mvc/Panier";
    var params="qte=2&num=22";
    alert(params);
    var xhr=new XMLHttpRequest();
    xhr.open("POST",url,true);
    xhr.setRequestHeader("Content-type","application/x-wwww-form-urlencoded");
        
    xhr.addEventListener('readystatechange',function(){
       if(xhr.readyState===XMLHttpRequest.DONE && xhr.status===200){
           alert("ok");
       }else{
           alert('notok');
       }
    });
    
    xhr.send(params);
}*/

function doPostplus(btn,qte,prixU){
    var num=btn.parentElement.parentElement.parentElement.getAttribute("id");
    qte=qte+1;
    var prixT=qte*prixU;
    document.getElementById("articlepanier").value=num+","+qte+","+0+","+prixT+","+0;
    setTimeout(envoyer,500);
} 

function doPostmoins(btn,qte,prixU){
    var num=btn.parentElement.parentElement.parentElement.getAttribute("id");
    qte=qte-1;
    var prixT=qte*prixU;
    document.getElementById("articlepanier").value=num+","+qte+","+0+","+prixT+","+0;
    setTimeout(envoyer,500);
}

function doPostvider(){
    var num=0;
    var qte=0;
    document.getElementById("articlepanier").value=num+","+qte+","+1+","+0+","+0;
    setTimeout(envoyer,500);
}

function doPostdel(btn){
    var num=btn.parentElement.getAttribute("id");
    var qte=0;
    document.getElementById("articlepanier").value=num+","+qte+","+0+","+0+","+0;
    setTimeout(envoyer,500);
}


function envoyer(){
    document.getElementById("modifPanier").submit();
}

function doPostcom(total){
    document.getElementById("articlepanier").value=0+","+0+","+0+","+0+","+1+","+total;
    setTimeout(envoyer,500);
}