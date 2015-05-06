package edu.sjsu.cmpe275.bookshare.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.cmpe275.bookshare.daoImpl.BookDaoImpl;
import edu.sjsu.cmpe275.bookshare.daoImpl.ListingDaoImpl;
import edu.sjsu.cmpe275.bookshare.model.Book;
import edu.sjsu.cmpe275.bookshare.model.Listing;

@Service
public class BookService {

	@Autowired
	private BookDaoImpl bookDaoImpl;
	@Autowired
	private ListingDaoImpl listingDaoImpl;

	public BookDaoImpl getBookDaoImpl() {
		return bookDaoImpl;
	}

	public void setBookDaoImpl(BookDaoImpl bookDaoImpl) {
		this.bookDaoImpl = bookDaoImpl;
	}

	public ListingDaoImpl getListingDaoImpl() {
		return listingDaoImpl;
	}
	
	public void setListingDaoImpl(ListingDaoImpl listingDaoImpl) {
		this.listingDaoImpl = listingDaoImpl;
	}

	public void createBook(Book book) {
		try {
			System.out.println("in book service");
			Listing listing = new Listing();
			listing.setIsbn(book.getIsbn());
			listing.setIsNegotiable(book.getIsNegotiable());
			listing.setSeller(book.getUser());
			
			getBookDaoImpl().insert(book);
			
			getListingDaoImpl().insert(listing);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
public Book getBookById(int id) {
	Book book = null;
	try {
		book = getBookDaoImpl().getBookById(id);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return book;
}
	
}
