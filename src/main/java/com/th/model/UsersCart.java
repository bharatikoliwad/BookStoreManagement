package com.th.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * usersCart is a pojo class that has bookid, useremail, and qunatity
 * 
 * @author bharati_koliwad,arifa_azam, rakshita_prakash
 *
 */

@Table(name = "userscart")
@Entity
public class UsersCart {

	/**
	 * cartid is the primary key that uniquely identifies a row in the usercart
	 * table and the values are auto incremented
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartid;

	/**
	 * bookid is the unique id of the book in the book table
	 */
	private int bookid;

	/**
	 * email id of the paticular user tht has ordered the book
	 */
	private String useremail;

	/**
	 * quantity is the number of books that the user has ordered
	 */
	private int quantity;

	/**
	 * gets the bookid
	 * 
	 * @return bookid
	 */
	public int getBookid() {
		return bookid;
	}

	/**
	 * sets a bookid
	 * 
	 * @param bookid
	 */
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	/**
	 * gets the useremail
	 * 
	 * @return user email
	 */

	public String getUseremail() {
		return useremail;
	}

	/**
	 * sets the useremail
	 * 
	 * @param useremail
	 */

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	/**
	 * gets the booksquantity
	 * 
	 * @return
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * sets a bookquantity
	 * 
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * gets the cartid
	 * 
	 * @return cartid
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

	/**
	 * Nonparameterized constructer
	 */

	public UsersCart() {
		super();
	}

	/**
	 * toString method is used for the string representation of the object
	 */
	@Override
	public String toString() {
		return "UserCart [bookid=" + bookid + ", useremail=" + useremail + ", quantity=" + quantity + "]";
	}

}
