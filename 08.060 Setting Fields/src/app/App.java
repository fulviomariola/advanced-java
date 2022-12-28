package app;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Date;

class User {
	public int id;
}

class Employee extends User {
	private String name;
	private String passwd;
	
	private boolean setUpdate(int sequnce) {
		System.out.println("setUpdate: " + sequnce);
		return true;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", passwd=" + passwd + "]";
	}
	
	
	
}

public class App {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Class<Employee> clazz = Employee.class;
		
		var nameField = clazz.getDeclaredField("name");
		
		var user = new Employee();
			
		// il setAccessible(...) è eccezionale, permette di prendere i campi 
		// private in una altra classe
		nameField.setAccessible(true);
		nameField.set(user, "Poseidon");
		
		System.out.println(user);

	}
}
