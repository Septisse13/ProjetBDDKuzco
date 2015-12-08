package fr.esisar.panier.metier;

public class Personne {
	private String mail;
	private String nom;
	private String prenom;
	
	/**
	 * @param mail
	 * @param nom
	 * @param prenom
	 */
	public Personne(String mail, String nom, String prenom) {
		super();
		this.mail = mail;
		this.nom = nom;
		this.prenom = prenom;
	}
	/**
	 * @param mail
	 */
	public Personne(String mail) {
		super();
		this.mail = mail;
	}
	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * @param mail the mail to set
	 */
	public boolean setMail(String mail) {
		if(mail == null || mail.isEmpty()) return false;
		this.mail = mail;
		return false;
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
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public boolean setPrenom(String prenom) {
		if(prenom == null || prenom.isEmpty()) return false;
		this.prenom = prenom;
		return true;
	}
	
	
}
