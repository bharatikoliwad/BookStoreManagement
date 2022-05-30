package com.th.model;

/**
 * passwordupdate {@link PasswordUpdate} POJO for updating password
 * 
 * @author bharati_koliwad, arifa_azam
 *
 */
public class PasswordUpdate {
	/**
	 * user's emaiid to update the password
	 */

	private String useremail;
	/**
	 * user's old password is used to authenticate
	 */

	private String oldPassword;

	/**
	 * new password that user wants to set
	 */
	private String newPassword;

	/**
	 * gets a useremailid
	 * 
	 * @return useremail
	 */
	public String getUseremail() {
		return useremail;
	}

	/**
	 * sets useremail
	 * 
	 * @param useremail
	 */
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	/**
	 * gets a user's old password
	 * 
	 * @return oldpassword
	 */

	public String getOldPassword() {
		return oldPassword;
	}

	/**
	 * sets a old password
	 * 
	 * @param oldPassword
	 */

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	/**
	 * gets a new password that the user setted
	 * 
	 * @return new password
	 */

	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * sets a new password
	 * 
	 * @param newPassword
	 */

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	/**
	 * parameterized constructor
	 * 
	 * @param useremail
	 * @param oldPassword
	 * @param newPassword
	 */
	public PasswordUpdate(String useremail, String oldPassword, String newPassword) {
		super();
		this.useremail = useremail;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}

}
