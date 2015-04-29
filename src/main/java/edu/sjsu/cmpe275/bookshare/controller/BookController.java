package edu.sjsu.cmpe275.bookshare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.sjsu.cmpe275.bookshare.service.BookService;

@Controller
public class BookController {

	private BookService bookService;

	public BookService getBookService() {
		return bookService;
	}

	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String home(Model model) {
		//System.out.println("home controller");
		return "home";
	}
}
