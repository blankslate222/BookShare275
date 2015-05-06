package edu.sjsu.cmpe275.bookshare.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.sjsu.cmpe275.bookshare.model.Book;
import edu.sjsu.cmpe275.bookshare.model.Listing;
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

	@RequestMapping(value = "/book/create", method = RequestMethod.GET)
	public String newBookForm(Model model) {
		// System.out.println("home controller");
		Listing listing = new Listing();
		Book book = new Book();
		model.addAttribute("book", book);
		return "home";
	}

	@RequestMapping(value = "/book/create", method = RequestMethod.POST)
	public String newBook(@ModelAttribute("book") Book book,
			BindingResult result, Model model, HttpServletRequest req) {
		// System.out.println("home controller")

		book.setUser(""+req.getSession().getAttribute("user"));
		getBookService().createBook(book);
		
		return "redirect:/home";
	}

}
