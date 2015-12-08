package fr.esisar.panier.metier;

public class Producteur extends Personne {
	private String ordreCheque;
	private boolean paid;
	
	/**
	 * @param mail
	 * @param nom
	 * @param prenom
	 */
	public Producteur(String mail, String nom, String prenom) {
		super(mail, nom, prenom);
		// TODO Auto-generated constructor stub
	}

	public Producteur(String mail) {
		super(mail);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the ordreCheque
	 */
	public String getOrdreCheque() {
		return ordreCheque;
	}

	/**
	 * @param ordreCheque the ordreCheque to set
	 */
	public boolean setOrdreCheque(String ordreCheque) {
		if(ordreCheque == null || ordreCheque.isEmpty()) return false;
		this.ordreCheque = ordreCheque;
		return true;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

}
