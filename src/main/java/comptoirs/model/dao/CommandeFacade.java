/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comptoirs.model.dao;

import comptoirs.model.entity.Commande;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rbastide
 */
@Stateless
public class CommandeFacade extends AbstractFacade<Commande> {

	@PersistenceContext(unitName = "comptoirs")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public CommandeFacade() {
		super(Commande.class);
	}
	
        public List<Commande> getHistorique(String code){
            return em.createQuery("select c.numero,c.envoyeeLe,c.prixT,c.destinataire,c.adresseLivraison,c.villeLivraison,c.regionLivraison,c.codePostalLivrais,c.paysLivraison from Commande c where c.client=:codeClient",Commande.class).setParameter("codeClient",code).getResultList();
        }
}
