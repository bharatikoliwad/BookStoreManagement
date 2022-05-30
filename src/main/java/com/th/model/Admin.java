package com.th.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Admin is a POJO class that has admin id and password
 * 
 * @author bharati_koliwad, rakshita_prakash
 *
 */

@Entity
@Table(name = "admin")
public class Admin {
	/**
	 * admin id is the primary key uniquely identifies each admin
	 */
	@Id
	private String adminid;
	/**
	 * admin password is used to authenticate an admin
	 */
	private String password;

	/**
	 * gets adminid
	 * 
	 * @return adminid
	 */

	public String getAdminid() {
		return adminid;
	}

	/**
	 * sets adminid
	 * 
	 * @param adminid
	 */
	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	/**
	 * gets a password for admin user
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * sets a password for admin password
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;

	}

	/**
	 * toString method is used to return a string representation of an object
	 */
	@Override
	public String toString() {

		return super.toString();
	}

}
