/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comptoirs.model.dao.CategorieFacade;
import comptoirs.model.dao.ClientFacade;
import comptoirs.model.dao.CommandeFacade;
import comptoirs.model.entity.Client;
import comptoirs.model.entity.Commande;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJBException;
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
@Path("Login")
@View("Login.jsp")
public class LoginController {

    @Inject // Le DAO (auto-généré) qui gère les entités "Client"
    ClientFacade facade;
    @Inject
    CategorieFacade dao;
    @Inject
    Models models; // Pour transmettre les infos à la vue
    @Inject
    private ProfilSession profilsession;

    @GET
    public void show() {

    }

    @POST
    @ValidateOnExecution(type = ExecutableType.ALL)
    public String LoginClient(
            @FormParam("code") String codeClient, @FormParam("contact") String contactClient) {

        try {
            Client c = facade.find(codeClient);
            if(c.getContact().equals(contactClient)){
                models.put("categories", dao.findAll());
                profilsession.login(codeClient);
                return "showAllCategories.jsp";
            }else{
                 models.put("databaseErrorMessage", "Le pseudo/ mot de passe est incorrect");
            }
                  
        } catch (NullPointerException e) {
            // Erreur possible : il existe déjà une catégorie avec ce libellé
            Logger.getLogger("Comptoirs").log(Level.INFO, "Echec{0}", e.getLocalizedMessage());
            // On pourrait examiner l'exception pour vérifier sa cause exacte
            models.put("databaseErrorMessage", "Le client" + codeClient + "n' existe pas");
        }
        

        return "Login.jsp";

    }
}
