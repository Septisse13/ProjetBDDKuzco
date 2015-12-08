package fr.esisar.panier.metier;

import fr.esisar.panier.dao.DaoCommande;
import fr.esisar.panier.dao.DaoProduit;

public class LigneCommande {
	private int id;
	private int idCommande;
	private int quantite;
	private String produitNom;
	private boolean isDelivered;
	
	/**
	 * 
	 */
	public LigneCommande() {
		super();
	}
	
	/**
	 * 
	 */
	public LigneCommande(int id, int idCommande, int quantite, String produitNom, boolean isDelivered) {
		super();
		this.id=id;
		this.idCommande=idCommande;
		this.quantite=quantite;
		this.produitNom=produitNom;
		this.isDelivered=isDelivered;
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
		return true;
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
		if(quantite <= 0 || quantite > 10000) return false;
		this.quantite = quantite;
		return false;
	}
	/**
	 * @return the produit
	 */
	public Produit getProduit() {
		DaoProduit dao = new DaoProduit();
		return dao.getByNom(produitNom);
	}
	/**
	 * @return the produit
	 */
	public String getProduitNom() {
		return produitNom;
	}
	/**
	 * @param produit the produit to set
	 */
	public boolean setProduitNom(String produitNom) {
		if(produitNom == null || produitNom.isEmpty()) return false;
		this.produitNom = produitNom;
		return true;
	}

	public int getIdCommande() {
		return idCommande;
	}

	public boolean setIdCommande(int idCommande) {
		this.idCommande = idCommande;
		return true;
	}
	
	public Commande getCommande() {
		DaoCommande dao = new DaoCommande();
		return dao.getById(idCommande);
	}
	
	public boolean isDelivered(){
		return this.isDelivered;
	}
	
}
