package fr.esisar.panier.metier;

import java.util.ArrayList;

public class Commande {
	private int id;
	private ArrayList<LigneCommande> lignes;
	private Livraison livraison;
	
	
	
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
	 * @param id the id to set
	 */
	public boolean setId(int id) {
		this.id = id;
		return false;
	}
	/**
	 * @return the lignes
	 */
	public ArrayList<LigneCommande> getLignes() {
		return lignes;
	}
	/**
	 * @param lignes the lignes to set
	 */
	public boolean setLignes(ArrayList<LigneCommande> lignes) {
		this.lignes = lignes;
		return false;
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
		return false;
	}
	
	
}
