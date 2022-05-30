package com.th.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.th.model.Book;
import com.th.model.PasswordUpdate;
import com.th.model.User;
import com.th.repository.BookRepository;
import com.th.repository.UserRepository;
import com.th.utility.ImageUtil;

/**
 * UserServiceImpl implements the business logic for authenticating a user,
 * search a book add can change the password
 * 
 * @author bharati_koliwad, rakshita_prakash
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * UserLogin
	 * 
	 * @param model
	 * @return modelAndView(gives the html page)
	 */
	@Override
	public ModelAndView UserLogin(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		model.addAttribute("user", user);
		modelAndView.setViewName("userlogin");
		return modelAndView;

	}

	/**
	 * passwordChange (updates a password for an existing logged in user)
	 * 
	 * @param passwordUpdate
	 * @return (returns to home page if successful else goes to login page)
	 */
	@Override
	public String passwordChange(PasswordUpdate passwordUpdate) {

		Optional<User> searchUser = userRepository.findById(passwordUpdate.getUseremail());

		if (searchUser.isPresent()) {
			User userFound = searchUser.get();
			if (passwordEncoder.matches(passwordUpdate.getOldPassword(), userFound.getPassword())) {
				userFound.setPassword(passwordEncoder.encode(passwordUpdate.getNewPassword()));
				return "redirect:/login?success";

			}

			else {
				return "index";
			}

		} else {
			return "index";
		}
	}

	/**
	 * bookSearch (search a book by bookname)
	 * 
	 * @param bname
	 * @param useremail
	 * @param model
	 * @return String (return search page)
	 */
	@Override
	public String bookSearch(String bname, String useremail, Model model) {

		Book book = new Book();

		Optional<Book> searchObj = bookRepository.FindByBookName(bname);
		Optional<User> searchUser = userRepository.findById(useremail);

		if (searchObj.isPresent()) {
			User userFromDb = searchUser.get();
			System.out.println(useremail);

			book = searchObj.get();

			System.out.println(book);

			model.addAttribute("display", book);

			model.addAttribute("books", bookRepository.findAll());

			model.addAttribute("imgUtil", new ImageUtil());
			model.addAttribute("user", userFromDb);
			model.addAttribute("display", book);

			return "search";
		} else {
			return "invalid";
		}
	}

	/**
	 * findByUserEmail (finds a user using his email id)
	 * 
	 * @param user
	 * @param model
	 * @return String (return index if successful or else invalid)
	 */
	@Override
	public ModelAndView findByUserEmail(User user, Model model) {

		Optional<User> searchUser = userRepository.findById(user.getUseremail());

		ModelAndView modelAndView = new ModelAndView();
		if (searchUser.isPresent()) {
			User userFromDb = searchUser.get();
			Book book = new Book();

			if (passwordEncoder.matches(user.getPassword(), userFromDb.getPassword())) {

				modelAndView.setViewName("user");
				modelAndView.addObject("books", bookRepository.findAll());

				model.addAttribute("imgUtil", new ImageUtil());
				model.addAttribute("user", userFromDb);
				modelAndView.addObject("display", book);

				List<Book> bookTimeStamp = bookRepository.findAll();

				Collections.sort(bookTimeStamp, new Comparator<Book>() {
					@Override
					public int compare(Book o1, Book o2) {
						return o2.getBooktimestamp().compareTo(o1.getBooktimestamp());
					}
				});

				modelAndView.addObject("bookTimeStamp", bookTimeStamp);

				return modelAndView;

			} else {
				modelAndView.setViewName("redirect:/login?error");
				return modelAndView;
			}

		} else {
			modelAndView.setViewName("redirect:/login?error");

			return modelAndView;
		}
	}

}
