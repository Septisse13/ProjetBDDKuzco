package fr.esisar.panier.connexionBDD;


import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class Connexion {

		private static Connection instance;
		
		
		public Connexion(){
			
		}
		
		public static Connection getConnection(){
			if(instance == null) {
				try{
					Class.forName(ConstantesDB.getDriver());
				} catch(ClassNotFoundException e) {
					System.out.println("Impossible De charger le pilote");
				}
				
				try { 
					instance = DriverManager.getConnection(ConstantesDB.getUrl(), ConstantesDB.getUserName(), ConstantesDB.getPassWord());
				} catch(SQLException e) {
					System.out.println("Impossible de se connecter � la base ");
				}
			}
			return instance;
		}
		
		
		/* Rajouter une méthode pour la déconnexion */
		
	
}
