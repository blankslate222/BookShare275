package edu.sjsu.cmpe275.bookshare.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.cmpe275.bookshare.dao.UserDao;
import edu.sjsu.cmpe275.bookshare.daoImpl.BookDaoImpl;
import edu.sjsu.cmpe275.bookshare.daoImpl.UserDaoImpl;
import edu.sjsu.cmpe275.bookshare.model.Book;
import edu.sjsu.cmpe275.bookshare.model.User;
import edu.sjsu.cmpe275.bookshare.service.BookService;

@Controller
public class UserController {
	@Autowired
	private UserDao userDao;
	@Autowired
	private BookService bookService;
	@RequestMapping(value="/register")
	public ModelAndView newUser(Model modl) {
		ModelAndView model = new ModelAndView("register");
		model.addObject("user", new User());
		return model;		
	}
/*	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User user) throws SQLException {
		userDao.createUserhbm(user);
		return new ModelAndView("redirect:/");
	}*/
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User user) throws SQLException {
		if(userDao.createUserhbm(user)=="success")
		{
		return new ModelAndView("redirect:/");
		}
		else{
			String message ="username exists";
			return new ModelAndView("redirect:/register","message",message);
		}
	}
	@RequestMapping(value="/")
	public ModelAndView home(Model modl) {
		ModelAndView model = new ModelAndView("index");
		//model.addObject("user", new User());
		return model;		
	}
	@RequestMapping(value="/login")
	public ModelAndView login(Model modl) {
		ModelAndView model = new ModelAndView("login");
		model.addObject("user", new User());
		return model;		
	}
	@RequestMapping(value="/signin",method = RequestMethod.POST)
	public ModelAndView logincheck(@ModelAttribute User user,HttpServletRequest req) {
		  System.out.println("login method called");
		  String email=user.getEmail();  
	      String password=user.getPassword();  
	      System.out.println("email"+email);
	      if(userDao.get(email, password)!=null)
	      {
	    	  System.out.println("success");
	    	  req.getSession().setAttribute("user",email);
	    	  return new ModelAndView("redirect:/home");
	    	  
	      }
	      else
	      {
	    	  System.out.println("fail");
	    	  String message="Invalid login credentials";
	    	  return new ModelAndView("redirect:/login","message",message);
	    	  
	      }
	}
	@RequestMapping(value="/home")
	public ModelAndView userhome(Model modl) {
		ModelAndView model = new ModelAndView("home");
		//model.addObject("user", new User());
		return model;		
	}
	@RequestMapping(value="/useraccount")
	public ModelAndView useraccount(Model modl, HttpServletRequest req) {
		ModelAndView model = new ModelAndView("userAccount");
		//model.addObject("user", new User());
		List<Book> myBooks = null;
		myBooks = bookService.getBooksByUser(""+req.getSession().getAttribute("user"));
		System.out.println("books size = " + myBooks.size());
		model.addObject("books", myBooks);
		return model;		
	}
	@RequestMapping(value="/allrequestedbooks")
	public ModelAndView allrequestedbooks(Model modl) {
		ModelAndView model = new ModelAndView("allRequested");
		//model.addObject("user", new User());
		return model;		
	}
	
}
