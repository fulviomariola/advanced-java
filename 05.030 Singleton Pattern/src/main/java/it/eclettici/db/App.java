package it.eclettici.db;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		var db = Database.instance();
		
		try {
			db.connect();
			System.out.println("Sei Connesso al database!!!");
		} catch (SQLException e) {
			System.out.println("Connessione al database non riuscita");
		}
		
		
		
		try {
			db.disconnect();
		} catch (SQLException e) {
			System.out.println("Disconnessione database");
		}
	}
}
