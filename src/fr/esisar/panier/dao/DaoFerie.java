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
import fr.esisar.panier.metier.Ferie;
import fr.esisar.panier.metier.Livraison;

public class DaoFerie implements LoDao<Ferie> {

	@Override
	public List<Ferie> find(String conditions) {
		/*
		 * SELECT begin, end, calendrierBegin FROM Ferie 
		 * WHERE (conditions);
		 */
		
		String requete = "SELECT dateDebutFerie, dateFinFerie, dateDebutSemestre "
				+ "FROM Ferie"
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
		
		// Exploiter r�sultats : cr�er des objets Feries pour chaque entr�e et le mettre dans une liste
		List<Ferie> liste = new ArrayList<Ferie>();
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
				
				s = resultats.getString(2);
				sdf = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
				Date d2 = new Date();
				try {
					d2=sdf.parse(s);
				} catch (ParseException e) {
				}
				
				
				Ferie p = new Ferie(d,d2);
				liste.add(p);
				encore = resultats.next();
			}
			resultats.close();
			} 
		catch (SQLException e) {
			System.out.println("Erreur d'affichage de la requête");
			}
		
		// Renvoyer List<Ferie>
		return liste;
	}

	@Override
	public boolean create(Ferie newRecord) {
		String requete = "INSERT INTO Ferie VALUES ('"
				+ newRecord.getBegin()
				+"','"
				+ newRecord.getEnd()
				+ "','"
				+ newRecord.getCalendrierBegin()
				+ "');";
		
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
		
		return true;
	}


	@Override
	public boolean update(Ferie updateRecord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Ferie removeRecord) {
		String requete = "DELETE FROM Ferie WHERE Ferie.dateDebutFerie='"
				+ removeRecord.getBegin()
				+ "';";
				
		
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

}
