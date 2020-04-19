/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Kency
 */

import comptoirs.model.dao.ClientFacade;
import comptoirs.model.dao.CommandeFacade;
import comptoirs.model.dao.LigneFacade;
import comptoirs.model.dao.PanierFacade;
import comptoirs.model.dao.ProduitFacade;
import comptoirs.model.entity.Client;
import comptoirs.model.entity.Commande;
import comptoirs.model.entity.Ligne;
import comptoirs.model.entity.LignePK;
import comptoirs.model.entity.Panier;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import session.ProfilSession;
import javax.ejb.EJBException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;



@Controller
@Path("Panier")
@View("Panier.jsp")
public class PanierController {
        @Inject // Le DAO généré par netBeans
	PanierFacade dao;
        
        @Inject
        CommandeFacade facade;
        
        @Inject
        ClientFacade clientdao;
        
        @Inject
        LigneFacade lignedao;
        
        @Inject
        ProduitFacade produitdao;

	@Inject
	Models models;
                
        @Inject
        private ProfilSession profilsession;

	@GET
	public void show() {
            String code=profilsession.getCodeClient();
            models.put("panier",dao.panierClient(code));
            models.put("total",dao.prixTotal(code));
        }
        
        @POST
        @ValidateOnExecution(type = ExecutableType.ALL)
        public String PanierClient(
                @FormParam("prdt") String produit) {

            String[]tab=produit.split(",");
            
                int numero=Integer.parseInt(tab[0]);
                int qte=Integer.parseInt(tab[1]);
                int vide=Integer.parseInt(tab[2]);
                int commander=Integer.parseInt(tab[4]);
                try{
                    if(vide==1){
                        dao.viderPanier(profilsession.getCodeClient());
                    }else{
                        if(commander==0){
                            if(qte==0){
                                dao.supArticle(numero);
                                show();
                            }else{
                                BigDecimal prix=new BigDecimal(tab[3]);
                                dao.modifQte(numero,qte,prix);
                                //dao.find(numero).setPrixT(prix);
                                show();
                            }
                        }else{
                            int total=Integer.parseInt(tab[5]);
                            Commande nouvelle=new Commande();
                            DateFormat sform=new SimpleDateFormat("yyyy-mm-dd");
                            Client client=new Client();
                            client=clientdao.find(profilsession.getCodeClient());
                            nouvelle.setEnvoyeeLe(new Date());
                            nouvelle.setDestinataire(client.getSociete());
                            nouvelle.setAdresseLivraison(client.getAdresse());
                            nouvelle.setVilleLivraison(client.getVille());
                            nouvelle.setRegionLivraison(client.getRegion());
                            nouvelle.setCodePostalLivrais(client.getCodePostal());
                            nouvelle.setPaysLivraison(client.getPays());
                            nouvelle.setRemise(new BigDecimal(0));
                            nouvelle.setClient(client.getCode());
                            BigDecimal prix=new BigDecimal(total);
                            nouvelle.setTotal(prix);
                            facade.create(nouvelle);
                            
                            LignePK new_LPK=new LignePK();
                            new_LPK.setCommande(nouvelle.getNumero());
                            for(Panier p : dao.findAll()){
                                new_LPK.setProduit(p.getRef());
                                short quantity=(short) p.getQte();
                                Ligne new_ligne=new Ligne();
                                new_ligne.setLignePK(new_LPK);
                                new_ligne.setQuantite(quantity);
                                lignedao.create(new_ligne);
                                
                                short uniteStock=produitdao.find(p.getRef()).getUnitesEnStock();
                                short uniteOrder=produitdao.find(p.getRef()).getUnitesCommandees();
                                uniteStock=(short) (uniteStock-quantity);
                                uniteOrder=(short) (uniteOrder+quantity);
                                produitdao.modifStock(p.getRef(), uniteStock, uniteOrder);
                                
                            }
                            dao.viderPanier(profilsession.getCodeClient());
                            return "Historique.jsp";
                        }
                    }
                } catch (NullPointerException e) {
                   // Erreur possible : il existe déjà une catégorie avec ce libellé
                    Logger.getLogger("Comptoirs").log(Level.INFO, "Echec{0}", e.getLocalizedMessage());
                    //On pourrait examiner l'exception pour vérifier sa cause exacte
                    models.put("databaseErrorMessage", "Erreur");
                }
                return null;
        }
        
        
}


