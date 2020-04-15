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

import comptoirs.model.dao.PanierFacade;
import comptoirs.model.dao.ProduitFacade;
import comptoirs.model.entity.Panier;
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



@Controller
@Path("Panier")
@View("Panier.jsp")
public class PanierController {
        @Inject // Le DAO généré par netBeans
	PanierFacade dao;

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
}
