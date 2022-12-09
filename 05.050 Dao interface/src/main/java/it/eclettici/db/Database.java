package it.eclettici.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	/*
	 * 
	 * */
	private static Database db = new Database();
	private static final String URL = "jdbc:mysql://localhost:3306/people";
	private Connection conn;
	private String user = "root";
	private String passwd = "fu76ro5";
	
	
	public static Database instance() {
		return db;
	}
	
	private Database() {
		/*
		 * per assicurarmi che il db sia singlaton ovvero che 
		 * viene utilizzato una sola volta
		 * */
	}
	
	public void connect() throws SQLException {		
		conn = DriverManager.getConnection(URL,user,passwd);
	}
	
	public void disconnect() throws SQLException {
		conn.close();
	} 
}
