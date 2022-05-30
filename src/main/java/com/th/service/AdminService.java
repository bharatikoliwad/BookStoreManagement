package com.th.service;

import java.io.IOException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.th.model.Admin;
import com.th.model.Book;

/**
 * AdminService defines all the method headers to be implemented
 * 
 * @author bharati_koliwad, rakshita_prakash
 *
 */

public interface AdminService {

	/**
	 * removes a book from book table
	 * 
	 * @param idbook
	 * @return ModelAndView (the html page and the objects to be returned)
	 */
	public ModelAndView removeBook(Integer bookId);

	/**
	 * adds a new book to the book table
	 * 
	 * @param book
	 * @param file file is the image of the book
	 * @return ModelAndView (the html page and the objects to be returned)
	 * @throws IOException
	 */
	public ModelAndView addBook(Book book, @RequestParam("bookimg") MultipartFile file) throws IOException;

	/**
	 * updates the book details onto the database
	 * 
	 * @param book
	 * @param file is the image of the book
	 * @return ModelAndView (the html page and the objects to be returned)
	 * @throws IOException
	 */
	public ModelAndView updateBook(Book book, @RequestParam("bookimg") MultipartFile file) throws IOException;

	/**
	 * search a book by bookname
	 * 
	 * @param bookname
	 * @param model
	 * @return ModelAndView (the html page and the objects to be returned)
	 * @throws IOException
	 */
	public String bookSearch(String bookname, Model model) throws IOException;

	/**
	 * findByAdminId (finds a admin user using his admin id)
	 * 
	 * @param admin consists of admin id, password)
	 * @return ModelAndView (the html page and the objects to be returned)
	 */
	public ModelAndView findByAdminId(Admin admin);

}
