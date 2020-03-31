package controller;

import comptoirs.model.dao.ProduitFacade;
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



@Controller
@Path("produits")
@View("showAllProduits.jsp")
public class ProduitController {
	@Inject // Le DAO généré par netBeans
	ProduitFacade dao;

	@Inject
	Models models;

	@GET
	public void show() {
		models.put("produits", dao.findAll());
	}
        
        @POST
        @ValidateOnExecution(type = ExecutableType.ALL)
        public void panier(@FormParam("code") String codeClient, int id) {
            
		models.put("produits", dao.findAll());
	}
}