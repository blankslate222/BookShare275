package edu.sjsu.cmpe275.bookshare.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sjsu.cmpe275.bookshare.dao.OrderDao;
import edu.sjsu.cmpe275.bookshare.model.Book;
import edu.sjsu.cmpe275.bookshare.model.Order;

public class OrderDaoImpl implements OrderDao {

	@Autowired
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	public int insert(Order order) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		int insert = 0;

		String sql = "insert into orderBook"
				+ "(buyer, seller, feedback, rating, orderDate, bookIsbn, price) "
				+ " values(?,?,?,?,?,?,?)";
		
		Calendar c = Calendar.getInstance();
		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, (order.getBuyer()));
		ps.setString(2, (order.getSeller()));
		ps.setString(3, order.getFeedback());
		ps.setInt(4, order.getRating());
		ps.setTimestamp(5, new Timestamp(order.getOrderDate().getTimeInMillis()));
		ps.setString(6,  order.getIsbn());
		ps.setString(7,  order.getPrice());
		
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

		return (rowid);
	}

	
	public Order getOrderById(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet data = null;
		String sql = "select * from orderBook where id=?";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setInt(1,id);
		
		
		data = ps.executeQuery();
		Order newOrder = new Order();
		Calendar c = Calendar.getInstance();
		if(data.next())
		{
			newOrder.setBuyer((data.getString("buyer")));
			newOrder.setSeller((data.getString("seller")));
			newOrder.setFeedback(data.getString("feedback"));
			newOrder.setRating(data.getInt("rating"));
			c.setTime(data.getDate("orderDate"));
			newOrder.setIsbn(data.getString("bookIsbn"));
			newOrder.setPrice(data.getString("price"));
			newOrder.setOrderDate(c);			
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
		
		return (newOrder);
		
		
	}
	public List<Order> getOrderBySeller(String seller) throws SQLException {
		String sql = "select * from book where seller=?";
		return getOrderByUser(seller, sql);		
	}
	
	public List<Order> getOrderByBuyer(String buyer) throws SQLException {
		String sql = "select * from book where buyer=?";
		return getOrderByUser(buyer, sql);		
	}
	
	private List<Order> getOrderByUser(String user, String sql) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet data = null;

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1,user);
		
		
		data = ps.executeQuery();
		List<Order> orderList = new ArrayList<Order>();
		Calendar c = Calendar.getInstance();
		while(data.next())
		{
			Order newOrder = new Order();
			newOrder.setBuyer((data.getString("buyer")));
			newOrder.setSeller((data.getString("seller")));
			newOrder.setFeedback(data.getString("feedback"));
			newOrder.setRating(data.getInt("rating"));
			c.setTime(data.getDate("orderDate"));
			newOrder.setOrderDate(c);
			newOrder.setIsbn(data.getString("bookIsbn"));
			newOrder.setPrice(data.getString("price"));
			
			orderList.add(newOrder);
			
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
		
		return (orderList);
		
		
	}
	
	public void deleteOrderById(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "DELETE from orderBook where id=?";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		
	}

}
