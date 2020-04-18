/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comptoirs.model.dao;

import comptoirs.model.entity.Panier;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;

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
            return em.createQuery("select p.numero,p.ref,p.produit,p.description,p.qte,p.prixT,p.prixU from Panier p where p.code=:code",Panier.class).setParameter("code", codeClient).getResultList();
        }
        
        public List<Panier> nomArticle(String codeClient){
            return em.createQuery("select distinct p.produit from Panier p where p.code=:code",Panier.class).setParameter("code", codeClient).getResultList();
        }
        
        public List<Panier> prixTotal(String codeClient){
            return em.createQuery("select sum(p.prixT) from Panier p where p.code=:code",Panier.class).setParameter("code", codeClient).getResultList();
        }
        
        public void modifQte(int numero,int quantite,BigDecimal prix){
            em.createQuery("update Panier p set p.qte=:qte, p.prixT=:prixT where p.numero=:numero",Panier.class).setParameter("qte", quantite).setParameter("prixT", prix).setParameter("numero", numero).executeUpdate();
        }
        
        public void viderPanier(String codeClient){
            em.createQuery("delete from Panier p where p.code=:code",Panier.class).setParameter("code",codeClient).executeUpdate();
        }
        
        public void supArticle(int numero){
            em.createQuery("delete from Panier p where p.numero=:numero",Panier.class).setParameter("numero", numero).executeUpdate();
        }
}



