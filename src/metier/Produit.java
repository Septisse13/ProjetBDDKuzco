package metier;

public class Produit {
	private String nom;
	private float prix;
	
	
	
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
		this.nom = nom;
		return false;
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
		this.prix = prix;
		return false;
	}
	
	
}
