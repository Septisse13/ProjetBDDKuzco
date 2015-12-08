package fr.esisar.panier.metier;

import java.util.Date;
import java.util.Map;

import fr.esisar.panier.dao.DaoLivraison;

public class Calendrier {
	private Date begin;
	private Date end;
	private Date dateLimPaiementConso;
	private Date dateLimPaiementProd;
	private Date dateLimCom;
	
	private Map<Date, Livraison> livraisons;
	
	private Calendrier() {
		super();
	}
	
	public Calendrier(Date begin, Date end) {
		super();
		this.begin = begin;
		this.end = end;
	}
	
	/**
	 * @return the begin
	 */
	public Date getBegin() {
		return begin;
	}
	/**
	 * @param begin the begin to set
	 */
	public boolean setBegin(Date begin) {
		this.begin = begin;
		return false;
	}
	/**
	 * @return the end
	 */
	public Date getEnd() {
		return end;
	}
	/**
	 * @param end the end to set
	 */
	public boolean setEnd(Date end) {
		this.end = end;
		return true;
	}
	/**
	 * @return the dateLimPaiementConso
	 */
	public Date getDateLimPaiementConso() {
		return dateLimPaiementConso;
	}
	/**
	 * @param dateLimPaiementConso the dateLimPaiementConso to set
	 */
	public boolean setDateLimPaiementConso(Date dateLimPaiementConso) {
		this.dateLimPaiementConso = dateLimPaiementConso;
		return true;
	}
	/**
	 * @return the dateLimPaiementProd
	 */
	public Date getDateLimPaiementProd() {
		return dateLimPaiementProd;
	}
	/**
	 * @param dateLimPaiementProd the dateLimPaiementProd to set
	 */
	public boolean setDateLimPaiementProd(Date dateLimPaiementProd) {
		this.dateLimPaiementProd = dateLimPaiementProd;
		return true;
	}
	/**
	 * @return the dateLimCom
	 */
	public Date getDateLimCom() {
		return dateLimCom;
	}
	/**
	 * @param dateLimCom the dateLimCom to set
	 */
	public boolean setDateLimCom(Date dateLimCom) {
		this.dateLimCom = dateLimCom;
		return true;
	}
	
	public boolean addLivraison(Livraison newLivraison) {
		livraisons.put(newLivraison.getDateLivraison(), newLivraison);
		newLivraison.setCalendrierBegin(begin);
		DaoLivraison dao = new DaoLivraison();
		dao.create(newLivraison);
		return true;
	}
	
	public boolean removeLivraison(Livraison oldLivraison) {
		livraisons.remove(oldLivraison.getDateLivraison());
		DaoLivraison dao = new DaoLivraison();
		dao.remove(oldLivraison);
		return true;
	}
}
