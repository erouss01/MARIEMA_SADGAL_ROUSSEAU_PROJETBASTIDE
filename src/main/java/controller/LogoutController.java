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

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import session.ProfilSession;

@Controller
@Path("Logout")
@View("Logout.jsp")
public class LogoutController {

    @Inject
    private ProfilSession profilsession;

    @GET
    public String LogoutClient(){
        profilsession.logout();
        return "Login.jsp";

    }
}
