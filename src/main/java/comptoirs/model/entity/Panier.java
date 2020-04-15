/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comptoirs.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
//import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kency
 */



@Entity
@Table(name = "PANIER")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Panier.findAll", query = "SELECT p FROM Panier p"),
	@NamedQuery(name = "Panier.findByNumero", query = "SELECT p FROM Panier p WHERE p.numero = :numero"),
	@NamedQuery(name = "Panier.findByCode", query = "SELECT p FROM Panier p WHERE p.code = :code"),
	@NamedQuery(name = "Panier.findByRef", query = "SELECT p FROM Panier p WHERE p.ref = :ref"),
	@NamedQuery(name = "Panier.findByProd", query = "SELECT p FROM Panier p WHERE p.produit = :produit"),
	@NamedQuery(name = "Panier.findByDes", query = "SELECT p FROM Panier p WHERE p.description = :description"),
	@NamedQuery(name = "Panier.findByPU", query = "SELECT p FROM Panier p WHERE p.prixU = :prixU"),
	@NamedQuery(name = "Panier.findByQte", query = "SELECT p FROM Panier p WHERE p.qte = :qte"),
	@NamedQuery(name = "Panier.findByPT", query = "SELECT p FROM Panier p WHERE p.prixT = :prixT"),
})

public class Panier implements Serializable{
    
        private static final long serialVersionUID = 1L;
	@Id
        @Basic(optional = false)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SeqGen")
        @SequenceGenerator(name = "SeqGen", sequenceName = "SAMPLE_SEQUENCE", allocationSize = 1)
        @Column(name = "NUMERO")
	private Integer numero;
        
        @Basic(optional = false)
        @Column(name = "CODE_CLIENT")
	private String code;
	
	@Basic(optional = false)
        @Column(name = "REFERENCE")
	private Integer ref;
	
	@Basic(optional = false)
        @Column(name = "NOM_PRODUIT")
	private String produit;
	
	@Basic(optional = false)
        @Column(name = "DESCRIPTION")
	private String description;
	
	@Basic(optional = false)
        @Column(name = "PRIX_UNITE")
	private BigDecimal prixU;
	
	@Basic(optional = false)
	@Column(name = "QUANTITE")
	private Integer qte;
	
	@Basic(optional = false)
        @Column(name = "PRIX_TOTAL")
	private BigDecimal prixT;
	
	
	/*@OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
	private Collection<Commande> commandeCollection;*/
        
        public Panier(){
            
        }
       
	public Panier(Integer numero,String code,Integer ref,String produit,String description,BigDecimal prixU,Integer qte,BigDecimal prixT) {
                this.numero=numero;
		this.code = code;
                this.ref=ref;
                this.produit=produit;
                this.description=description;
                this.prixU=prixU;
                this.qte=qte;
                this.prixT=prixT;
	}

        public Integer getNumero(){
            return numero;
        }
        
        public void setNumero(Integer n){
            this.numero=n;
        }
        
	public String getCode() {
		return code;
	}

	public void setCode(String c) {
		this.code = c;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int r) {
		this.ref = r;
	}

	public String getNom() {
		return produit;
	}

	public void setNom(String n) {
		this.produit = n;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String d) {
		this.description = d;
	}

	public BigDecimal getPrixU() {
		return prixU;
	}

	public void setPrixU(BigDecimal p) {
		this.prixU = p;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int q) {
		this.qte = q;
	}

	public BigDecimal getPrixT() {
		return prixT;
	}

	public void setPrixT(BigDecimal p) {
		this.prixT = p;
	}


	@Override
	public int hashCode() {
		int hash = 0;
		hash += (numero != null ? numero.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Panier)) {
			return false;
		}
		Panier other = (Panier) object;
		if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "comptoirs.model.entity.Panier[ numero=" + numero + " code="+code+" ref="+ref+" produit="+produit+" description="+description+" prixU="+prixU+" qte="+qte+" prixT="+prixT+" ]";
	}
}


