package fr.esisar.panier.metier;

import java.util.Date;

public class Livraison {
	private Date dateLivraison;

	/**
	 * 
	 */
	private Livraison() {
		super();
	}
	
	/**
	 * @param dateLivraison
	 */
	public Livraison(Date dateLivraison) {
		super();
		this.dateLivraison = dateLivraison;
	}

	/**
	 * @return the dateLivraison
	 */
	public Date getDateLivraison() {
		return dateLivraison;
	}

	/**
	 * @param dateLivraison the dateLivraison to set
	 */
	public boolean setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
		return false;
	}
	
	
}
