package edu.sjsu.cmpe275.bookshare.controller;

import java.sql.SQLException;
import java.util.List;

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
import edu.sjsu.cmpe275.bookshare.model.Bid;
import edu.sjsu.cmpe275.bookshare.model.Book;
import edu.sjsu.cmpe275.bookshare.model.Order;
import edu.sjsu.cmpe275.bookshare.model.User;
import edu.sjsu.cmpe275.bookshare.service.BidService;
import edu.sjsu.cmpe275.bookshare.service.BookService;
import edu.sjsu.cmpe275.bookshare.service.OrderService;

// buy, sell ,request
@Controller
public class TransactionsController {
	@Autowired
	private BookService bookService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private BidService bidService;

	@RequestMapping(value = "sell/book")
	public ModelAndView sellBook(Model modl) {
		ModelAndView model = new ModelAndView("SellBook");
		model.addObject("book", new Book());
		return model;
	}

	@RequestMapping(value = "sell/book", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute("book") Book book,
			BindingResult result, Model model, HttpServletRequest req) {

		book.setUser("" + req.getSession().getAttribute("user"));
		bookService.createBook(book);

		return "redirect:/home";
	}

	@RequestMapping(value = "book/request")
	public ModelAndView requestBook(Model modl) {
		ModelAndView model = new ModelAndView("RequestBook");
		model.addObject("book", new Book());
		return model;
	}

	@RequestMapping(value = "book/request", method = RequestMethod.POST)
	public String requestBook(@ModelAttribute("book") Book book,
			BindingResult result, Model model, HttpServletRequest req) {

		book.setUser("" + req.getSession().getAttribute("user"));
		bookService.createBookRequest(book);
		return "redirect:/home";
	}

	@RequestMapping(value = "book/purchase", method = RequestMethod.POST)
	public String purchaseBook(@ModelAttribute("book") Book book,
			BindingResult result, Model model, HttpServletRequest req) {
		
		String user1 = ""+req.getSession().getAttribute("user");
		Order order = orderService.bookShare(book.getIsbn(), user1);
		model.addAttribute("order", order);
		// System.out.println("inserted order id in controller = "+
		// order.getId());
		return "OrderSummary";
	}
	@RequestMapping(value = "/offer-bid/{offer}", method = RequestMethod.POST)
	public String offerLowerPrice(@PathVariable("offer") String offeredPrice,
			@ModelAttribute("book") Book book,
			BindingResult result, Model model, HttpServletRequest req) {
		// System.out.println("lower price quoted for "+ isbn);
		String message = "";
		System.out.println(book.getPrice());
		int listedPrice = Integer.parseInt(book.getPrice());
		ModelAndView mv = new ModelAndView("BookDetail");
		model.addAttribute("book", book);
		String returnView =  "redirect:/details/book/id/"+book.getId();
		if (listedPrice < Integer.parseInt(offeredPrice) && Integer.parseInt(offeredPrice) > 0 ) {
			message = "Only prices lower than the listed price is accepted";
			model.addAttribute("msg",message);

		} else {
			if (bidService.makeOffer(book, offeredPrice, ""
					+ req.getSession().getAttribute("user")) == 1) {
				model.addAttribute("alreadyBid", 1);
				returnView = "redirect:/home";
			} else {
				message = "Bid was not accepted. Please try again later";
				model.addAttribute("msg",message);
			}
		}
		return returnView;
	}
	@RequestMapping(value = "details/book/id/{id}", method = RequestMethod.GET)
	public String bookDetailsById(@PathVariable("id") int id, @RequestParam(required = false) String errorMsg, Model model) {
		String bookDetail = "BookDetail";
		Book book = bookService.getBookById(id);
		List<Order> reviews = null;
		if(book == null) {
			System.out.println("book is null");
			bookDetail = "redirect:/";
		}else{
			reviews = orderService.getOrdersByIsbn(book.getIsbn());
			model.addAttribute("book", book);
			model.addAttribute("msg", errorMsg);
			model.addAttribute("reviews", reviews);
		}
		
		return bookDetail;
	}

//	@RequestMapping(value = "details/book/isbn/{isbn}", method = RequestMethod.GET)
//	public String bookDetailsByIsbn(@PathVariable("isbn") String isbn, Model model) {
//		String bookDetail = "BookDetail";
//		Book book = bookService.getBookByIsbn(isbn);
//		if(book == null) {
//			System.out.println("book is null");
//			bookDetail = "redirect:/";
//		}else{
//			model.addAttribute("book", book);
//		}
//		
//		return bookDetail;
//	}
	
	@RequestMapping(value = "/update-feedback/{id}")
	public String feedBackForm(@PathVariable("id") String orderId, Model model) {
		System.out.println(" in feedback ");
			if( "".equals(orderId )) {
				model.addAttribute("order", null);
				return "feedback";
			}
			Order order = orderService.getOrderById(Integer.parseInt(orderId));
			
			if(order == null) {
				model.addAttribute("order", order);
				return "feedback";
			}
			
			model.addAttribute("order", order);
		return "feedback";
	}
	@RequestMapping(value = "update-feedback", method = RequestMethod.POST)
	public String updateFeedback(@ModelAttribute("order") Order order,
			BindingResult result, Model model) {
		// System.out.println(order.getFeedback()+order.getId());
		orderService.updateOrder(order);
		return "redirect:/history/purchase";
	}
	
	@RequestMapping(value = "/book/all")
	public String displayAvailableBooks(Model model) {
		List<Book> availableBooks = bookService.getAvailableBooks();
		model.addAttribute("books", availableBooks);
		return "AllBooks";
	}

	@RequestMapping(value = "/requests")
	public String displayBookRequests(Model model) {
		List<Book> requestedBooks = bookService.getRequestedBooks();
		model.addAttribute("books", requestedBooks);
		return "AllRequests";
	}
	
	@RequestMapping(value = "/fulfill-request/{id}")
	public String fulfillRequest(@PathVariable("id") int id, Model model) {
		Book book = null;
		book = bookService.getRequestedBook(id);
		
		if( book == null ) {
			return "redirect:/requests";
		}else{
			bookService.clearRequest(id);
		}
		model.addAttribute("book", book);
		return "SellBook";
	}
}
