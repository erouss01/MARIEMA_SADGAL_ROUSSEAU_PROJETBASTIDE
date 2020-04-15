package controller;

import comptoirs.model.dao.PanierFacade;
import comptoirs.model.dao.ProduitFacade;
import comptoirs.model.entity.Panier;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import javax.ejb.EJBException;
import javax.mvc.binding.BindingResult;
import javax.validation.Valid;
import javax.ws.rs.BeanParam;
import form.CategorieForm;
import java.math.BigDecimal;
import session.ProfilSession;



@Controller
@Path("produits")
@View("showAllProduits.jsp")
public class ProduitController {
	@Inject // Le DAO généré par netBeans
	ProduitFacade dao;
        
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
		models.put("produits", dao.findAll());
	}
        
        @POST
        @ValidateOnExecution(type = ExecutableType.ALL)
        public void PanierClient(
                @FormParam("article") String article) {

            
            String[]tab=article.split(",");
            int numero=1;
            String code=profilsession.getCodeClient();
            int ref=Integer.parseInt(tab[0]);
            String nom=dao.find(ref).getNom();
            BigDecimal prix=dao.find(ref).getPrixUnitaire();
            int qte=1;
            String description=dao.find(ref).getQuantiteParUnite(); 
            try{
                
                Panier nouveau=new Panier();
                nouveau.setCode(code);
                nouveau.setNom(nom);
                nouveau.setPrixT(prix);
                nouveau.setPrixU(prix);
                nouveau.setQte(qte);
                nouveau.setRef(ref);
                nouveau.setDescription(description);
                facade.create(nouveau);
                models.put("inpanier",facade.nomArticle(code));
                models.put("produits", dao.findAll());
                

            } catch (NullPointerException e) {
               // Erreur possible : il existe déjà une catégorie avec ce libellé
                Logger.getLogger("Comptoirs").log(Level.INFO, "Echec{0}", e.getLocalizedMessage());
                //On pourrait examiner l'exception pour vérifier sa cause exacte
                models.put("databaseErrorMessage", "Erreur");
            }

        }
}
