package edu.sjsu.cmpe275.bookshare.dao;

import edu.sjsu.cmpe275.bookshare.model.Order;

public interface OrderDao {

	//return auto generated id value
	public int insert();

	public Order getOrderById(int id);

	public Order getOrderBySeller(String seller);

}
