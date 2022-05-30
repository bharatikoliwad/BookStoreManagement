package com.th.constants;

/**
 * SystemConstants class (API end points are defined to remove the hard coding)
 * 
 * @author bharati_koliwad, rakshita_prakash,arifa_azam
 *
 */

public class SystemConstants {

	/**
	 * LOGIN (path URI that directs to the user login page)
	 */

	public static final String LOGIN = "/login";
	/**
	 * USER_LOGIN(path URI to authenticates a user)
	 */
	public static final String USER_LOGIN = "/userLogin";

	/**
	 * USER_REGISTER (path URL to register a new user into the application)
	 * 
	 */
	public static final String USER_REGISTER = "/userregister";
	/**
	 * ADMIN (path URI that directs to the admin login page)
	 */

	public static final String ADMIN = "/admin";
	/**
	 * ADMIN_LOGIN (path URI to authenticates a admin user)
	 */

	public static final String ADMIN_LOGIN = "/adminLogin";

	/**
	 * ADMIN_ADD (path URI to add a book from MYSQLDB)
	 */

	public static final String ADMIN_ADD = "/admin/addbook";

	/**
	 * ADMIN_DELETE (path URI to deletes a book from MYSQLDB)
	 */

	public static final String ADMIN_DELETE = "/admin/delete";
	/**
	 * ADMIN_UPDATE (path URI to update a book from MYSQLDB)
	 */

	public static final String ADMIN_UPDATE = "/admin/update";
	/**
	 * SEARCHBOOK (path URI to search a book from MYSQLDB)
	 */

	public static final String SEARCH_BOOK = "/admin/search";

	/**
	 * SEARCH (path URI for the user to search a book from MYSQLDB
	 */

	public static final String SEARCH = "/search";
	/**
	 * USER_PASS_CHANGE (path URI to change the password)
	 */
	public static final String USER_PASS_CHANGE = "/passwordchange";
	/**
	 * BOOKS (path URI allows book CRUD operation to be performed)
	 */

	public static final String BOOKS = "/books";
	/**
	 * BOOK (path URI that adds a book into the book table)
	 */

	public static final String BOOK = "/book";
	/**
	 * GET_ALL_BOOKS (path URI that gets all books from the sql database)
	 */

	public static final String GET_ALL_BOOKS = "/getallbooks";
	/**
	 * FIND_BOOK (path URI that finds a book using the bookId)
	 */

	public static final String FIND_BOOK = "/getbookbyid/{bookId}";

	/**
	 * DELETE_BOOK (path URI that deletes a book using bookId)
	 */
	public static final String DELETE_BOOK = "/deletebook/{bookId}";
	/**
	 * USER_DISPLAY_CART displays books added to cart by user
	 */

	public static final String USER_DISPLAY_CART = "/orders/{useremail}";
	/**
	 * USER_ADD_TO_CART adds a book to user's cart
	 */

	public static final String USER_ADD_TO_CART = "/cartaddbook";
	/**
	 * USER_DELETE_CART delete a book to from cart
	 */

	public static final String USER_DELETE_CART = "/deletebookcart";
	/**
	 * PAYMENT directs to payment page
	 */

	public static final String PAYMENT = "/payment";
	/**
	 * GREETING directs to greetings page
	 */

	public static final String GREETING = "/greeting";

}
