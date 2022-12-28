package app;

import java.util.Arrays;
import java.util.Date;

class User {
	public int id;
}

class Employee extends User {
	public String name;
	private String passwd;
	
	private boolean setUpdate(int sequnce) {
		return true;
	}
	
}

public class App {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		
		Class<Employee> clazz = Employee.class;
		
		var nameField = clazz.getDeclaredField("name");
		
		var nameFieldAll = clazz.getDeclaredField("passwd");
		
		System.out.println(nameField);
		
		System.out.println(nameFieldAll);
		
		var setUpdateMethod = clazz.getDeclaredMethod("setUpdate", int.class);
		
		System.out.println(setUpdateMethod);
		
		var methodExist = Arrays.stream(clazz.getDeclaredMethods()).anyMatch(m -> m.getName().equals("setUpdate"));
		
		System.out.println(methodExist);

	}
}
