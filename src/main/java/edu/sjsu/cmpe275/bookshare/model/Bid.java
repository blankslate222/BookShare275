package edu.sjsu.cmpe275.bookshare.model;

import java.util.Calendar;

public class Bid {

	private int id;
	private int bookId;
	private String bidderEmail;
	private String offerPrice;
	private Calendar bidTime;
	private String seller;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBidderEmail() {
		return bidderEmail;
	}
	public void setBidderEmail(String bidderEmail) {
		this.bidderEmail = bidderEmail;
	}
	public String getOfferPrice() {
		return offerPrice;
	}
	public void setOfferPrice(String offerPrice) {
		this.offerPrice = offerPrice;
	}
	public Calendar getBidTime() {
		return bidTime;
	}
	public void setBidTime(Calendar bidTime) {
		this.bidTime = bidTime;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	} 
}
