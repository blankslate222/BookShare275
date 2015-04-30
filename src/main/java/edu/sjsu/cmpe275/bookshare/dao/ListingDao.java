package edu.sjsu.cmpe275.bookshare.dao;

import java.sql.SQLException;

import edu.sjsu.cmpe275.bookshare.model.Listing;

public interface ListingDao {

	// when the user decides to list a book in the marketplace
	public int insert(Listing listing) throws SQLException;

	public Listing getListingById(int id) throws SQLException;
	
	// after book is sold remove from database
	public void removeListingById(int id) throws SQLException;

}
