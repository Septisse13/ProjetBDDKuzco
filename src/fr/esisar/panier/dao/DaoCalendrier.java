package fr.esisar.panier.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import fr.esisar.panier.connexionBDD.Connexion;
import fr.esisar.panier.metier.Calendrier;
import fr.esisar.panier.metier.Ferie;
import fr.esisar.panier.metier.Livraison;

public class DaoCalendrier implements LoDao<Calendrier> {

	@Override
	public List<Calendrier> find(String conditions) {
		
		String requete = " SELECT begin, end "
				+ "FROM Calendrier"
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
			System.out.println("Erreur d'exécution requête");
		}
		
		// Exploiter résultats : créer des objets produits pour chaque entrée et le mettre dans une liste
		List<Calendrier> liste = new ArrayList<Calendrier>();
		try {
			ResultSetMetaData rsmd = resultats.getMetaData();
			boolean encore = resultats.next();
			while (encore) {
				String s = resultats.getString(1);
				DateFormat sdf = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
				Date d = new Date();
				try {
					d=sdf.parse(s);
				} catch (ParseException e) {
				}
				
				String s2 = resultats.getString(2);
				sdf = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
				Date d2 = new Date();
				try {
					d2=sdf.parse(s);
				} catch (ParseException e) {
				}
				Calendrier c = new Calendrier(d,d2);
				liste.add(c);
				encore = resultats.next();
				c.setLivraisons(DaoFerie.getByCalendrier(c));
				c.setFerie(DaoFerie.getByCalendrier(c));
			}
			resultats.close();
			} 
		catch (SQLException e) {
			System.out.println("Erreur d'affichage de la requête");
			}
		
		return liste;
	}


	@Override
	public boolean create(Calendrier newRecord) {
		String requete = "INSERT INTO Calendrier VALUES ('"
				+ newRecord.getBegin()
				+"','"
				+ newRecord.getEnd()
				+ "',"
				+ newRecord.getDateLimPaiementConso()
				+"','"
				+ newRecord.getDateLimPaiementProd()
				+"','"
				+ newRecord.getDateLimCom()
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
			System.out.println("Erreur d'exécution requête");
			return false;
		}
		
		return true;
	}

	@Override
	public boolean update(Calendrier updateRecord) {
		
		String requete = "UPDATE Calendrier SET end="
				+ updateRecord.getEnd()
				+ "AND DateLimPaiementConso='"
				+ updateRecord.getDateLimPaiementConso()
				+ "AND DateLimPaiementProd='"
				+ updateRecord.getDateLimPaiementProd()
				+ "AND DateLimCom='"
				+ updateRecord.getDateLimCom()
				+ "' WHERE Calendrier.begin='"
				+ updateRecord.getBegin()
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
			System.out.println("Erreur d'exécution requête");
			return false;
		}
		
		return true;
	}

	@Override
	public boolean remove(Calendrier removeRecord) {
		
		String requete = "DELETE FROM Calendrier WHERE Calendrier.begin='"
				+ removeRecord.getBegin()
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
			System.out.println("Erreur d'exécution requête");
			return false;
		}

		return true;
	}
	
	public Calendrier getByLivraison(Livraison livraison) {
		List<Calendrier> liste;
		liste=find("begin='"+livraison+"'");
		return liste.get(1);
	}
	
	public Calendrier getByFerie(Ferie ferie) {
		List<Calendrier> liste;
		liste=find("begin='"+ferie+"'");
		return liste.get(1);
	}
	
}