package edu.sjsu.cmpe275.bookshare.daoImpl;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sjsu.cmpe275.bookshare.dao.UserDao;
import edu.sjsu.cmpe275.bookshare.model.User;

public class UserDaoImpl implements UserDao {

	@Autowired
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void createUser(User user) throws SQLException {
		// TODO Auto-generated method stub

	}

	public User getUserByEmail(String email) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
