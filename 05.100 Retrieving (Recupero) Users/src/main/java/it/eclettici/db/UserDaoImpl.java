package it.eclettici.db;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

	@Override
	public void save(User u) {
		var conn = Database.instance().getConnection();
		
		try {
			var stmt = conn.prepareStatement("insert into user (name) values (?)");
			
			stmt.setString(1, u.getName());
			
			/*
			 * E' stato provato da j.p. stmt.executeQuery() 
			 * ma qui necessito di stmt.executeUpdate()
			 * la stmt.executeQuery() la utilizzo per una select ad
			 * esempio; in questo caso aggiorno la tabella
			 * */
			stmt.executeUpdate();
			
			stmt.close();
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Optional<User> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getall() {
		List<User> users = new ArrayList<>();
		
		var conn = Database.instance().getConnection();
		
		try {
			var stmt = conn.createStatement();
						
			var rs = stmt.executeQuery("SELECT id,name FROM user");
			
			while(rs.next()) {
				var id = rs.getInt("id");
				var name = rs.getString("name");
				
				users.add(new User(id,name));
			}
			
			stmt.close();
		} catch (SQLException e) {
			throw new DaoException(e);
		}		
		
		return users;
	}

}
