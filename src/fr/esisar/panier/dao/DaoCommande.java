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
import fr.esisar.panier.metier.Commande;
import fr.esisar.panier.metier.Livraison;

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
			System.out.println("Erreur d'affichage de la requÃªte");
			}
		
		// Renvoyer List<Livraison>
		return liste;
	}

	@Override
	public boolean create(Commande newRecord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Commande updateRecord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Commande removeRecord) {
		// TODO Auto-generated method stub
		return false;
	}

	public Commande getById(int idCommande) {
		// TODO Auto-generated method stub
		return null;
	}

}
