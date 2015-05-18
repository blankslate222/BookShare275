package edu.sjsu.cmpe275.bookshare.test.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sjsu.cmpe275.bookshare.model.Book;
import edu.sjsu.cmpe275.bookshare.service.BidService;
import edu.sjsu.cmpe275.bookshare.service.BookService;
import edu.sjsu.cmpe275.bookshare.service.OrderService;

public class Booktest {

	@Autowired
	private BookService bookService;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Booktest().testMethods();
	}

		public void testMethods(){
			Book book = new Book();
			book.setAuthor("author1");
			book.setIsbn("1234");
			book.setTitle("mytitle");
			book.setUser("user1");
			try {
				bookService.createBook(book);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
	
		
		//BidService bidservic = new BidService();
		//bidservice.offerLowerPrice("1234");
		
	//	OrderService orderservice = new OrderService();
		//orderservice.bookShare("1234", "buyer1");

}
