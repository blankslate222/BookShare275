package edu.sjsu.cmpe275.bookshare.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.cmpe275.bookshare.dao.BookDao;
import edu.sjsu.cmpe275.bookshare.model.Book;
import edu.sjsu.cmpe275.bookshare.model.User;

// buy, sell ,request
@Controller
public class TransactionsController {
	@Autowired
	private BookDao bookDao;
	
	@RequestMapping(value="/book/sell")
	public ModelAndView sellBook() {
		ModelAndView model = new ModelAndView("SellForm");
		model.addObject("book", new Book());
		return model;		
	}
	@RequestMapping(value = "/book/sell", method = RequestMethod.POST)
	public ModelAndView saveBook(@ModelAttribute Book book) throws SQLException {
		bookDao.insert(book);
		System.out.println("this is sparta"+" "+book.getTitle());
		return new ModelAndView("redirect:/book/sell");
	}
	
}
