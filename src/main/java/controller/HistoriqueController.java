/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comptoirs.model.dao.CommandeFacade;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import session.ProfilSession;

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
    Models models;
    
    @Inject
    private ProfilSession profilsession;
    
    @GET
    public void show() {
        String code=profilsession.getCodeClient();
        models.put("historique",daoCommande.getHistorique(code));
    }
}
