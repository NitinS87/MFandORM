package org.ncu.finalProject.HealthCareManagement.entity;

import java.util.ArrayList;

public class Customer {
	private int customer_id;
	private String customer_username;
	private String customer_password;
	private String customer_name;
	private int customer_age;
	private String customer_gender;
	private ArrayList<String> genderOptions;
	private String customer_contact;
	private String customer_email;
	private String customer_address;

	@Override
	public String toString() {
		return "Customer [customer_username=" + customer_username + ", customer_password=" + customer_password
				+ ", customer_id=" + customer_id + ", customer_name=" + customer_name + ", customer_age=" + customer_age
				+ ", customer_gender=" + customer_gender + ", customer_contact=" + customer_contact
				+ ", customer_email=" + customer_email + ", customer_address=" + customer_address + "]";
	}

	private int specialist_id;
	private String[] logistics;
	private ArrayList<String> logisticsOptions;
	private String location;
	private String date;
	private String time;

	public Customer() {

		genderOptions = new ArrayList<String>();
		genderOptions.add("Male");
		genderOptions.add("Female");

	}

	public String getCustomer_username() {
		return customer_username;
	}

	public void setCustomer_username(String customer_username) {
		this.customer_username = customer_username;
	}

	public String getCustomer_password() {
		return customer_password;
	}

	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public int getCustomer_age() {
		return customer_age;
	}

	public void setCustomer_age(int customer_age) {
		this.customer_age = customer_age;
	}

	public String getCustomer_gender() {
		return customer_gender;
	}

	public void setCustomer_gender(String customer_gender) {
		this.customer_gender = customer_gender;
	}

	public ArrayList<String> getGenderOptions() {
		return genderOptions;
	}

	public void setGenderOptions(ArrayList<String> genderOptions) {
		this.genderOptions = genderOptions;
	}

	public String getCustomer_contact() {
		return customer_contact;
	}

	public void setCustomer_contact(String customer_contact) {
		this.customer_contact = customer_contact;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getCustomer_address() {
		return customer_address;
	}

	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}

	public int getSpecialist_id() {
		return specialist_id;
	}

	public void setSpecialist_id(int specialist_id) {
		this.specialist_id = specialist_id;
	}

	public String[] getLogistics() {
		return logistics;
	}

	public void setLogistics(String[] logistics) {
		this.logistics = logistics;
	}

	public ArrayList<String> getLogisticsOptions() {
		return logisticsOptions;
	}

	public void setLogisticsOptions(ArrayList<String> logisticsOptions) {
		this.logisticsOptions = logisticsOptions;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
