package fr.esisar.panier.metier;

public class BDE extends Personne {

	private BDE() {
		super(null,null,null);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param mail
	 * @param nom
	 * @param prenom
	 */
	public BDE(String mail, String nom, String prenom) {
		super(mail, nom, prenom);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param mail
	 */
	public BDE(String mail) {
		super(mail);
		// TODO Auto-generated constructor stub
	}

}
