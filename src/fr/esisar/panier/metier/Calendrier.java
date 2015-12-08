package fr.esisar.panier.metier;

import java.util.Date;

public class Calendrier {
	private Date begin;
	private Date end;
	private Date dateLimPaiementConso;
	private Date dateLimPaiementProd;
	private Date dateLimCom;
	
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
	public void setBegin(Date begin) {
		this.begin = begin;
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
		return false;
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
		return false;
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
		return false;
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
		return false;
	}
}
