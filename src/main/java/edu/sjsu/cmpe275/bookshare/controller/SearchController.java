package edu.sjsu.cmpe275.bookshare.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.cmpe275.bookshare.model.Book;
import edu.sjsu.cmpe275.bookshare.service.BookService;

@Controller
public class SearchController {

	private BookService bookService;

	public BookService getBookService() {
		return bookService;
	}

	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping(value = "search")
	public String searchBooks(Model model) {
		return "Search";
	}

	@RequestMapping(value = "search/title")
	public ModelAndView searchBookByTitle(@RequestParam("title") String title,
			Model model, HttpServletResponse res) {
		ModelAndView searchResults = new ModelAndView("SearchResults");
		List<Book> booksFound = null;
		try {
			booksFound = getBookService().getBookDaoImpl()
					.getBookByTitle(title);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res.setStatus(400);
			e.printStackTrace();
		}
		searchResults.addObject("books", booksFound);
		searchResults.addObject("searchTerm", title);

		return searchResults;
	}

	@RequestMapping(value = "search/isbn")
	public ModelAndView searchBookByIsbn(@RequestParam("isbn") String isbn,
			Model model, HttpServletResponse res) {
		ModelAndView searchResults = new ModelAndView("SearchResults");
		Book booksFound = null;
		try {
			booksFound = getBookService().getBookDaoImpl().getBookByIsbn(isbn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res.setStatus(400);
			e.printStackTrace();
		}
		searchResults.addObject("book", booksFound);
		searchResults.addObject("searchTerm", isbn);

		return searchResults;
	}

	@RequestMapping(value = "search/author")
	public ModelAndView searchBookByAuthor(
			@RequestParam("author") String author, Model model, HttpServletResponse res) {
		ModelAndView searchResults = new ModelAndView("SearchResults");
		List<Book> booksFound = null;
		try {
			booksFound = getBookService().getBookDaoImpl().getBookByAuthor(
					author);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res.setStatus(400);
			e.printStackTrace();
		}
		searchResults.addObject("books", booksFound);
		searchResults.addObject("searchTerm", author);
		
		return searchResults;
	}

}
