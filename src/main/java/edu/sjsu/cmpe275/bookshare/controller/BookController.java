package edu.sjsu.cmpe275.bookshare.controller;

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

import edu.sjsu.cmpe275.bookshare.model.Bid;
import edu.sjsu.cmpe275.bookshare.model.Book;
import edu.sjsu.cmpe275.bookshare.model.Listing;
import edu.sjsu.cmpe275.bookshare.model.Order;
import edu.sjsu.cmpe275.bookshare.service.BidService;
import edu.sjsu.cmpe275.bookshare.service.BookService;
import edu.sjsu.cmpe275.bookshare.service.OrderService;

@Controller
public class BookController {

	private BookService bookService;
	@Autowired
	private BidService bidService;

	@Autowired
	private OrderService orderService;
	
	public BookService getBookService() {
		return bookService;
	}

	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping(value = "/accept-offer", method = RequestMethod.POST)
	public ModelAndView acceptOffer(@RequestParam("bidId") int bidId,
		 Model model, HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("home");
		System.out.println("bid id - accepted = " + bidId);
		Bid bid = bidService.getBidByBidId(bidId);
		bidService.acceptOffer(bid);
		return mv;
	}

	@RequestMapping(value = "/myoffers")
	public ModelAndView getOffers(Model model, HttpServletRequest req){
		ModelAndView mv = new ModelAndView("bidList");
		List<Bid> myBids = bidService.getBid(""+req.getSession().getAttribute("user"));
		mv.addObject("bids", myBids);
		System.out.println("my bids" + myBids.size());
		return mv;
	}
	
	@RequestMapping(value = "/history/purchase")
	public String purchaseHistory(Model model, HttpServletRequest req) {
		String user = ""+req.getSession().getAttribute("user");
		System.out.println(" user in session " + user);
		List<Order> purchaseHistory = orderService.getOrdersByBuyer(user);
		System.out.println("in contrlr " + purchaseHistory.size());
		model.addAttribute("history", purchaseHistory);
		return "PurchaseHistory";
	}
	
	@RequestMapping(value = "/history/sales")
	public String salesHistory(Model model, HttpServletRequest req) {
		String user = ""+req.getSession().getAttribute("user");
		System.out.println(" user in session " + user);
		List<Order> salesHistory = orderService.getOrdersBySeller(user);
		System.out.println("in contrlr " + salesHistory.size());
		model.addAttribute("history", salesHistory);
		return "SalesHistory";
	}
}
