package fr.esisar.panier.connexionBDD;

public class ConstantesDB {
	private static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static String URL = "jdbc:oracle:thin:@tp-oracle.esisar.grenoble-inp.fr:1521/XE";
	private static String USERNAME = "quatrea";
	private static String PASSWORD = "nutella";
	
	public static String getDriver() {
		return DRIVER;
	}
	
	public static String getUrl() {
		return URL;
	}
	
	public static String getUserName() {
		return USERNAME;
	}
	
	public static String getPassWord() {
		return PASSWORD;
	}
}
