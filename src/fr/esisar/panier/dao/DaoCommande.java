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
import java.util.Map;
import java.util.Map.Entry;

import fr.esisar.panier.connexionBDD.Connexion;
import fr.esisar.panier.metier.Commande;
import fr.esisar.panier.metier.Consommateur;
import fr.esisar.panier.metier.LigneCommande;
import fr.esisar.panier.metier.Livraison;
import fr.esisar.panier.metier.Produit;

public class DaoCommande implements LoDao<Commande> {

	@Override
	public List<Commande> find(String conditions) {
		/*
		 * SELECT idCommande, mail, dateDebutSemestre, dateLivraison FROM Commande
		 * WHERE (conditions);
		 */
		
		String requete = " idCommande, mail, dateDebutSemestre, dateLivraison "
				+ "FROM Livraison"
				+ "WHERE "
				+ conditions
				+ ";";
		
		// Envoyer la requ�te
		Connection c1 = Connexion.getConnection();
		ResultSet resultats = null;
		try {
			Statement stmt = c1.createStatement();
			resultats = stmt.executeQuery(requete);
			c1.close();
		}
		catch(SQLException e){
			System.out.println("Erreur d'exécution requête");
		}
		
		// Exploiter r�sultats : cr�er des objets Livraisons pour chaque entr�e et le mettre dans une liste
		List<Commande> liste = new ArrayList<Commande>();
		try {
			ResultSetMetaData rsmd = resultats.getMetaData();
			boolean encore = resultats.next();
			while (encore) {
				String s1 = resultats.getString(1);
				
				String s2 = resultats.getString(2);
				
				String s3 = resultats.getString(3);
				DateFormat sdf = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
				Date d = new Date();
				try {
					d=sdf.parse(s3);
				} catch (ParseException e) {
				}
				
				String s4 = resultats.getString(4);
				sdf = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
				Date d2 = new Date();
				try {
					d2=sdf.parse(s4);
				} catch (ParseException e) {
				}
				
				
				Commande p = new Commande();
				p.setId(Integer.parseInt(s1));
				
				liste.add(p);
				encore = resultats.next();
			}
			resultats.close();
			} 
		catch (SQLException e) {
			System.out.println("Erreur d'affichage de la requête");
			}
		
		// Renvoyer List<Livraison>
		return liste;
	}

	@Override
	public boolean create(Commande newRecord) {
			String requete = "INSERT INTO Commande VALUES ("
					+ newRecord.getId()
					+",'"
					+ newRecord.getMailConso()
					+ "',"
					+ newRecord.getLivraison().getCalendierBegin()
					+","
					+ newRecord.getLivraison().getDateLivraison()
					+ ");";
			
			//Envoyer les requ�tes
			Connection c1 = Connexion.getConnection();
			ResultSet resultats = null;
			try {
				Statement stmt = c1.createStatement();
				resultats = stmt.executeQuery(requete);
				c1.close();
			}
			catch(SQLException e){
				System.out.println("Erreur d'exécution requête");
				return false;
			}
			
			for(Map.Entry<Integer, LigneCommande> entry : newRecord.getMap().entrySet()){
															
				DaoLigneCommande dao = new DaoLigneCommande();
				dao.create(entry.getValue());
			}
			
			
			return true;
		}

	@Override
	public boolean update(Commande updateRecord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Commande removeRecord) {
		// TODO Auto-generated method stub
		
		
		
		for(Map.Entry<Integer, LigneCommande> entry : removeRecord.getMap().entrySet()){
			
			DaoLigneCommande dao = new DaoLigneCommande();
			dao.remove(entry.getValue());
		}
		String requete = "DELETE FROM Commande WHERE Commande.idCommande="
				+ removeRecord.getId()
				+ ";";
				
		
		//Envoyer la requ�te
		Connection c1 = Connexion.getConnection();
		ResultSet resultats = null;
		try {
			Statement stmt = c1.createStatement();
			resultats = stmt.executeQuery(requete);
			c1.close();
		}
		catch(SQLException e){
			System.out.println("Erreur d'exécution requête");
			return false;
		}

		return true;
	}

	public Commande getById(int idCommande) {
		List<Commande> liste;
		liste=find("idCommande="+idCommande);
		return liste.get(1);
	}
	
	public List<Commande> getByConsommateur(Consommateur consommateur) {
		List<Commande> liste;
		liste=find("mail="+consommateur.getMail());
		return liste;
	}

}
