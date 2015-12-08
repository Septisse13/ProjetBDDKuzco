package fr.esisar.panier.connexionBDD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {

		private  Connection instance;
		
		
		public Connexion(){
			
			try{Class.forName(ConstantesDB.getDriver());}
			catch(ClassNotFoundException e) {
				System.out.println("Impossible De charger le pilote");
			}
			
			try { instance = DriverManager.getConnection(ConstantesDB.getUrl(), ConstantesDB.getUserName(), ConstantesDB.getPassWord());}
			catch(SQLException e){
				System.out.println("Impossible de se connecter à la base ");
			}
			
		}
		public Connection getConnection(){
			return this.instance;
		}
		
		
		/* Rajouter une méthode pour la déconnexion */
		
	
}
