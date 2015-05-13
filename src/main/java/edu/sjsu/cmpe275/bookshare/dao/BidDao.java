package edu.sjsu.cmpe275.bookshare.dao;

import java.sql.SQLException;
import java.util.List;

import edu.sjsu.cmpe275.bookshare.model.Bid;

public interface BidDao {

	public int insert(Bid bid) throws SQLException;

	public List<Bid> getBidByListingId(int listingId) throws SQLException;

	public Bid getBidByBidderEmail(String bidderEmail) throws SQLException;
	
	//remove all records after a book is ordered
	public void removeBidsByBookId(int listingId) throws SQLException;
	
}
