/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comptoirs.model.dao;

import comptoirs.model.entity.Ligne;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rbastide
 */
@Stateless
public class LigneFacade extends AbstractFacade<Ligne> {

	@PersistenceContext(unitName = "comptoirs")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public LigneFacade() {
		super(Ligne.class);
	}
	
        public List<Ligne> commandeClient(int commande){
            return em.createQuery("select l from Ligne l where l.lignePK.commande = :commande",Ligne.class).setParameter("commande", commande).getResultList();
        }
}
