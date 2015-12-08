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
import fr.esisar.panier.metier.Livraison;
import fr.esisar.panier.metier.Livraison;

public class DaoLivraison implements LoDao<Livraison> {

	@Override
	public List<Livraison> find(String conditions) {
		/*
		 * SELECT dateLivraison, dateDebutSemestre FROM Livraison
		 * WHERE (conditions);
		 */
		
		String requete = " SELECT dateLivraison, dateDebutSemestre "
				+ "FROM Livraison"
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
		List<Livraison> liste = new ArrayList<Livraison>();
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
				
				
				Livraison p = new Livraison(d,d2);
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
	public boolean create(Livraison newRecord) {
		String requete = "INSERT INTO Produit VALUES ("
				+ newRecord.getDateLivraison()
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
	public boolean update(Livraison updateRecord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Livraison removeRecord) {
		/*
		 * DELETE FROM Livraison WHERE Livraison.date=Livraison.getDate();
		 */
		
		String requete = "DELETE FROM Livraison WHERE Livraison.dateLivraison="
				+ removeRecord.getDateLivraison()
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
	
	// TODO getByDate(Date)
	public Livraison getByDate(String date){
		List<Livraison> liste;
		liste=find("dateLivraison="+date);
		return liste.get(1);
	}
	// TODO getByCalendrier
	public List<Livraison> getByCalendrier(String date){
		List<Livraison> liste;
		liste=find("dateDebutSemestre="+date);
		return liste;
	}

}
