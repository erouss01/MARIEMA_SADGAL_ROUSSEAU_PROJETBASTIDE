/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comptoirs.model.dao;

import comptoirs.model.entity.Panier;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Kency
 */
@Stateless
public class PanierFacade extends AbstractFacade<Panier> {
        @PersistenceContext(unitName = "comptoirs")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public PanierFacade() {
		super(Panier.class);
	}
        
        public List<Panier> panierClient(String codeClient){
            return em.createQuery("select p.numero,p.ref,p.produit,p.description,p.qte,p.prixT from Panier p where p.code=:code",Panier.class).setParameter("code", codeClient).getResultList();
        }
        
        public List<Panier> nomArticle(String codeClient){
            return em.createQuery("select distinct p.produit from Panier p where p.code=:code",Panier.class).setParameter("code", codeClient).getResultList();
        }
        
        public List<Panier> prixTotal(String codeClient){
            return em.createQuery("select sum(p.prixT) from Panier p where p.code=:code",Panier.class).setParameter("code", codeClient).getResultList();
        }
}



