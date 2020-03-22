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

import comptoirs.model.dao.ClientFacade;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import session.ProfilSession;



@Controller
@Path("Profil")
@View("Profil.jsp")

public class ProfilController {
    @Inject // Le DAO généré par netBeans
	ClientFacade dao;

	@Inject
	Models models;
        @Inject
        private ProfilSession profilsession;

	@GET
	public void show() {
		models.put("codeclient", dao.find(profilsession.getCodeClient()));
	}
}

