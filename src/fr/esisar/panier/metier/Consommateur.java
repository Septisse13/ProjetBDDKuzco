package fr.esisar.panier.metier;

public class Consommateur extends Personne{
	private boolean havePaid;

	/**
	 * @param mail
	 * @param nom
	 * @param prenom
	 */
	public Consommateur(String mail, String nom, String prenom) {
		super(mail, nom, prenom);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param mail
	 */
	public Consommateur(String mail) {
		super(mail);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the havePaid
	 */
	public boolean isHavePaid() {
		return havePaid;
	}

	/**
	 * @param havePaid the havePaid to set
	 */
	public void setHavePaid(boolean havePaid) {
		this.havePaid = havePaid;
	}
	
	
}
