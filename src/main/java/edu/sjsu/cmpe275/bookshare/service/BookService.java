package edu.sjsu.cmpe275.bookshare.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.cmpe275.bookshare.daoImpl.BookDaoImpl;
import edu.sjsu.cmpe275.bookshare.daoImpl.ListingDaoImpl;
import edu.sjsu.cmpe275.bookshare.daoImpl.RequestBookDaoImpl;
import edu.sjsu.cmpe275.bookshare.model.Book;
import edu.sjsu.cmpe275.bookshare.model.Listing;

@Service
public class BookService {

	@Autowired
	private BookDaoImpl bookDaoImpl;
	@Autowired
	private ListingDaoImpl listingDaoImpl;
	@Autowired
	private RequestBookDaoImpl reqBookDaoImpl;
	
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

			getBookDaoImpl().insert(book);

			//getListingDaoImpl().insert(listing);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public List<Book> getAvailableBooks() {
		
		List<Book> availableBooks = null;
		try {
			availableBooks = getBookDaoImpl().getAvailableBooks();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return availableBooks;
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

	public Book getBookByIsbn(String isbn) {
		Book book = null;
		try {
			book = getBookDaoImpl().getBookByIsbn(isbn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
	
	public void createBookRequest(Book book) {
		try {
			reqBookDaoImpl.createBookRequest(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Book> getRequestedBooks() {
		List<Book> requestedBooks = null;
		try {
			requestedBooks = reqBookDaoImpl.getRequests();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return requestedBooks;
	}
	
	public Book getRequestedBook(int id) {
		Book book = null;
		try {
			book = reqBookDaoImpl.getRequestedBookByRequestId(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
	
	public void clearRequest(int id) {
		try{
			reqBookDaoImpl.deleteBookRequestById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
