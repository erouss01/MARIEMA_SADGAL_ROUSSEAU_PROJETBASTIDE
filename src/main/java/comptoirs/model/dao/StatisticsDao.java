package comptoirs.model.dao;

import comptoirs.model.dto.StatsResult;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
//import util.HtmlSqlDate;

@Stateless
public class StatisticsDao {
	/*private static final String UNITS_SOLD
		= "SELECT cat.libelle, SUM(li.quantite) "
		+ "FROM Categorie cat "
		+ "JOIN cat.produitCollection p "
		+ "JOIN p.ligneCollection li "
		+ "GROUP BY cat.libelle";

	private static final String UNIT_SOLDS_DTO
		= "SELECT new comptoirs.model.dto.StatsResult"
		+ "(cat.libelle, SUM(li.quantite)) "
		+ "FROM Categorie cat "
		+ "JOIN cat.produitCollection p "
		+ "JOIN p.ligneCollection li "
		+ "GROUP BY cat.libelle";*/

        
        private static final String CATEGORIE_SOLDS_DTO
		= "SELECT new comptoirs.model.dto.StatsResult"
		+ "(p.nom, SUM(li.quantite)) "
		+ "FROM Produit p "
		+ "JOIN p.categorie cat "
		+ "JOIN p.ligneCollection li "
		+ "JOIN li.commande1 com "
		+ "WHERE cat.code = :codeCategorie "
                + "AND com.envoyeeLe between :minDate and :maxDate "
		+ "GROUP BY p.nom ";
        
        
	private static final String CLIENT_SOLDS_DTO
		= "SELECT new comptoirs.model.dto.StatsResult"
		+ "(p.nom, SUM(li.quantite)) "
		+ "FROM Produit p "
		+ "JOIN p.categorie cat "
		+ "JOIN p.ligneCollection li "
		+ "JOIN li.commande1 com "
		+ "WHERE com.client = :codeClient "
                + "AND com.envoyeeLe between :minDate and :maxDate "
		+ "GROUP BY p.nom ";
        
       
         private static final String PAYS_SOLDS_DTO
		= "SELECT new comptoirs.model.dto.StatsResult"
		+ "(p.nom, SUM(li.quantite)) "
		+ "FROM Produit p "
		+ "JOIN p.ligneCollection li "
		+ "JOIN li.commande1 com "
		+ "WHERE com.paysLivraison = :pays "
                + "AND com.envoyeeLe between :minDate and :maxDate "
		+ "GROUP BY p.nom ";
        
	@PersistenceContext(unitName = "comptoirs")
	private EntityManager em;

	/*public List unitesVenduesParCategorie() {
		Query query = em.createNamedQuery("Categorie.unitesVendues");
		List results = query.getResultList();
		return results;
	}
        
        
	public List<StatsResult> unitesVenduesParCategorieDTO() {
		Query query = em.createQuery(UNIT_SOLDS_DTO, StatsResult.class);
		List<StatsResult> results = query.getResultList();
		return results;
	}*/

        
        public List<StatsResult> produitsVendusParCategorie(Integer codeCategorie,Date min,Date max) throws ParseException {
            Query query = em.createQuery(CATEGORIE_SOLDS_DTO, StatsResult.class);
            List<StatsResult> results = query.setParameter("codeCategorie", codeCategorie).setParameter("minDate", min).setParameter("maxDate", max).getResultList();
            return results;
	}
        
        public List<StatsResult> produitsVendusParClient(String codeClient,Date min,Date max) throws ParseException{
            Query query = em.createQuery(CLIENT_SOLDS_DTO, StatsResult.class);
            List<StatsResult> results = query.setParameter("codeClient", codeClient).setParameter("minDate", min).setParameter("maxDate", max).getResultList();
            return results;
        }
        
        public List<StatsResult> produitsVendusParPays(String pays,Date min,Date max) throws ParseException{
            Query query = em.createQuery(PAYS_SOLDS_DTO, StatsResult.class);
            List<StatsResult> results = query.setParameter("pays", pays).setParameter("minDate", min).setParameter("maxDate", max).getResultList();
            return results;
        }

	/*public Date datePlusRecenteCommande() {
		Date result = em.createQuery("select max(c.envoyeeLe) from Commande c", Date.class)
			.getSingleResult();
		return result;
	}

	public Date datePlusAncienneCommande() {
		Date result = em.createQuery("select min(c.envoyeeLe) from Commande c", Date.class)
			.getSingleResult();
		return result;
	}

	public List<Integer> commandesEntre(Date minDate, Date maxDate) {
            return em.createQuery("select c.numero from Commande c where c.envoyeeLe between :minDate and :maxDate", Integer.class)
                    .setParameter("minDate", minDate)
                    .setParameter("maxDate", maxDate)
                    .getResultList();
	}*/
        
}
