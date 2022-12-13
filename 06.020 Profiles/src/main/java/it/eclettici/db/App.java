package it.eclettici.db;

import java.sql.SQLException;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Properties props = new Properties();
		
		String env = System.getProperty("env");
		
		if (env==null) {
			env = "dev";
		}
		
		String propsFile = String.format("/config/db.%s.properties", env);
		
		System.out.println(propsFile);
		
		try {
			props.load(App.class.getResourceAsStream(propsFile));
		} /* catch (IOException e1) --> è un try automatico ma che trova errore 
		     solo se c'è un errore nella I/O ma in questo caso l'errore è del
		     database, con Exception rilevo un errore a livello generico
		  */ 
		  catch (Exception e1) {
			System.out.println("Cannot load properties file: " + propsFile);
			return;
		}
		
		// Connessione al DB
		var db = Database.instance();
		try {
			db.connect(props);
			System.out.println("Sei Connesso al database!!!");
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
