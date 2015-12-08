package fr.esisar.panier.metier;

public class LigneCommande {
	private int id;
	private int quantite;
	private Produit produit;
	
	
	
	/**
	 * 
	 */
	public LigneCommande() {
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
	 * @return the quantite
	 */
	public int getQuantite() {
		return quantite;
	}
	/**
	 * @param quantite the quantite to set
	 */
	public boolean setQuantite(int quantite) {
		this.quantite = quantite;
		return false;
	}
	/**
	 * @return the produit
	 */
	public Produit getProduit() {
		return produit;
	}
	/**
	 * @param produit the produit to set
	 */
	public boolean setProduit(Produit produit) {
		this.produit = produit;
		return false;
	}
	
	
}
