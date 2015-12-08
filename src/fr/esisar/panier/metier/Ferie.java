package fr.esisar.panier.metier;

import java.util.Date;

import fr.esisar.panier.dao.DaoCalendrier;
import fr.esisar.panier.dao.DaoFerie;

public class Ferie {
	private Date begin;
	private Date end;
	private Date calendrierBegin;
	
	/**
	 * 
	 */
	private Ferie() {
		super();
	}

	/**
	 * @param begin
	 * @param end
	 */
	public Ferie(Date begin, Date end) {
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
		return true;
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
	
	public boolean setCalendrierBegin(Date calendrierBegin) {
		this.calendrierBegin = calendrierBegin;
		return true;
	}
	
	public Date getCalendrierBegin() {
		return calendrierBegin;
	}
	
	public Calendrier getCalendrier() {
		DaoCalendrier dao = new DaoCalendrier();
		return dao.getByFerie(this);
	}
	
}
