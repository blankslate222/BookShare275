package edu.sjsu.cmpe275.bookshare.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public ModelAndView newUser() {
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
	public ModelAndView home() {
		ModelAndView model = new ModelAndView("index");
		//model.addObject("user", new User());
		return model;		
	}
	@RequestMapping(value="/login")
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("login");
		//model.addObject("user", new User());
		return model;		
	}
	
	
}
