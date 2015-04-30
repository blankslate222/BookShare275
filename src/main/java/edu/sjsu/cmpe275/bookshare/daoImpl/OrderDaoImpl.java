package edu.sjsu.cmpe275.bookshare.daoImpl;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sjsu.cmpe275.bookshare.dao.OrderDao;
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
		return 0;
	}

	
	public Order getOrderById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Order getOrderBySeller(String seller) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
