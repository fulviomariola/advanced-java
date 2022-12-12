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
		
		
		UserDao userDao = new UserDaoImpl();
		
		
		//userDao.save(new User("Mars"));
		//userDao.save(new User("Mr. Hyde"));
		
		var users = userDao.getall();
		
		users.forEach(System.out::println);
		
		var userOpt = userDao.findById(12);
		
		if(userOpt.isPresent()) {
			System.out.println("Utente recuperato:\n" + userOpt.get());
		} else {
			System.out.println("L'utente non è presente");
		}
			
		try {
			db.disconnect();
		} catch (SQLException e) {
			System.out.println("Disconnesso dal database");
		}
	}
}
