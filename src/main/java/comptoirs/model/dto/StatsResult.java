/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comptoirs.model.dto;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author Kency
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class StatsResult {

	public StatsResult(String libelle, Long unites) {
		this.unites = unites;
		this.libelle = libelle;
	}
	
	public StatsResult() {
		this("Inconnu", 0l);
	}
	
	// Pas utile de mettre des "getter" ici (final)
	@XmlElement
	public final Long unites;

	@XmlElement
	public final String libelle;
	
}