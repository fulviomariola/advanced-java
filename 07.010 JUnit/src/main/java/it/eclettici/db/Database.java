package it.eclettici.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
	/*
	 * 
	 * */
	private static Database db = new Database();
	private Connection conn;
//	private static final String URL = "jdbc:mysql://localhost:3306/people";
//	private String user = "root";
//	private String passwd = "fu76ro5";
	
	
	public static Database instance() {
		return db;
	}
	
	private Database() {

	}

	public Connection getConnection() {
		return conn;
	}
	
	public void connect(Properties props) throws SQLException {
		String server = props.getProperty("server");
		String port = props.getProperty("port");
		String db = props.getProperty("database");
		String user = props.getProperty("user");
		String passwd = props.getProperty("password");
		
		String url = String.format("jdbc:mysql://%s:%s/%s", server, port, db);
		
		conn = DriverManager.getConnection(url,user,passwd);
	}
	
	public void disconnect() throws SQLException {
		conn.close();
	} 
}
