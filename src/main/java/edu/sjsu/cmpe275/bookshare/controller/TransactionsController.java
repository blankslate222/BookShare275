package edu.sjsu.cmpe275.bookshare.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.cmpe275.bookshare.dao.BookDao;
import edu.sjsu.cmpe275.bookshare.daoImpl.BookDaoImpl;
import edu.sjsu.cmpe275.bookshare.model.Book;
import edu.sjsu.cmpe275.bookshare.model.User;
import edu.sjsu.cmpe275.bookshare.service.BookService;

// buy, sell ,request
@Controller
public class TransactionsController {
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/book/create")
	public ModelAndView sellBook() {
		ModelAndView model = new ModelAndView("SellForm");
		model.addObject("book", new Book());
		return model;		
	}
	
	@RequestMapping(value = "/book/create", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute("book") Book book,
			BindingResult result, Model model, HttpServletRequest req) {

		book.setUser(""+req.getSession().getAttribute("user"));
		bookService.createBook(book);
		
		return "redirect:/home";
	}
	
}
