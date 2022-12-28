package app;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Date;

class User {
	public int id;
}

class Employee extends User {
	public String name;
	private String passwd;
	
	private boolean setUpdate(int sequnce) {
		System.out.println("setUpdate: " + sequnce);
		return true;
	}
	
}

public class App {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Class<Employee> clazz = Employee.class;
		
		var nameField = clazz.getDeclaredField("name");
				
		System.out.println(nameField);
				
		var setUpdateMethod = clazz.getDeclaredMethod("setUpdate", int.class);
		// il metodo setUpdate lo ho reso private, con invoke non è accessibbile,
		// a meno che rendo setAccessible(true) e quindi adesso lo posso invocare
		setUpdateMethod.setAccessible(true);
		
		setUpdateMethod.invoke(new Employee(), 7);

	}
}
