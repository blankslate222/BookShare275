package edu.sjsu.cmpe275.bookshare.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Criteria;

import edu.sjsu.cmpe275.bookshare.dao.UserDao;
import edu.sjsu.cmpe275.bookshare.model.Listing;
import edu.sjsu.cmpe275.bookshare.model.User;

public class UserDaoImpl implements UserDao {
	
	private SessionFactory sessionFactory;

	
	private DataSource dataSource;
	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void createUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		int insert = 0;

		String sql = "insert into user"
				+ "(email, password, firstname, lastname,address)"
				+ " values(?,?,?,?,?)";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		ps.setString(1, user.getEmail());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getFirstname());
		ps.setString(4, user.getLastname());
		ps.setString(5, user.getAddress());
	
		insert = ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		int rowid = 0;
		if (rs.next()) {
			System.out.println(rs.toString());
			rowid = rs.getInt(1);
		}
		try {
			ps.close();
			conn.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}

	public User getUserByEmail(String email) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet data = null;
		String sql = "select * from user where email=?";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, email);
		
		
		data = ps.executeQuery();
	
		User user = new User();
		if(data.next())
		{
			user.setEmail(data.getString("email"));
			user.setPassword(data.getString("pasword"));
			user.setFirstname(data.getString("firstname"));
			user.setLastname(data.getString("lastname"));
			user.setAddress(data.getString("address"));
			
		}
		
		/*int rowid = 0;
		if (rs.next()) {
			System.out.println(rs.toString());
			rowid = rs.getInt(1);
		}*/
		try {
			ps.close();
			conn.close();
			data.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (user);
		
	}
	public User getUserById(int id) throws SQLException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet data = null;
		String sql = "select * from user where id=?";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		
		
		data = ps.executeQuery();
	
		User user = new User();
		if(data.next())
		{
			user.setEmail(data.getString("email"));
			user.setPassword(data.getString("pasword"));
			user.setFirstname(data.getString("firstname"));
			user.setLastname(data.getString("lastname"));
			user.setAddress(data.getString("address"));
			
		}
		
		/*int rowid = 0;
		if (rs.next()) {
			System.out.println(rs.toString());
			rowid = rs.getInt(1);
		}*/
		try {
			ps.close();
			conn.close();
			data.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return (user);
		
		
	}
	
	public void deleteUser(int id) throws SQLException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		int rowsAffected =0;
		String sql = "delete from user where id=?";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		
		
		rowsAffected = ps.executeUpdate();
		
		
		return;
	}
	
	@Transactional
    public void createUserhbm(User user){
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}
	
}
