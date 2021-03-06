/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comptoirs.model.dao;

import comptoirs.model.entity.Produit;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rbastide
 */
@Stateless
public class ProduitFacade extends AbstractFacade<Produit> {

	@PersistenceContext(unitName = "comptoirs")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public ProduitFacade() {
		super(Produit.class);
	}
	
        public void modifStock(int ref,short stock,short commande){
            em.createQuery("update Produit p set p.unitesEnStock=:instock, p.unitesCommandees=:inorder where p.reference=:inref",Produit.class).setParameter("instock", stock).setParameter("inorder", commande).setParameter("inref", ref).executeUpdate();
        }
        
        public List<Produit> produitDispo(){
            short indispo=0;
            return em.createQuery("select p from Produit p where p.indisponible=:disponible",Produit.class).setParameter("disponible",indispo).getResultList();
        }
        
        public void majIndispo(){
            short d=1;
            em.createQuery("update Produit p set p.indisponible=:indispo where p.unitesEnStock=0",Produit.class).setParameter("indispo", d).executeUpdate();
        }
        public void majDispo(){
            short d=0;
            em.createQuery("update Produit p set p.indisponible=:dispo where p.unitesEnStock>0",Produit.class).setParameter("dispo", d).executeUpdate();
        }
        
}
