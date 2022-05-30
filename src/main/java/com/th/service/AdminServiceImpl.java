package com.th.service;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.th.model.Admin;
import com.th.model.Book;
import com.th.repository.AdminRepository;
import com.th.repository.BookRepository;
import com.th.utility.ImageUtil;

/**
 * AdminServiceImpl implements the business logic for authenticating a admin and
 * add, update, remove and search a book
 * 
 * @author bharati_koliwad, rakshita_prakash
 *
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	BookRepository bookRepository;

	/**
	 * findByAdminId (finds a admin user using his admin id)
	 * 
	 * @param admin consists of adminid , password )
	 * @return ModelAndView (the html page and the objects to be returned)
	 */

	@Override
	public ModelAndView findByAdminId(Admin admin) {

		Optional<Admin> searchAdminUser = adminRepository.findById(admin.getAdminid());
		ModelAndView modelAndView = new ModelAndView();
		if (searchAdminUser.isPresent()) {
			Admin adminUser = searchAdminUser.get();

			modelAndView.setViewName("admin");

			if (admin.getPassword().equals(adminUser.getPassword())) {

				modelAndView.addObject("admin", adminUser);

				List<Book> bookList = bookRepository.findAll();

				Collections.sort(bookList);
				modelAndView.addObject("books", bookList);

				List<Book> bookTimeStamp = bookRepository.findAll();
				Collections.sort(bookTimeStamp, new Comparator<Book>() {
					@Override
					public int compare(Book o1, Book o2) {
						return o2.getBooktimestamp().compareTo(o1.getBooktimestamp());
					}
				});

				modelAndView.addObject("bookTimeStamp", bookTimeStamp);

			} else {
				modelAndView.setViewName("index");

			}

		} else
			modelAndView.setViewName("invalid");

		return modelAndView;

	}

	/**
	 * removeBook (removes a book from book table)
	 * 
	 * @param bookId
	 * @return ModelAndView (the html page and the objects to be returned)
	 */
	@Override
	public ModelAndView removeBook(Integer bookId) {
		ModelAndView modelAndView = new ModelAndView();

		if (bookRepository.existsById(bookId)) {
			bookRepository.deleteById(bookId);
			modelAndView.setViewName("delete");
			return modelAndView;
		} else {
			modelAndView.setViewName("invalid");
			return modelAndView;
		}
	}

	/**
	 * updateBook (updates the book details onto the database)
	 * 
	 * @param book
	 * @param file is the image of the book
	 * @return ModelAndView (the html page and the objects to be returned)
	 * @throws IOException
	 */
	@Override
	public ModelAndView updateBook(Book book, @RequestParam("bookimg") MultipartFile file) throws IOException {

		ModelAndView modelAndView = new ModelAndView();
		Optional<Book> searchBook = bookRepository.findById(book.getBookid());

		if (searchBook.isPresent()) {
			Book foundBook = searchBook.get();

			if (!book.getBookname().isEmpty())
				foundBook.setBookname(book.getBookname());

			if (!book.getGenre().isEmpty())
				foundBook.setGenre(book.getGenre());

			if (book.getBookprice() > 0)
				foundBook.setBookprice(book.getBookprice());

			foundBook.setBooktimestamp(new java.sql.Timestamp(System.currentTimeMillis()));
			if (file.getSize() > 0) {
				System.out.println("entered");

				foundBook.setBookimage(file.getBytes());

			}

			bookRepository.save(foundBook);
			modelAndView.setViewName("updatedsucess");
			return modelAndView;
		} else {
			modelAndView.setViewName("invalid");
			return modelAndView;
		}

	}

	/**
	 * addBook (adds a new book to the book table)
	 * 
	 * @param book
	 * @param file file is the image of the book
	 * @return ModelAndView (the html page and the objects to be returned)
	 * @throws IOException
	 */
	@Override
	public ModelAndView addBook(Book book, @RequestParam("bookimg") MultipartFile file) throws IOException {

		ModelAndView modelAndView = new ModelAndView();
		Optional<Book> searchBook = bookRepository.findById(book.getBookid());

		if (!(searchBook.isPresent())) {
			Book newBook = new Book();
			convertBookModelToEntity(book, file, newBook);
			bookRepository.save(newBook);
			modelAndView.setViewName("success");
			return modelAndView;
		} else {
			modelAndView.setViewName("invaild");
			return modelAndView;
		}
	}

	/**
	 * convertBookModelToEntity mapping book to new book
	 * 
	 * @param book
	 * @param file
	 * @param newBook
	 * @throws IOException
	 */

	private void convertBookModelToEntity(Book book, MultipartFile file, Book newBook) throws IOException {
		newBook.setBookid(book.getBookid());
		newBook.setBookname(book.getBookname());

		newBook.setGenre(book.getGenre());

		newBook.setBookprice(book.getBookprice());

		newBook.setBooktimestamp(new java.sql.Timestamp(System.currentTimeMillis()));

		newBook.setBookimage(file.getBytes());
	}

	/**
	 * search (search a book by bookname)
	 * 
	 * @param bookname
	 * @param model
	 * @return ModelAndView (the html page and the objects to be returned)
	 * @throws IOException
	 */
	@Override
	public String bookSearch(String bookname, Model model) throws IOException {

		Book book = new Book();

		Optional<Book> searchObj = bookRepository.FindByBookName(bookname);

		if (searchObj.isPresent()) {

			book = searchObj.get();

			System.out.println(book);

			model.addAttribute("display", book);

			model.addAttribute("books", bookRepository.findAll());

			model.addAttribute("imgUtil", new ImageUtil());

			model.addAttribute("display", book);

			return "adminsearch";
		} else {
			return "invalid";
		}

	}
}
