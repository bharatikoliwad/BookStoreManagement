package com.th.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.th.constants.SystemConstants;
import com.th.dto.UserCartDTO;
import com.th.model.UsersCart;
import com.th.service.CartService;

/**
 * CartController class allows you to add, delete, get books in a user's
 * cart
 * @author bharati_koliwad,arifa_azam
 *
 */



@Controller
public class CartController {

	/**
	 * cartService (autowires all user's cart functionalitites to cart controller)
	 */
	@Autowired
	CartService cartService;



	/**
	 * addBookToCart adds a book to the respective user's cart
	 * 
	 * @param userCart adds a book to the UserCart table
	 * @return shows the details of the book that was added to the cart
	 */
	@PostMapping(SystemConstants.USER_ADD_TO_CART)
	public String addBookToCart(UsersCart userCart) {

		return cartService.addBookToCart(userCart);
	}
	/**
	 * displays all orders made by the logged in user 
	 * @param useremail 
	 * @param model (allows to add the book object to be displayed onto the UI)
	 * @return ModelAndView (returns cart page or Invalid page)
	 */

	@GetMapping(SystemConstants.USER_DISPLAY_CART)
	public String getAllOrders(@PathVariable String useremail, Model model) {
		return cartService.getAllOrders(useremail,model);

	}
	/**
	 * delete a book from cart
	 * @param userCartDTO
	 * @return ModelAndView(returns cart page or Invalid page)
	 */
	
	@PostMapping(SystemConstants.USER_DELETE_CART)
	public String deleteBookCart(UserCartDTO userCartDTO) {
		return cartService.deleteBookCart(userCartDTO.getCartid());
	}
	/**
	 * cartToPaymentPage (move from cart to payment page)
	 * @param totalPrice (cost of all books)
	 * @param name (name of the user)
	 * @param model 
	 * @return ModelAndView (a html page)
	 */
	
	@PostMapping(SystemConstants.PAYMENT)
	public String cartToPaymentPage(double totalPrice,String name,Model model) {
		
		return cartService.cartToPaymentPage(totalPrice,name,model);
	}
	/**
	 * paymentToGreeting (move from payment page to the greeting page)
	 * @param name (name of the user)
	 * @param model
	 * @return  ModelAndView (a html page)
	 */
	
	@PostMapping(SystemConstants.GREETING)
	public String paymentToGreeting(String name, Model model) {
		return cartService.paymentToGreeting(name, model);
	}
	
}
