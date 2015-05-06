package edu.sjsu.cmpe275.bookshare.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.cmpe275.bookshare.dao.BookDao;
import edu.sjsu.cmpe275.bookshare.daoImpl.BookDaoImpl;
import edu.sjsu.cmpe275.bookshare.model.Book;
import edu.sjsu.cmpe275.bookshare.model.Order;
import edu.sjsu.cmpe275.bookshare.model.User;
import edu.sjsu.cmpe275.bookshare.service.BookService;
import edu.sjsu.cmpe275.bookshare.service.OrderService;

// buy, sell ,request
@Controller
public class TransactionsController {
	@Autowired
	private BookService bookService;
	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "sell/book")
	public ModelAndView sellBook() {
		ModelAndView model = new ModelAndView("SellBook");
		model.addObject("book", new Book());
		return model;
	}

	@RequestMapping(value = "sell/book", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute("book") Book book,
			BindingResult result, Model model, HttpServletRequest req) {

		book.setUser("" + req.getSession().getAttribute("user"));
		bookService.createBook(book);

		return "redirect:/";
	}

	@RequestMapping(value = "book/request")
	public ModelAndView requestBook() {
		ModelAndView model = new ModelAndView("RequestBook");
		model.addObject("book", new Book());
		return model;
	}

	@RequestMapping(value = "book/request", method = RequestMethod.POST)
	public String requestBook(@ModelAttribute("book") Book book,
			BindingResult result, Model model, HttpServletRequest req) {

		book.setUser("" + req.getSession().getAttribute("user"));
		bookService.createBookRequest(book);
		return "redirect:/";
	}

	@RequestMapping(value = "book/purchase", method = RequestMethod.POST)
	public ModelAndView purchaseBook(@ModelAttribute("book") Book book,
			BindingResult result,Model model, HttpServletRequest req) {
		ModelAndView feedback = new ModelAndView("feedback");
		//""+req.getSession().getAttribute("user")
		Order order = orderService.bookShare(book.getIsbn(), "user1");
		feedback.addObject("order", order);
		return feedback;
	}
	
	@RequestMapping(value = "details/book/{id}",method = RequestMethod.GET)
	public ModelAndView bookDetails(@PathVariable("id") int id, Model model) {
		ModelAndView orderSummary = new ModelAndView("BookDetails");
		Book book = bookService.getBookById(id);
		orderSummary.addObject("book", book );
		return orderSummary;
	}

}
