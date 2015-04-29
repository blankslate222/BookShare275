package edu.sjsu.cmpe275.bookshare.dao;

import edu.sjsu.cmpe275.bookshare.model.Listing;

public interface ListingDao {

	// when the user decides to list a book in the marketplace
	public int insert();

	public Listing getListingById(int id);
	
	// after book is sold remove from database
	public void removeListingById(int id);

}
