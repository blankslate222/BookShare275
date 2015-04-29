package edu.sjsu.cmpe275.bookshare.dao;

import edu.sjsu.cmpe275.bookshare.model.Bid;

public interface BidDao {

	public int insert();

	public Bid getBidByListingId(int listingId);

	public Bid getBidByBidderEmail(String bidderEmail);
	
	//remove all records after a book is ordered
	public void removeBidsByListingId(int listingId);
	
}
