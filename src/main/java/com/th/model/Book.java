package com.th.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Book is the POJO class  that has id, name, price and genre timestamp and image
 * @author bharati_koliwad, rakshita_prakash
 *
 */
@Entity
@Table(name = "book")
public class Book implements Comparable<Book> {
	/**
	 * idbook is the primary key that uniquely identifies a row in book table
	 */
	@Id
	private Integer bookId;
	/**
	 * bookname (name of the book)
	 */
	private String bookname;
	/**
	 * bookprice (price of the book)
	 */
	private double bookprice;
	/**
	 * genre of the book
	 */
	private String genre;
	/**
	 * bookimage (image of the book in bytes array)
	 */
	private byte[] bookimage;
	/**
	 * booktimestamp (at what time and date the book was added)
	 */
	private Timestamp booktimestamp = null;

	/**
	 * gets a bookid
	 * 
	 * @return bookId
	 */
	public Integer getBookid() {
		return bookId;
	}

	/**
	 * sets a bookid
	 * 
	 * @param bookid
	 */
	public void setBookid(Integer bookid) {
		this.bookId = bookid;
	}

	/**
	 * gets bookname
	 * 
	 * @return bookname
	 */
	public String getBookname() {
		return bookname;
	}

	/**
	 * seta a bookname
	 * 
	 * @param bookname
	 */
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	/**
	 * gets bookprice
	 * 
	 * @return bookprice
	 */
	public double getBookprice() {
		return bookprice;
	}

	/**
	 * sets a bookprice
	 * 
	 * @param bookprice
	 */
	public void setBookprice(double bookprice) {
		this.bookprice = bookprice;
	}

	/**
	 * gets a bookgenre
	 * 
	 * @return genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * sets a bookgenre
	 * 
	 * @param genre
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * gets a bookimage
	 * 
	 * @return bookimage
	 */

	public byte[] getBookimage() {
		return bookimage;
	}

	/**
	 * sets a bookimage
	 * 
	 * @param bookimage
	 */
	public void setBookimage(byte[] bookimage) {
		this.bookimage = bookimage;
	}

	/**
	 * gets a bookimage in the byte arry type
	 * 
	 * @return
	 */
	public Timestamp getBooktimestamp() {
		return booktimestamp;
	}

	/**
	 * sets a bookimage
	 * 
	 * @param booktimestamp
	 */
	public void setBooktimestamp(Timestamp booktimestamp) {
		this.booktimestamp = booktimestamp;
	}

	/**
	 * parameterized constructor
	 * 
	 * @param bookId
	 * @param bookname
	 * @param author
	 * @param bookprice
	 * @param genre
	 */

	public Book(Integer bookId, String bookname, String author, double bookprice, String genre) {
		super();
		this.bookId = bookId;
		this.bookname = bookname;
		this.bookprice = bookprice;
		this.genre = genre;

	}

	/**
	 * Nonparmetrized constructor
	 */
	public Book() {

	}

	/**
	 * compareTo method compare two string lexicograpically
	 */
	@Override
	public int compareTo(Book o) {
		if (bookprice == o.getBookprice())
			return 0;
		else if (bookprice < o.getBookprice())
			return 1;
		else
			return -1;

	}

	/**
	 * toString method is used to return a string representation of an object
	 */
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookname=" + bookname + ", bookprice=" + bookprice + ", genre=" + genre
				+ "]";
	}

}
