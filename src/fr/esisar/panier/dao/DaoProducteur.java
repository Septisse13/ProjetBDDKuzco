package fr.esisar.panier.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.esisar.panier.connexionBDD.Connexion;
import fr.esisar.panier.metier.Producteur;
import fr.esisar.panier.metier.Produit;

public class DaoProducteur implements LoDaoPersonne<Producteur>, LoDao<Producteur> {

	@Override
	public List<Producteur> find(String conditions) {
		/*
		 * SELECT producteur.mail, nom, prenom FROM Producteur, Personne 
		 * WHERE producteur.mail=personne.mail
		 * AND (conditions);
		 */
		
		String requete = " SELECT producteur.mail, nom, prenom "
				+ "FROM Producteur, Personne"
				+ "WHERE producteur.mail=personne.mail"
				+ "AND "
				+ conditions
				+ ";";
		
		// Envoyer la requête
		Connection c1 = Connexion.getConnection();
		ResultSet resultats = null;
		try {
			Statement stmt = c1.createStatement();
			resultats = stmt.executeQuery(requete);
			c1.close();
		}
		catch(SQLException e){
			System.out.println("Erreur d'exÃ©cution requÃªte");
		}
		
		// Exploiter résultats : créer des objets producteurs pour chaque entrée et le mettre dans une liste
		List<Producteur> liste = new ArrayList<Producteur>();
		try {
			ResultSetMetaData rsmd = resultats.getMetaData();
			int nbCols = rsmd.getColumnCount();
			boolean encore = resultats.next();
			while (encore) {
				Producteur p = new Producteur(resultats.getString(1));
				liste.add(p);
				encore = resultats.next();
			}
			resultats.close();
			} 
		catch (SQLException e) {
			System.out.println("Erreur d'affichage de la requÃªte");
			}
		
		// Renvoyer List<Producteur>
		return liste;
	}

	@Override
	public boolean create(Producteur newRecord) {
		char bool;
		if(newRecord.isPaid()){
			bool='t';
		}
		else{
			bool='f';
		}
		
		/* INSERT INTO Personne VALUES (Producteur.getMail(), Producteur.getPrenom(), Producteur.getNom());
		 * INSERT INTO Producteur VALUES (Producteur.getMail(),Producteur.getOrdreCheque(), char);
		*/
		
		String requete_personne = "INSERT INTO Personne VALUES ('"
				+ newRecord.getMail()
				+"','"
				+ newRecord.getPrenom()
				+ "','"
				+ newRecord.getNom()
				+ "');";
		
		String requete_producteur = "INSERT INTO Producteur VALUES ('"
				+ newRecord.getMail()
				+"','"
				+ newRecord.getOrdreCheque()
				+ "','"
				+ bool
				+ "');";
		
		//Envoyer les requêtes
		Connection c1 = Connexion.getConnection();
		ResultSet resultats = null;
		try {
			Statement stmt = c1.createStatement();
			resultats = stmt.executeQuery(requete_personne);
			c1.close();
		}
		catch(SQLException e){
			System.out.println("Erreur d'exÃ©cution requÃªte");
			return false;
		}
		
		c1 = Connexion.getConnection();
		resultats = null;
		try {
			Statement stmt = c1.createStatement();
			resultats = stmt.executeQuery(requete_personne);
			c1.close();
		}
		catch(SQLException e){
			System.out.println("Erreur d'exÃ©cution requÃªte");
			return false;
		}

		return true;
	}

	@Override
	public boolean update(Producteur updateRecord) {
		/* UPDATE Producteur SET ordreCheque=Producteur.getOrdreCheque()
		 * WHERE Producteur.mail=Producteur.getMail();
		 */
		
		String requete = "UPDATE Producteur SET ordreCheque='"
				+ updateRecord.getOrdreCheque()
				+ "' WHERE Producteur.mail='"
				+ updateRecord.getMail()
				+ "';";
		
		
		// Envoyer la requête
		Connection c1 = Connexion.getConnection();
		ResultSet resultats = null;
		try {
			Statement stmt = c1.createStatement();
			resultats = stmt.executeQuery(requete);
			c1.close();
		}
		catch(SQLException e){
			System.out.println("Erreur d'exÃ©cution requÃªte");
			return false;
		}
		
		return true;
	}

	@Override
	public boolean remove(Producteur removeRecord) {
		/*
		 * DELETE FROM Producteur WHERE Producteur.mail=Producteur.getMail();
		 */
		
		String requete = "DELETE FROM Producteur WHERE Producteur.mail='"
				+ removeRecord.getMail()
				+ "';";
				
		
		//Envoyer la requête
		Connection c1 = Connexion.getConnection();
		ResultSet resultats = null;
		try {
			Statement stmt = c1.createStatement();
			resultats = stmt.executeQuery(requete);
			c1.close();
		}
		catch(SQLException e){
			System.out.println("Erreur d'exÃ©cution requÃªte");
			return false;
		}

		return true;
	}

	@Override
	public Producteur getByMail(String mail) {
		List<Producteur> liste;
		liste=find("Producteur.mail='"+mail+"'");
		
		// Envoyer la requête -> find le fait
		// Exploiter résultat -> find le fait
		// Renvoyer List<Producteur>
		return liste.get(1);
	}
	
	
	public Producteur getByProduit(Produit produit) {
		List<Producteur> liste;
		liste=find("Producteur.mail='"+produit.getProducteur()+"'");
		
		// Envoyer la requête -> find le fait
		// Exploiter résultat -> find le fait
		// Renvoyer List<Producteur>
		return liste.get(1);
	}
	
	
	public List<Producteur> getByPaid(boolean paid) {
		char bool;
		if(paid){
			bool='t';
		}
		else{
			bool='f';
		}
		List<Producteur> liste;
		liste=find("Producteur.paiementProdBool='"+bool+"'");
		
		// Envoyer la requête -> find le fait
		// Exploiter résultat -> find le fait
		// Renvoyer List<Producteur>
		return liste;
		
	}

}
