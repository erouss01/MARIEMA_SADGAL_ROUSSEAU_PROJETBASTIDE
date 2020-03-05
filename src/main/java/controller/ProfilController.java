/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author erouss01
 */

import comptoirs.model.dao.CategorieFacade;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;



@Controller
@Path("Profil")
@View("Profil.jsp")

public class ProfilController {
    @Inject // Le DAO généré par netBeans
	CategorieFacade dao;

	@Inject
	Models models;

	@GET
	public void show() {
		models.put("categories", dao.findAll());
	}
}

