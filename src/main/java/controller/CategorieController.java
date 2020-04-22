package controller;

import comptoirs.model.dao.CategorieFacade;
import comptoirs.model.dao.ClientFacade;
import comptoirs.model.dao.PanierFacade;
import comptoirs.model.dao.ProduitFacade;
import comptoirs.model.entity.Client;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import session.ProfilSession;



@Controller
@Path("categories")
@View("showAllCategories.jsp")
public class CategorieController {
	@Inject // Le DAO généré par netBeans
	CategorieFacade dao;

	@Inject
        PanierFacade facade;
        
        @Inject
        ProduitFacade produitdao;

	@Inject
	Models models;
        
        @Inject
        private ProfilSession profilsession;

	@GET
	public void show() {
            String code=profilsession.getCodeClient();
            models.put("inpanier",facade.nomArticle(code));
            models.put("categories", dao.findAll());
            produitdao.majDispo();
	}
      
}
