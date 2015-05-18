package edu.sjsu.cmpe275.bookshare.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.cmpe275.bookshare.dao.UserDao;
import edu.sjsu.cmpe275.bookshare.model.Book;
import edu.sjsu.cmpe275.bookshare.model.User;
import edu.sjsu.cmpe275.bookshare.service.BookService;
import edu.sjsu.cmpe275.bookshare.utils.MailNotification;

@Controller
public class UserController {
	@Autowired
	private UserDao userDao;
	@Autowired
	private BookService bookService;
	@Autowired
	private MailNotification mailMail;

	private boolean isAuthorized(HttpServletRequest req) {
		String userInSession = "" + req.getSession().getAttribute("user");

		if ("".equals(userInSession) || "Guest".equals(userInSession)) {
			return false;
		}

		return true;
	}

	@RequestMapping(value = "/register")
	public ModelAndView newUser(Model modl, HttpServletResponse res) {
		ModelAndView model = null;
		model = new ModelAndView("register");
		model.addObject("user", new User());
		return model;
	}

	/*
	 * @RequestMapping(value = "/save", method = RequestMethod.POST) public
	 * ModelAndView saveUser(@ModelAttribute User user) throws SQLException {
	 * userDao.createUserhbm(user); return new ModelAndView("redirect:/"); }
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User user,
			HttpServletResponse res) {
		if (userDao.createUserhbm(user) == "success") {
			mailMail.sendMail(
					"bookshare275@gmail.com",
					user.getEmail(),
					"Registration",
					"Congratulations you have successfully "
							+ "registered on our website.Enjoy BookSharing. \n\n Thank you \n regards\n Bookshare.inc");
			return new ModelAndView("redirect:/");
		} else {
			String message = "username exists";
			res.setStatus(403);
			return new ModelAndView("redirect:/register", "message", message);
		}
	}

	@RequestMapping(value = "/")
	public ModelAndView home(Model modl) {
		ModelAndView model = new ModelAndView("index");
		// model.addObject("user", new User());
		return model;
	}

	@RequestMapping(value = "/login")
	public ModelAndView login(Model modl) {
		ModelAndView model = new ModelAndView("login");
		model.addObject("user", new User());
		return model;
	}

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ModelAndView logincheck(@ModelAttribute User user,
			HttpServletRequest req, HttpServletResponse res) {
		System.out.println("login method called");
		String email = user.getEmail();
		String password = user.getPassword();
		System.out.println("email" + email);
		if (userDao.get(email, password) != null) {
			System.out.println("success");
			req.getSession().setAttribute("user", email);
			return new ModelAndView("redirect:/home");

		} else {
			System.out.println("fail");
			String message = "Invalid login credentials";
			res.setStatus(401);
			return new ModelAndView("redirect:/login", "message", message);

		}
	}

	@RequestMapping(value = "/home")
	public ModelAndView userhome(Model modl) {
		ModelAndView model = new ModelAndView("home");
		// model.addObject("user", new User());
		return model;
	}

	@RequestMapping(value = "/useraccount")
	public ModelAndView useraccount(Model modl, HttpServletRequest req) {
		ModelAndView model = new ModelAndView("userAccount");
		if (!isAuthorized(req)) {
			return new ModelAndView("login");
		}
		List<Book> myBooks = null;
		myBooks = bookService.getBooksByUser(""
				+ req.getSession().getAttribute("user"));
		System.out.println("books size = " + myBooks.size());
		model.addObject("books", myBooks);
		return model;
	}

	@RequestMapping(value = "/allrequestedbooks")
	public ModelAndView allrequestedbooks(Model modl) {
		ModelAndView model = new ModelAndView("allRequested");
		// model.addObject("user", new User());
		return model;
	}

}
