package edu.sjsu.cmpe275.bookshare.dao;

import java.sql.SQLException;

import edu.sjsu.cmpe275.bookshare.model.User;

public interface UserDao {

	// intentionally given a different name - to help
	// aop join point definitions
	public void createUser(User user) throws SQLException;

	public User getUserByEmail(String email) throws SQLException;
	// added getuserbyid and del-(anirudh)
	public User getUserById(int id) throws SQLException;
	
	public void deleteUser(int id) throws SQLException;
     
	public void createUserhbm(User user);
	
}
