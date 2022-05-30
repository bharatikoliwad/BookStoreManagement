package com.th.service;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.th.model.PasswordUpdate;
import com.th.model.User;

/**
 * UserService defines all the method headers to be implemented
 * 
 * @author bharati_koliwad, rakshita_prakash
 *
 */
public interface UserService {
	/**
	 * password change (helps to change the password of the user)
	 * 
	 * @param passwordUpdate(constist of useremail,oldpassword, newpassword)
	 * @return String (html page)
	 */
	public String passwordChange(PasswordUpdate passwordUpdate);

	/**
	 * findByUserEmail(find the user by its emalid)
	 * 
	 * @param user(consit of name,useremail,password)
	 * @param model
	 * @return ModelAndView(return index if successful or else invalid)
	 */
	public ModelAndView findByUserEmail(User user, Model model);

	/**
	 * Serach a book by bookname
	 * 
	 * @param bname
	 * @param useremail
	 * @param model
	 * @return String (return to search if succesgull or else invalid)
	 */
	public String bookSearch(String bname, String useremail, Model model);

	/**
	 * UserLogin
	 * 
	 * @param model
	 * @return modelAndView( gives login page)
	 */
	public ModelAndView UserLogin(Model model);

}
