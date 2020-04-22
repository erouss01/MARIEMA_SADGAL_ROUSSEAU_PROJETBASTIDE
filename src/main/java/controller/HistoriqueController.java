/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comptoirs.model.dao.CommandeFacade;
import comptoirs.model.dao.LigneFacade;
import comptoirs.model.dao.PanierFacade;
import comptoirs.model.dao.ProduitFacade;
import comptoirs.model.entity.Commande;
import comptoirs.model.entity.Ligne;
import comptoirs.model.entity.Produit;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import session.ProfilSession;
import javax.ejb.EJBException;

/**
 *
 * @author Kency
 */
@Controller
@Path("Historique")
@View("Historique.jsp")
public class HistoriqueController {
    @Inject
    CommandeFacade daoCommande;
    
    @Inject
    LigneFacade daoLigne;
    
    @Inject
    ProduitFacade daoProduit;
    
    @Inject
    PanierFacade facade;
    
    @Inject
    Models models;
    
    @Inject
    private ProfilSession profilsession;
    
    @GET
    public void show() {
        String code=profilsession.getCodeClient();
        models.put("inpanier",facade.nomArticle(code));
        models.put("historique",daoCommande.getHistorique(code));
    }
    
    @POST
    public String getCommande(
        @FormParam("numero") String numero){
            String code=profilsession.getCodeClient();
            int numeroCommande=Integer.parseInt(numero);
            Commande commande=daoCommande.find(numeroCommande);
            models.put("commande",commande);
            List<Produit>produit=new ArrayList<>();
            List<Ligne> ligne=daoLigne.commandeClient(numeroCommande);
            for(Ligne l:ligne){
                Produit p=daoProduit.find(l.getProduit1().getReference());
                produit.add(p);
            }
            models.put("ligne",ligne);
            models.put("produit",produit);
            models.put("inpanier",facade.nomArticle(code));
            return "commandes.jsp";
    }
}
