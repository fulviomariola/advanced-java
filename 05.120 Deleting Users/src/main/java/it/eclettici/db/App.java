package it.eclettici.db;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		// Connessione al DB
		var db = Database.instance();
		try {
			db.connect();
			System.out.println("Sei Connesso al database!!!");
		} catch (SQLException e) {
			System.out.println("Connessione al database non riuscita");
		}
		
		
		UserDao userDao = new UserDaoImpl();
		
		// Salvare nuovo utente
		//userDao.save(new User("Mars"));
		//userDao.save(new User("Mr. Hyde"));
		
		
		// Lista utente della tabella user
		var users = userDao.getall();
		users.forEach(System.out::println);
		
		
		// Recupera utente
		var userOpt = userDao.findById(12);
		if(userOpt.isPresent()) {
			System.out.println("Utente recuperato:\n" + userOpt.get());
		} else {
			System.out.println("L'utente non è presente");
		}
		
		
		// Cancellare utente
		userDao.delete(new User(0,null));
			
		try {
			db.disconnect();
		} catch (SQLException e) {
			System.out.println("Disconnesso dal database");
		}
	}
}
