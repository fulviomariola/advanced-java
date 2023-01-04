package app;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Repository<T> {
	public void save(T t) {
		
		var clazz = t.getClass();
		var classAnnotations = clazz.getAnnotationsByType(Entity.class);
		
		// il nome della tabella della insert into
		var tableName = clazz.getSimpleName().toLowerCase();
		 
		if(classAnnotations.length > 0 && classAnnotations[0].value().length() > 0) {
			tableName = classAnnotations[0].value();
		}
				
		var fields = clazz.getDeclaredFields();
		
		ArrayList<String> fieldList = new ArrayList<>();
		
		for(var field: fields) {
			var annotations = field.getAnnotationsByType(Field.class);
			
			// se è 0 significa che non ci sono annotations
			if(annotations.length == 0) {
				continue;
			}
			
			var annotation = annotations[0];
			
			var fieldName = annotation.columnName();
			var isKey = annotation.isKey();
			
			if(fieldName.length() == 0) {
				fieldName = field.getName();
			}
			
			if(!isKey) {
				fieldList.add(fieldName);
			}
		}
		
		// il nome dei campi name,password della insert into
		String sqlFields = fieldList.stream().collect(Collectors.joining(","));
		
		// i valori che verranno inseriti ( ?,? ) della insert into
		String sqlPlaceholders = fieldList.stream().map(s -> "?").collect(Collectors.joining(","));
		
		// preparazione del Prepared Statement della insert into
		String sql = String.format("insert into %s (%s) values (%s)",  tableName, sqlFields, sqlPlaceholders);
		
		System.out.println(sql);

		
	}
}
