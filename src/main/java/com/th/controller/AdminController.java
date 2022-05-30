package com.th.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.th.constants.SystemConstants;
import com.th.model.Admin;
import com.th.model.Book;
import com.th.repository.AdminRepository;
import com.th.service.AdminService;

/**
 * AdminController class is used to authenticate a admin
 * 
 * @author bharati_koliwad,rakshita_prakash
 *
 */

@Controller
public class AdminController {

	/**
	 * adminRepostitory provides the CRUD operations for admin user
	 */

	@Autowired
	AdminRepository adminRepostitory;
	/**
	 * adminService autowires all functionalities of admin to AdminController
	 */
	@Autowired
	AdminService adminService;

	/**
	 * adminlogin(get the admin login page)
	 * 
	 * @param model(which gives the html page)
	 * @return to the admin login page
	 */

	@GetMapping(value = SystemConstants.ADMIN)
	public String adminlogin(Model model) {
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		return "adminLogin";
	}

	/**
	 * authenticationAdmin(helps to authenticate the admin user)
	 * 
	 * @param admin consists of admin name, password and name
	 * @return ModelAndView (the html page and the objects to be returned)
	 */
	@RequestMapping(value = SystemConstants.ADMIN_LOGIN, method = RequestMethod.POST)
	public ModelAndView authenticationAdmin(Admin admin) {

		return adminService.findByAdminId(admin);

	}

	/**
	 * Adds a new book onto the MYSQL database
	 * 
	 * @param book (consists of book details that must be updated)
	 * @param file (image of the book)
	 * @return ModelAndView (the html page returns a success page or invalid page)
	 * @throws IOException
	 */
	@PostMapping(SystemConstants.ADMIN_ADD)
	public ModelAndView addBook(Book book, @RequestParam("bookimg") MultipartFile file) throws IOException {

		return adminService.addBook(book, file);

	}

	/**
	 * deletes a book by the bookId
	 * 
	 * @param bookId which has to deleted from MYSQL database
	 * @return ModelAndView (the html page returns a success page or invalid page)
	 */

	@PostMapping(SystemConstants.ADMIN_DELETE)
	public ModelAndView deleteBookById(Integer bookId) {

		ModelAndView modelAndView = adminService.removeBook(bookId);
		return modelAndView;

	}

	/**
	 * Updates an existing book details which is residing in MYSQL database
	 * 
	 * @param book (consists of book details that must be updated)
	 * @param file (image of the book)
	 * @return ModelAndView (the html page returns a success page or invalid page)
	 * @throws IOException
	 */

	@PostMapping(SystemConstants.ADMIN_UPDATE)
	public ModelAndView UpdateBookById(Book book, @RequestParam("bookimg") MultipartFile file) throws IOException {

		ModelAndView modelAndView = adminService.updateBook(book, file);
		return modelAndView;

	}

	/**
	 * Search a book by its bookname
	 * 
	 * @param bookname which has to searched from MYSQL database
	 * @param model
	 * @return ModelAndView (the html page returns a success page or invalid page)
	 * @throws IOException
	 */

	@GetMapping(value = SystemConstants.SEARCH_BOOK)
	public String bookSearch(String bookname, Model model) throws IOException {
		return adminService.bookSearch(bookname, model);
	}

}
