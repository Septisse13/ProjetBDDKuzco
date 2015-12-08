package fr.esisar.panier.metier;

import java.util.Date;

import fr.esisar.panier.dao.DaoCalendrier;

public class Livraison {
	private Date dateLivraison;
	private Date calendrierBegin;
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
		return true;
	}
	
	public boolean setCalendrierBegin(Date calendrierBegin) {
		this.calendrierBegin = calendrierBegin;
		return true;
	}
	
	public Calendrier getCalendrier() {
		DaoCalendrier dao = new DaoCalendrier();
		return dao.getByLivraison(this);
	}
	
	public Date getCalendierBegin() {
		return this.calendrierBegin;
	}
	
}
