package service;

import comptoirs.model.dao.CategorieFacade;
import java.util.List;
import javax.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import comptoirs.model.entity.Categorie;


@Path("allCategories")
public class AllCategoriesService {
	@Inject
	CategorieFacade facade;
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Categorie> allCategories() {
		return facade.findAll();
	}
}
