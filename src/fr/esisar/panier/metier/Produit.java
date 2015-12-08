package fr.esisar.panier.metier;

import fr.esisar.panier.dao.DaoProducteur;

public class Produit {
	private String nom;
	private float prix;
	private String producteurMail;
	
	/**
	 * 
	 */
	private Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param nom
	 */
	public Produit(String nom) {
		super();
		this.nom = nom;
	}
	/**
	 * @param nom
	 * @param prix
	 */
	public Produit(String nom, float prix) {
		super();
		this.nom = nom;
		this.prix = prix;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public boolean setNom(String nom) {
		if(nom == null || nom.isEmpty()) return false;
		this.nom = nom;
		return true;
	}
	/**
	 * @return the prix
	 */
	public float getPrix() {
		return prix;
	}
	/**
	 * @param prix the prix to set
	 */
	public boolean setPrix(float prix) {
		if(prix <= 0 || prix > 10000) return false;
		this.prix = prix;
		return true;
	}
	
	public String getProducteurMail() {
		return producteurMail;
	}
	
	public Producteur getProducteur() {
		DaoProducteur dao = new DaoProducteur();
		return dao.getByProduit(this);
	}
	
	public boolean setProducteurMail(String producteurMail) {
		if(producteurMail == null || producteurMail.isEmpty()) return false;
		this.producteurMail = producteurMail;
		return true;
	}
}
