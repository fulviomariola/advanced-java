package app;

public class App {
	public static void main(String[] args) {
		User user = new User(0L, "Thor");
		
		var rep = new Repository<User>();
		
		rep.save(user);
	}
}
