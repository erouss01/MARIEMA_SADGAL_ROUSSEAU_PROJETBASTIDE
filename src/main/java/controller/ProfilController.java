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
import comptoirs.model.dao.PanierFacade;
import comptoirs.model.entity.Client;
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
import session.ProfilSession;

@Controller
@Path("Profil")
@View("Profil.jsp")

public class ProfilController {

    @Inject // Le DAO généré par netBeans
    ClientFacade dao;
    
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
        models.put("codeclient", dao.find(code));
    }

    @POST
    @ValidateOnExecution(type = ExecutableType.ALL)
    public String ChangementDonnees(
            @FormParam("Contact") String contactClient, @FormParam("Fonction") String fonctionClient,
            @FormParam("Societe") String societeClient, @FormParam("Telephone") String telephoneClient,
            @FormParam("Fax") String faxClient, @FormParam("Adresse") String adresseClient,
            @FormParam("Code_Postal") String codePClient, @FormParam("Ville") String villeClient,
            @FormParam("Region") String regionClient, @FormParam("Pays") String paysClient) {
        String code = profilsession.getCodeClient();
        Client c = dao.find(code);
        c.setPays(paysClient);
        c.setAdresse(adresseClient);
        c.setCodePostal(codePClient);
        c.setRegion(regionClient);
        c.setVille(villeClient);
        c.setFonction(fonctionClient);
        c.setFax(faxClient);
        c.setContact(contactClient);
        c.setSociete(societeClient);
        c.setTelephone(telephoneClient);
        
dao.edit(c);
        models.put("codeclient", dao.find(profilsession.getCodeClient()));
        return null;

    }
}
