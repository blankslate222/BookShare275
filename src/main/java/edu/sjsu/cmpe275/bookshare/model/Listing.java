package edu.sjsu.cmpe275.bookshare.model;

public class Listing {
	
	private int id;
	private String isbn;
	private String isNegotiable;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getIsNegotiable() {
		return isNegotiable;
	}

	public void setIsNegotiable(String isNegotiable) {
		this.isNegotiable = isNegotiable;
	}

}
