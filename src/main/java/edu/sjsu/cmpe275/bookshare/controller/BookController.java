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
import edu.sjsu.cmpe275.bookshare.service.BidService;
import edu.sjsu.cmpe275.bookshare.service.BookService;

@Controller
public class BookController {

	private BookService bookService;
	@Autowired
	private BidService bidService;

	public BookService getBookService() {
		return bookService;
	}

	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}


	@RequestMapping(value = "/accept-offer", method = RequestMethod.POST)
	public ModelAndView acceptOffer(@ModelAttribute("bid") Bid bid,
			BindingResult result, Model model, HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("home");
		bidService.acceptOffer(bid);
		return mv;
	}

	@RequestMapping(value = "/myoffers")
	public ModelAndView getOffers(Model model, HttpServletRequest req){
		ModelAndView mv = new ModelAndView("bidList");
		List<Bid> myBids = bidService.getBid(""+req.getSession().getAttribute("user"));
		mv.addObject("bids", myBids);
		return mv;
	}
}
