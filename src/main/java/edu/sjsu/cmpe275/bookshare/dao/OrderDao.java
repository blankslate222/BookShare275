package edu.sjsu.cmpe275.bookshare.dao;

import java.sql.SQLException;

import edu.sjsu.cmpe275.bookshare.model.Order;

public interface OrderDao {

	//return auto generated id value
	public int insert(Order order) throws SQLException;

	public Order getOrderById(int id) throws SQLException;

	public Order getOrderBySeller(String seller) throws SQLException;

}
