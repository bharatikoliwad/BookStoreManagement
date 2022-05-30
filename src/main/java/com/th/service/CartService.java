package com.th.service;

import org.springframework.ui.Model;

import com.th.model.UsersCart;

/**
 * Cart Service defines all the method headers to be implemented
 * 
 * @author bharati_koliwad, arifa_azam
 *
 */
public interface CartService {

	/**
	 * adds a book to a user's cart
	 * 
	 * @param userCart consists of bookid, cartid, quantity and useremail
	 * @return (a html page)
	 */
	public String addBookToCart(UsersCart userCart);

	/**
	 * gets all books ordered by a user
	 * 
	 * @param useremail
	 * @param model     adds objetcs to be dispalyed to a user
	 * @return (a html page)
	 */
	public String getAllOrders(String useremail, Model model);

	/**
	 * delete a book from cart
	 * 
	 * @param cartid
	 * @return String (a cart page)
	 */
	public String deleteBookCart(int cartid);

	/**
	 * cartToPaymentPage (move from cart to payment page)
	 * 
	 * @param totalPrice (cost of all books)
	 * @param name       (name of the user)
	 * @param model
	 * @return String (a html page)
	 */
	public String cartToPaymentPage(double totalPrice, String name, Model model);

	/**
	 * paymentToGreeting (move to greetings page from payment)
	 * 
	 * @param name  (name of the user)
	 * @param model
	 * @return String (a html page)
	 */
	public String paymentToGreeting(String name, Model model);

}
