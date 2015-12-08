package fr.esisar.panier.metier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import fr.esisar.panier.dao.DaoConsommateur;
import fr.esisar.panier.dao.DaoLigneCommande;

public class Commande {
	private int id;
	private Map<Integer,LigneCommande> lignes;
	private Livraison livraison;
	private String mailConso;
	
	/**
	 * 
	 */
	public Commande() {
		super();
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @return the map
	 */
	public Map<Integer,LigneCommande> getMap() {
		return lignes;
	}
	/**
	 * @param id the id to set
	 */
	public boolean setId(int id) {
		this.id = id;
		return true;
	}
	/**
	 * @return the lignes
	 */
	public Collection<LigneCommande> getLignes() {
		return lignes.values();
	}
	/**
	 * @param lignes the lignes to set
	 */
	public boolean setLignes(Collection<LigneCommande> lignes) {
		for (LigneCommande ligneCommande : lignes) {
			this.lignes.put(ligneCommande.getId(), ligneCommande);
		}
		return true;
	}
	/**
	 * @return the livraison
	 */
	public Livraison getLivraison() {
		return livraison;
	}
	/**
	 * @param livraison the livraison to set
	 */
	public boolean setLivraison(Livraison livraison) {
		this.livraison = livraison;
		return true;
	}
	
	public boolean addLigneCommande(LigneCommande newLigne) {
		this.lignes.put(newLigne.getId(), newLigne);
		newLigne.setIdCommande(getId());
		DaoLigneCommande daoLigne = new DaoLigneCommande();
		daoLigne.create(newLigne);
		return true;
	}
	
	public boolean removeLigneCommande(LigneCommande oldLigne) {
		this.lignes.remove(oldLigne.getId());
		DaoLigneCommande daoLigne = new DaoLigneCommande();
		daoLigne.remove(oldLigne);
		return true;
	}
	
	public boolean updateLigneCommande(LigneCommande updLigne) {
		DaoLigneCommande daoLigne = new DaoLigneCommande();
		daoLigne.update(updLigne);
		return true;
	}
	
	public String getMailConso() {
		return mailConso;
	}
	public boolean setMailConso(String mailConso) {
		if(mailConso == null || mailConso.isEmpty()) return false;
		this.mailConso = mailConso;
		return true;
	}
	public Consommateur getConso() {
		DaoConsommateur dao = new DaoConsommateur();
		return dao.getByCommande(this);
	}
	
	
}
