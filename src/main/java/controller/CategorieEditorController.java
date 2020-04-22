package controller;

import comptoirs.model.dao.CategorieFacade;
import comptoirs.model.dao.ClientFacade;
import comptoirs.model.dao.CommandeFacade;
import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.Controller;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import comptoirs.model.entity.Categorie;
import comptoirs.model.entity.Client;
import form.CategorieForm;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.mvc.View;
import javax.mvc.binding.BindingResult;
import javax.validation.Valid;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.FormParam;

@Controller
@Path("categorieEditor")
@View("categorieEditor.jsp")
//@TransactionManagement(TransactionManagementType.BEAN)
public class CategorieEditorController {

	@Inject
	CategorieFacade daoCat;
        
        @Inject
        ClientFacade daoClient;
        
        @Inject
        CommandeFacade daoCommande;
        
	@Inject
	Models models;

	@GET
	public void show() {
            models.put("clients", daoClient.findAll());
            models.put("categories", daoCat.findAll());
            models.put("payss",daoCommande.findAll());
	}

}
