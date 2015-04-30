package edu.sjsu.cmpe275.bookshare.dao;

import java.sql.SQLException;

import edu.sjsu.cmpe275.bookshare.model.Bid;

public interface BidDao {

	public int insert(Bid bid) throws SQLException;

	public Bid getBidByListingId(int listingId) throws SQLException;

	public Bid getBidByBidderEmail(String bidderEmail) throws SQLException;
	
	//remove all records after a book is ordered
	public void removeBidsByListingId(int listingId) throws SQLException;
	
}
