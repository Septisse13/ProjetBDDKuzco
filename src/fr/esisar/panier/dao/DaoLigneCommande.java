package fr.esisar.panier.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import fr.esisar.panier.connexionBDD.Connexion;
import fr.esisar.panier.metier.LigneCommande;
import fr.esisar.panier.metier.Livraison;
import fr.esisar.panier.metier.Produit;

public class DaoLigneCommande implements LoDao<LigneCommande> {

	@Override
	public List<LigneCommande> find(String conditions) {
		/*
		 * SELECT idLigneCommande, idCommande, nomProduit, quantite, isDelivered  FROM LigneCommande
		 * WHERE (conditions);
		 */
		
		String requete = " SELECT idLigneCommande, idCommande, nomProduit, quantite, isDelivered "
				+ "FROM LigneCommande"
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
		
		// Exploiter résultats : créer des objets Livraisons pour chaque entrée et le mettre dans une liste
		List<LigneCommande> liste = new ArrayList<LigneCommande>();
		try {
			ResultSetMetaData rsmd = resultats.getMetaData();
			boolean encore = resultats.next();
			while (encore) {
				String s1 = resultats.getString(1);
				
				String s2 = resultats.getString(2);
				
				String s3 = resultats.getString(3);
				Produit produit = new Produit(s3);
				String s4 = resultats.getString(4);
				
				String s5 = resultats.getString(5);
				boolean bool;
				if(s5.charAt(0)=='t'){
					bool=true;
				}
				else{
					bool=false;
				}
				
				LigneCommande p = new LigneCommande(Integer.parseInt(s1),Integer.parseInt(s2),produit,Integer.parseInt(s4),bool);
				liste.add(p);
				encore = resultats.next();
			}
			resultats.close();
			} 
		catch (SQLException e) {
			System.out.println("Erreur d'affichage de la requÃªte");
			}
		
		// Renvoyer List<Livraison>
		return liste;
	}

	@Override
	public boolean create(LigneCommande newRecord) {
		
		char bool;
		if(newRecord.isDelivered()){
			bool='t';
		}
		else{
			bool='f';
		}
		
		String requete = "INSERT INTO LigneCommande VALUES ("
				+ newRecord.getId()
				+","
				+ newRecord.getQuantite()
				+",'"
				+ newRecord.getProduit().getNom()
				+"',"
				+ newRecord.getIdCommande()
				+",'"
				+ bool
				+ "');";
		
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
	public boolean update(LigneCommande updateRecord) {
		
		char bool;
		if(updateRecord.isDelivered()){
			bool='t';
		}
		else{
			bool='f';
		}
		String requete = "UPDATE LigneCommande SET quantite="
				+ updateRecord.getQuantite()
				+ "AND nomProduit='"
				+ updateRecord.getProduit().getNom()
				+ "AND isDelivered='"
				+ bool
				+ "' WHERE LigneCommande.id="
				+ updateRecord.getId()
				+ " AND LigneCommande.idCommande="
				+ updateRecord.getIdCommande()
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
			return false;
		}
		
		return true;
	}

	@Override
	public boolean remove(LigneCommande removeRecord) {
		String requete = "DELETE FROM LigneCommande WHERE LigneCommande.id="
				+ removeRecord.getId()
				+ "AND LigneCommande.idCommande="
				+ removeRecord.getIdCommande()
				+ ";";
				
		
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

}
