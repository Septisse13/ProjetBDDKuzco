package fr.esisar.panier.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
import fr.esisar.panier.metier.Commande;
=======
import fr.esisar.panier.connexionBDD.Connexion;
import fr.esisar.panier.metier.Consommateur;
import fr.esisar.panier.metier.Producteur;
import fr.esisar.panier.metier.Consommateur;
>>>>>>> origin/master
import fr.esisar.panier.metier.Consommateur;

public class DaoConsommateur implements LoDao<Consommateur>, LoDaoPersonne<Consommateur> {



	@Override
	public List<Consommateur> find(String conditions) {
		/*
		 * SELECT Consommateur.mail, nom, prenom FROM Consommateur, Personne 
		 * WHERE Consommateur.mail=personne.mail
		 * AND (conditions);
		 */
		
		String requete = " SELECT Consommateur.mail, nom, prenom "
				+ "FROM Consommateur, Personne"
				+ "WHERE Consommateur.mail=personne.mail"
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
		
		// Exploiter résultats : créer des objets Consommateurs pour chaque entrée et le mettre dans une liste
		List<Consommateur> liste = new ArrayList<Consommateur>();
		try {
			ResultSetMetaData rsmd = resultats.getMetaData();
			int nbCols = rsmd.getColumnCount();
			boolean encore = resultats.next();
			while (encore) {
				Consommateur p = new Consommateur(resultats.getString(1));
				liste.add(p);
				encore = resultats.next();
			}
			resultats.close();
			} 
		catch (SQLException e) {
			System.out.println("Erreur d'affichage de la requÃªte");
			}
		
		// Renvoyer List<Consommateur>
		return liste;
	}

	@Override
	public boolean create(Consommateur newRecord) {
		char bool;
		if(newRecord.isHavePaid()){
			bool='t';
		}
		else{
			bool='f';
		}
		
		/* INSERT INTO Personne VALUES (Consommateur.getMail(), Consommateur.getPrenom(), Consommateur.getNom());
		 * INSERT INTO Consommateur VALUES (Consommateur.getMail(),Consommateur.getOrdreCheque(), char);
		*/
		
		String requete_personne = "INSERT INTO Personne VALUES ('"
				+ newRecord.getMail()
				+"','"
				+ newRecord.getPrenom()
				+ "','"
				+ newRecord.getNom()
				+ "');";
		
		String requete_Consommateur = "INSERT INTO Consommateur VALUES ('"
				+ newRecord.getMail()
				+"','"
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
	public boolean update(Consommateur updateRecord) {
		char bool;
		if(updateRecord.isHavePaid()){
			bool='t';
		}
		else{
			bool='f';
		}
		
		String requete = "UPDATE Consommateur SET paiementConsoBool='"
				+ bool
				+ "' WHERE Consommateur.mail='"
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
	public boolean remove(Consommateur removeRecord) {
		/*
		 * DELETE FROM Consommateur WHERE Consommateur.mail=Consommateur.getMail();
		 */
		
		String requete = "DELETE FROM Consommateur WHERE Consommateur.mail='"
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
	

	public Consommateur getByMail(String mail) {
		List<Consommateur> liste;
		liste=find("Consommateur.mail='"+mail+"'");
		
		// Envoyer la requête -> find le fait
		// Exploiter résultat -> find le fait
		// Renvoyer List<Consommateur>
		return liste.get(1);
	}
	
	public Consommateur getByCommande(Commande commande) {
		return null;
		
	}

}
