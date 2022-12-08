package application;

import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// ids più id
		// names più name
		int[] ids = {0,1,2};
		String[] names = {"Suellen	","Bobby","Carlo"};
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String dbURL = "jdbc:mysql://localhost:3306/people";
		
		var conn = DriverManager.getConnection(dbURL,"root","fu76ro5");
		
		var stmt = conn.createStatement();
		conn.setAutoCommit(false);
		
		// invece di inserire stringhe songoli, inserisco i ? ? O   
		var sql = "insert into user (id,name) values (?,?)";
		var insertStmt = conn.prepareStatement(sql);
		
		for (int i=0;i<ids.length;i++) {
			insertStmt.setInt(1,ids[i]);
			insertStmt.setString(2, names[i]);
			
			//insertStmt.executeUpdate();
		}
		
		conn.commit();
		
		insertStmt.close();
		
		sql = "select id, name from user";
		var rs = stmt.executeQuery(sql);

		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			
			System.out.println(id + ": " + name);
		}
		
 
		
		stmt.close();
		
		conn.close();
	}

}
