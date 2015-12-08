package fr.esisar.panier.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.esisar.panier.connexionBDD.Connexion;
import fr.esisar.panier.metier.Produit;

public class DaoProduit implements LoDao<Produit> {

	@Override
	public List<Produit> find(String conditions) {
		/*
		 * SELECT nomProduit FROM Produit 
		 * WHERE (conditions);
		 */
		
		String requete = " SELECT nomProduit "
				+ "FROM Produit"
				+ "WHERE "
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
		
		// Exploiter résultats : créer des objets produits pour chaque entrée et le mettre dans une liste
		List<Produit> liste = new ArrayList<Produit>();
		try {
			ResultSetMetaData rsmd = resultats.getMetaData();
			boolean encore = resultats.next();
			while (encore) {
				Produit p = new Produit(resultats.getString(1));
				liste.add(p);
				encore = resultats.next();
			}
			resultats.close();
			} 
		catch (SQLException e) {
			System.out.println("Erreur d'affichage de la requÃªte");
			}
		
		// Renvoyer List<Produit>
		return liste;
	}

	@Override
	public boolean create(Produit newRecord) {
		String requete = "INSERT INTO Produit VALUES ('"
				+ newRecord.getNom()
				+"','"
				+ newRecord.getProducteur()
				+ "',"
				+ newRecord.getPrix()
				+ ");";
		
		//Envoyer les requêtes
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
	public boolean update(Produit updateRecord) {
		/* UPDATE Produit SET prix=UpdateRecord.getPrix AND producteur=updateRecord.getProducteur
		 * WHERE Produit.nom=updateRecord.getnom();
		 */
		
		String requete = "UPDATE Produit SET prixUnitaire="
				+ updateRecord.getPrix()
				+ "AND mail='"
				+ updateRecord.getProducteur()
				+ "' WHERE Produit.nomProduit='"
				+ updateRecord.getNom()
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
	public boolean remove(Produit removeRecord) {
		/*
		 * DELETE FROM Produit WHERE Produit.nomProduit=Produit.getNom();
		 */
		
		String requete = "DELETE FROM Produit WHERE Produit.nomProduit='"
				+ removeRecord.getNom()
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
	
	Produit getByNom(String nom){
		List<Produit> liste;
		liste=find("nomProduit='"+nom+"'");
		return liste.get(1);
	}
	
	List<Produit> getByPrix(float prix){
		List<Produit> liste;
		liste=find("prixUnitaire="+prix);
		return liste;
	}

}
