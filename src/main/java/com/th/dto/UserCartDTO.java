package com.th.dto;

import com.th.model.Book;

/**
 * UserCartDTO is a POJO class that has book and quantity
 * 
 * @author bharati_koliwad
 *
 */

public class UserCartDTO {
	/**
	 * Book is an Entity class that consists of attributes id, name, price and genre
	 * timestamp and image
	 */

	private Book book;

	/**
	 * quantity is number of a particular book added by user
	 */
	private int quantity;

	/**
	 * cartid is the id of the book cart which we have added to the cart
	 */

	private int cartid;

	/**
	 * gets a book object
	 * 
	 * @return book
	 */

	public Book getBook() {
		return book;
	}

	/**
	 * sets a book object
	 * 
	 * @param book
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	/**
	 * gets a quantity of the book
	 * 
	 * @return quantity
	 */

	public int getQuantity() {
		return quantity;
	}

	/**
	 * sets a quantity of the book
	 * 
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * gets cartid
	 * 
	 * @return
	 */
	public int getCartid() {
		return cartid;
	}

	/**
	 * sets the cartid
	 * 
	 * @param cartid
	 */
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

}
