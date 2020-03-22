/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

/**
 *
 * @author Kency
 */
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named("ProfilSession")
public class ProfilSession implements Serializable{
    private String codesession = null;
	
    public void login(String code) {
            this.codesession = code;
    }
    public void logout() {
            this.codesession = null;
    }
            public boolean isConnected() {
            return codesession != null;
    }
    public String getCodeClient() {
            return codesession;
    }
}
