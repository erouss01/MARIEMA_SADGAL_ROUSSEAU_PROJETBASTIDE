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
@Path("LoginA")
@View("LoginA.jsp")
public class LoginAController {
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

	}
        @POST
    @ValidateOnExecution(type = ExecutableType.ALL)
        public String LoginA(
            @FormParam("Code") String codeClient, @FormParam("Contact") String contactClient) {

           try {
               
             if(codeClient.equals("jachete")){
                if(contactClient.equals("ESSA")){
                    models.put("categories", daoCat.findAll());
                    models.put("clients", daoClient.findAll());
                    models.put("payss",daoCommande.getPays());
         return "categorieEditor.jsp";
            }
            
       
            }else{
                 models.put("databaseErrorMessage", "Le pseudo/ mot de passe est incorrect");
            }
                  
        } catch (NullPointerException e) {
            // Erreur possible : il existe déjà une catégorie avec ce libellé
            Logger.getLogger("Comptoirs").log(Level.INFO, "Echec{0}", e.getLocalizedMessage());
            // On pourrait examiner l'exception pour vérifier sa cause exacte
            models.put("databaseErrorMessage", "Le client" + codeClient + "n' existe pas");
        }
        

        return "LoginA.jsp";

    }
           
}