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
import comptoirs.model.dao.ClientFacade;
import comptoirs.model.entity.Client;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@Path("Password")
@View("Password.jsp")

public class Mdp {

    @Inject // Le DAO généré par netBeans
    ClientFacade dao;

    @Inject
    Models models;

    @GET
    public void show() {

    }

    @POST
    @ValidateOnExecution(type = ExecutableType.ALL)
    public String ChangementDonnees(@FormParam("Code1") String code,
            @FormParam("Code2") String code1, @FormParam("Code3") String code2
    ) {
        try {
            Client c = dao.find(code);
            if (code1.equals(code2)) {
                c.setCode(code1);
                dao.edit(c);

            }else{
                models.put("databaseErrorMessage", "Les deux mots de passe ne correspondent pas");
            }}
            catch (NullPointerException e) {
            // Erreur possible : il existe déjà une catégorie avec ce libellé
            Logger.getLogger("Comptoirs").log(Level.INFO, "Echec{0}", e.getLocalizedMessage());
            // On pourrait examiner l'exception pour vérifier sa cause exacte
            models.put("databaseErrorMessage", "Le mot de passe est incorrect");
        }
   return "Password.jsp";
        }
    }
