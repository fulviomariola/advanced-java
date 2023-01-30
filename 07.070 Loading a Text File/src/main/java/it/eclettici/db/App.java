package it.eclettici.db;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		var props = Profile.getProperties("db");

		// Connessione al DB
		var db = Database.instance();
		try {
			db.connect(props);
			System.out.println("Sei Connesso al database");
			//return;
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
		var userOpt = userDao.findById(3);
		if(userOpt.isPresent()) {
			User user = userOpt.get();
			
			//System.out.println("Utente recuperato:\n" + user.getName() + "\nCon id:\n" + user.getId());
			System.out.println("Utente recuperato:  " + user);
			
			// Update utente
			user.setName("Habel");
			userDao.update(user);
		} else {
			System.out.println("L'utente non è presente");
		}

		
		// Cancellare utente
		//userDao.delete(new User(0,null));
			
		try {
			db.disconnect();
		} catch (SQLException e) {
			System.out.println("Disconnesso dal database");
		}
	}
}
