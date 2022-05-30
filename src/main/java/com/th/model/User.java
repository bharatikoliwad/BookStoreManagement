package com.th.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * User is a POJO class that has useremail, password, and phone number
 * @author bharati_koliwad, arifa_azam
 *
 */

@Entity
@Table(name ="user")
public class User {
	/**
	 * useremail is the primary key that uniquely identifies the rowsin the user table
	 */
	@Id
	@Column(name="useremail")
	private String useremail;
	
/**
 * name of the user
 */
	@Column(name="name")
	private String name;
	/**
	 *  password holds password i.e hashed using password encoder
	 */
	@Column(name="password")
	private String password;
/**
 * gets a useremail
 * @return useremail
 */
	public String getUseremail() {
		return useremail;
	}
	/**
	 * sets the useremailid
	 * @param useremail
	 */

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
/**
 * gets the user name
 * @return name
 */
	public String getName() {
		return name;
	}
/**
 * sets the user name
 * @param name
 */
	public void setName(String name) {
		this.name = name;
	}
/**
 * gets the password
 * @return password
 */
	public String getPassword() {
		return password;
	}
/**
 * sets the password
 * @param password
 */
	public void setPassword(String password) {
		this.password = password;
	}
/**
 * Non Parameterized constructor
 */
	public User() {
		super();
		
	}
	/**
	 * Parameterized constructor
	 * 
	 * @param useremail
	 * @param name
	 * @param password
	 */

	public User(String useremail, String name, String password) {
		super();
		this.useremail = useremail;
		this.name = name;
		this.password = password;
	}
	/**
	 * toString method is used to return a string representation of an object
	 */

	@Override
	public String toString() {
		return "User [useremail=" + useremail + ", name=" + name + ", password=" + password + "]";
	}
	
	
	
	
	
	

}

