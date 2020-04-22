/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function doPostplus(btn,qte,prixU){
    var num=btn.parentElement.parentElement.parentElement.getAttribute("id");
    qte=qte+1;
    var prixT=qte*prixU;
    document.getElementById("articlepanier").value=num+","+qte+","+0+","+prixT+","+0;
    var ref=num+","+qte+","+0+","+prixT+","+0;
    ajaxCall(ref);
} 

function doPostmoins(btn,qte,prixU){
    var num=btn.parentElement.parentElement.parentElement.getAttribute("id");
    qte=qte-1;
    var prixT=qte*prixU;
    document.getElementById("articlepanier").value=num+","+qte+","+0+","+prixT+","+0;
    var ref=num+","+qte+","+0+","+prixT+","+0;
    ajaxCall(ref);
}

function doPostvider(){
    var num=0;
    var qte=0;
    document.getElementById("articlepanier").value=num+","+qte+","+1+","+0+","+0;
    var ref=num+","+qte+","+1+","+0+","+0;
    ajaxCall(ref);
}

function doPostdel(btn){
    var num=btn.parentElement.getAttribute("id");
    var qte=0;
    document.getElementById("articlepanier").value=num+","+qte+","+0+","+0+","+0;
    var ref=num+","+qte+","+0+","+0+","+0;
    ajaxCall(ref);
}


function envoyer(){
    document.getElementById("modifPanier").submit();
}

function doPostcom(total){
    document.getElementById("articlepanier").value=0+","+0+","+0+","+0+","+1+","+total;
    var ref=0+","+0+","+0+","+0+","+1+","+total;
    //setTimeout(envoyer,500);
    ajaxCom(ref);
}

function ajaxCall(ref) {
	let myHeaders = new Headers();
	myHeaders.append("Content-Type", "application/json");
        console.log("REF"+ref);
	const fetchOptions = {
		method: 'POST',
		headers: myHeaders,
		body:ref
	};
	fetch("Panier",fetchOptions)
	.then( (response) => {
            console.log(response.text());
            $("#corps").load("Panier #refresh");
	});

}


function ajaxCom(ref) {
	let myHeaders = new Headers();
	myHeaders.append("Content-Type", "application/json");
        console.log("REF"+ref);
	const fetchOptions = {
		method: 'POST',
		headers: myHeaders,
		body:ref
	};
	fetch("Panier",fetchOptions)
	.then( (response) => {
            console.log(response.text());
            window.location.replace("Historique");
	});

}
