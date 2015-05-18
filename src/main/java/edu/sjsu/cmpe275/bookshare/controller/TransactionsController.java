package edu.sjsu.cmpe275.bookshare.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import edu.sjsu.cmpe275.bookshare.model.Book;
import edu.sjsu.cmpe275.bookshare.model.Order;
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

	private boolean isAuthorized(HttpServletRequest req) {
		String userInSession = "" + req.getSession().getAttribute("user");

		if ("".equals(userInSession) || "Guest".equals(userInSession)) {
			return false;
		}

		return true;
	}

	@RequestMapping(value = "sell/book")
	public ModelAndView sellBook(Model modl, HttpServletRequest req) {
		if (!isAuthorized(req)) {
			return new ModelAndView("login");
		}
		ModelAndView model = new ModelAndView("SellBook");
		model.addObject("book", new Book());
		return model;
	}

	@RequestMapping(value = "sell/book", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute("book") Book book,
			BindingResult result, Model model, HttpServletRequest req,
			HttpServletResponse res) {

		if (!isAuthorized(req)) {
			return "redirect:/login";
		}

		book.setUser("" + req.getSession().getAttribute("user"));
		try {
			bookService.createBook(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res.setStatus(400);
			e.printStackTrace();
		}

		return "redirect:/home";
	}

	@RequestMapping(value = "book/request")
	public ModelAndView requestBook(Model modl, HttpServletRequest req) {
		if (!isAuthorized(req)) {
			return new ModelAndView("login");
		}
		ModelAndView model = new ModelAndView("RequestBook");
		model.addObject("book", new Book());
		return model;
	}

	@RequestMapping(value = "book/request", method = RequestMethod.POST)
	public String requestBook(@ModelAttribute("book") Book book,
			BindingResult result, Model model, HttpServletRequest req,
			HttpServletResponse res) {

		if (!isAuthorized(req)) {
			return "redirect:/login";
		}

		book.setUser("" + req.getSession().getAttribute("user"));
		try {
			bookService.createBookRequest(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res.setStatus(400);
			e.printStackTrace();
		}
		return "redirect:/home";
	}

	@RequestMapping(value = "book/purchase", method = RequestMethod.POST)
	public String purchaseBook(@ModelAttribute("book") Book book,
			BindingResult result, Model model, HttpServletRequest req,
			HttpServletResponse res) {

		if (!isAuthorized(req)) {
			return "redirect:/login";
		}

		String user1 = "" + req.getSession().getAttribute("user");
		Order order = orderService.bookShare(book.getIsbn(), user1);
		if (order == null) {
			res.setStatus(400);
		}
		model.addAttribute("order", order);
		// System.out.println("inserted order id in controller = "+
		// order.getId());
		return "OrderSummary";
	}

	@RequestMapping(value = "/offer-bid/{offer}", method = RequestMethod.POST)
	public String offerLowerPrice(@PathVariable("offer") String offeredPrice,
			@ModelAttribute("book") Book book, BindingResult result,
			Model model, HttpServletRequest req, HttpServletResponse res) {

		if (!isAuthorized(req)) {
			return "redirect:/login";
		}

		String message = "";
		System.out.println(book.getPrice());
		int listedPrice = Integer.parseInt(book.getPrice());
		ModelAndView mv = new ModelAndView("BookDetail");
		model.addAttribute("book", book);
		String returnView = "redirect:/details/book/id/" + book.getId();
		if (listedPrice < Integer.parseInt(offeredPrice)
				&& Integer.parseInt(offeredPrice) > 0) {
			message = "Only prices lower than the listed price is accepted";
			model.addAttribute("msg", message);
			res.setStatus(400);

		} else {
			if (bidService.makeOffer(book, offeredPrice, ""
					+ req.getSession().getAttribute("user")) == 1) {
				model.addAttribute("alreadyBid", 1);
				res.setStatus(400);
				returnView = "redirect:/home";
			} else {
				message = "Bid was not accepted. Please try again later";
				model.addAttribute("msg", message);
			}
		}
		return returnView;
	}

	@RequestMapping(value = "details/book/id/{id}", method = RequestMethod.GET)
	public String bookDetailsById(@PathVariable("id") int id,
			@RequestParam(required = false) String errorMsg, Model model,
			HttpServletResponse res) {
		String bookDetail = "BookDetail";
		Book book = bookService.getBookById(id);
		List<Order> reviews = null;
		if (book == null) {
			System.out.println("book is null");
			res.setStatus(404);
			bookDetail = "redirect:/home";
		} else {
			reviews = orderService.getOrdersByIsbn(book.getIsbn());
			model.addAttribute("book", book);
			model.addAttribute("msg", errorMsg);
			model.addAttribute("reviews", reviews);
		}

		return bookDetail;
	}

	@RequestMapping(value = "/update-feedback/{id}")
	public String feedBackForm(@PathVariable("id") String orderId, Model model,
			HttpServletRequest req, HttpServletResponse res) {
		if(!isAuthorized(req)) {
			return "redirect:/login";
		}
		if ("".equals(orderId)) {
			model.addAttribute("order", null);
			res.setStatus(404);
			return "feedback";
		}
		Order order = orderService.getOrderById(Integer.parseInt(orderId));

		if (order == null) {
			res.setStatus(404);
		}

		model.addAttribute("order", order);
		return "feedback";
	}

	@RequestMapping(value = "update-feedback", method = RequestMethod.POST)
	public String updateFeedback(@ModelAttribute("order") Order order,
			BindingResult result, Model model, HttpServletRequest req) {
		
		if(!isAuthorized(req)) {
			return "redirect:/login";
		}
		
		orderService.updateOrder(order);
		return "redirect:/history/purchase";
	}

	@RequestMapping(value = "/book/all")
	public String displayAvailableBooks(Model model, HttpServletResponse res) {
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
	public String fulfillRequest(@PathVariable("id") int id, Model model,
			HttpServletResponse res, HttpServletRequest req) {
		
		if(!isAuthorized(req)) {
			return "redirect:/login";
		}
		
		Book book = null;
		book = bookService.getRequestedBook(id);

		if (book == null) {
			res.setStatus(404);
			return "redirect:/requests";
		} else {
			bookService.clearRequest(id);
		}
		model.addAttribute("book", book);
		return "SellBook";
	}
}
