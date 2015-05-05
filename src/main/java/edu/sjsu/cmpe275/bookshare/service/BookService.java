package edu.sjsu.cmpe275.bookshare.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.cmpe275.bookshare.daoImpl.BookDaoImpl;
import edu.sjsu.cmpe275.bookshare.daoImpl.ListingDaoImpl;
import edu.sjsu.cmpe275.bookshare.daoImpl.OrderDaoImpl;
import edu.sjsu.cmpe275.bookshare.model.Book;
import edu.sjsu.cmpe275.bookshare.model.Order;

@Service
public class BookService {

	private BookDaoImpl bookDaoImpl;
	private ListingDaoImpl listingDaoImpl;

	public BookDaoImpl getBookDaoImpl() {
		return bookDaoImpl;
	}

	@Autowired
	public void setBookDaoImpl(BookDaoImpl bookDaoImpl) {
		this.bookDaoImpl = bookDaoImpl;
	}

	public ListingDaoImpl getListingDaoImpl() {
		return listingDaoImpl;
	}

	@Autowired
	public void setListingDaoImpl(ListingDaoImpl listingDaoImpl) {
		this.listingDaoImpl = listingDaoImpl;
	}

	public void createBook(Book book) {

	}

	
}
