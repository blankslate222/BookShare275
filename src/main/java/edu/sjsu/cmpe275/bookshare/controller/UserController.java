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
import edu.sjsu.cmpe275.bookshare.daoImpl.UserDaoImpl;
import edu.sjsu.cmpe275.bookshare.model.User;

@Controller
public class UserController {
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value="/register")
	public ModelAndView newUser(Model modl) {
		ModelAndView model = new ModelAndView("register");
		model.addObject("user", new User());
		return model;		
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User user) throws SQLException {
		userDao.createUserhbm(user);
		return new ModelAndView("redirect:/");
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
	    	  req.getSession().setAttribute("email",email);
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
	public ModelAndView useraccount(Model modl) {
		ModelAndView model = new ModelAndView("userAccount");
		//model.addObject("user", new User());
		return model;		
	}
	@RequestMapping(value="/allrequestedbooks")
	public ModelAndView allrequestedbooks(Model modl) {
		ModelAndView model = new ModelAndView("allRequested");
		//model.addObject("user", new User());
		return model;		
	}
	
}
