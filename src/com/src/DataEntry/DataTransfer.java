/*
 * This class get the input from the text fields in DataEntryGui class and stores it local variables.
 * Data stored in this file is then used for reading in an array list in DataEntryUtilities class. 
 */

package com.src.DataEntry;

public class DataTransfer {

	private String fname;
	private String mi;
	private String lname;
	private String addrs1;
	private String addrs2;
	private String city;
	private String state;
	private String zcode;
	private String country;
	private String phone;
	private String email;

	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * @param fname
	 *            the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}

	/**
	 * @return the mi
	 */
	public String getMi() {
		return mi;
	}

	/**
	 * @param mi
	 *            the mi to set
	 */
	public void setMi(String mi) {
		this.mi = mi;
	}

	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}

	/**
	 * @param lname
	 *            the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}

	/**
	 * @return the addrs1
	 */
	public String getAddrs1() {
		return addrs1;
	}

	/**
	 * @param addrs1
	 *            the addrs1 to set
	 */
	public void setAddrs1(String addrs1) {
		this.addrs1 = addrs1;
	}

	/**
	 * @return the addrs2
	 */
	public String getAddrs2() {
		return addrs2;
	}

	/**
	 * @param addrs2
	 *            the addrs2 to set
	 */
	public void setAddrs2(String addrs2) {
		this.addrs2 = addrs2;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the zcode
	 */
	public String getZcode() {
		return zcode;
	}

	/**
	 * @param zcode
	 *            the zcode to set
	 */
	public void setZcode(String zcode) {
		this.zcode = zcode;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
