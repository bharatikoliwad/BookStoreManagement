package com.th.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.th.constants.SystemConstants;
import com.th.model.PasswordUpdate;
import com.th.model.User;
import com.th.repository.UserRepository;
import com.th.service.UserService;

/**
 * 
 * UserController class allows you to authenticate and register a user
 * 
 * @author bharati_koliwad, rakshita_prakash
 *
 */

@Controller
public class UserController {

	@Autowired
	UserRepository userRepostitory;
	/**
	 * userSerivce (autowires all user functionalitites to cart controller)
	 */
	@Autowired
	UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * userlogin(get the user login page)
	 * 
	 * @param model(which gives the html page)
	 * @return to the user login page
	 */

	@GetMapping(value = SystemConstants.LOGIN)
	public ModelAndView userlogin(Model model) {
		return userService.UserLogin(model);

	}

	/**
	 * authenticationUser function helps to matches user password with encrypted
	 * password in database
	 * 
	 * @param user  with properties useremail and password
	 * @param model
	 * @return ModelAndView which redirects to home page or back to login page
	 */
	@RequestMapping(value = SystemConstants.USER_LOGIN, method = RequestMethod.POST)
	public ModelAndView authenticationUser(User user, Model model) {

		return userService.findByUserEmail(user, model);

	}

	/**
	 * Userregister function helps to register a new user in to the application
	 * 
	 * @param user has all the properties required to create a new user
	 * @return String returns to home page if new user is created else goes to login
	 *         page
	 * 
	 */

	@PostMapping(value = SystemConstants.USER_REGISTER)
	public String Userregister(User user) {

		User registerduser = null;
		if (null != user) {
			registerduser = new User(user.getUseremail(), user.getName(), passwordEncoder.encode(user.getPassword()));
		}
		userRepostitory.save(registerduser);
		return "redirect:/login?success";
	}

	/**
	 * Allows an existing logged-in user to update his password
	 * 
	 * @param passwordUpdate consists of oldpassword,newpassword and useremail
	 * @return ModelAndView returns index or success page
	 */
	@RequestMapping(value = SystemConstants.USER_PASS_CHANGE, method = RequestMethod.POST)
	public String passwordChange(PasswordUpdate passwordUpdate) {

		return userService.passwordChange(passwordUpdate);

	}

	/**
	 * search a book by book name
	 * 
	 * @param bname
	 * @param useremail
	 * @param model
	 * @return String (return to search page)
	 */

	@GetMapping(value = SystemConstants.SEARCH)
	public String bookSearch(String bname, String useremail, Model model) {
		return userService.bookSearch(bname, useremail, model);
	}

}
