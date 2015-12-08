package fr.esisar.panier.connexionBDD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Connection c1 = Connexion.getConnection();
		
		
		ResultSet resultats = null;
		String requete = "";
		
		requete = "SELECT * From Compte";
		try {
			Statement stmt = c1.createStatement();
			resultats = stmt.executeQuery(requete);
		}
		catch(SQLException e){
			System.out.println("Erreur d'exécution requête");
		}
		
		try {
			ResultSetMetaData rsmd = resultats.getMetaData();
			int nbCols = rsmd.getColumnCount();
			boolean encore = resultats.next();
			 
			while (encore) {
			
			for (int i = 1; i <= nbCols; i++)
			System.out.print(resultats.getString(i) + " ");
			System.out.println();
			encore = resultats.next();
			}
			 
			resultats.close();
			} 
		catch (SQLException e) {
			System.out.println("Erreur d'affichage de la requête");
			}
		}
}
