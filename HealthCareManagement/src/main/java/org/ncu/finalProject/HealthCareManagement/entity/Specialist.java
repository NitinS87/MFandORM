package org.ncu.finalProject.HealthCareManagement.entity;

import java.util.ArrayList;

public class Specialist {
	
	private int specialist_id;
	private String specialist_username;
	private String specialist_password;
	private String specialist_name;
	private int specialist_experience;
	private String specialist_contact;
	private String specialist_description;
	private String specialist_email;
	private int customer_id;
	private String[] logistics;
	private ArrayList<String> logisticsOptions;
	private String date;
	private String time;
	private String location;
	
	public int getSpecialist_id() {
		return specialist_id;
	}
	public void setSpecialist_id(int specialist_id) {
		this.specialist_id = specialist_id;
	}
	public String getSpecialist_username() {
		return specialist_username;
	}
	public void setSpecialist_username(String specialist_username) {
		this.specialist_username = specialist_username;
	}
	public String getSpecialist_password() {
		return specialist_password;
	}
	public void setSpecialist_password(String specialist_password) {
		this.specialist_password = specialist_password;
	}
	public String getSpecialist_name() {
		return specialist_name;
	}
	public void setSpecialist_name(String specialist_name) {
		this.specialist_name = specialist_name;
	}
	public int getSpecialist_experience() {
		return specialist_experience;
	}
	public void setSpecialist_experience(int i) {
		this.specialist_experience = i;
	}
	public String getSpecialist_contact() {
		return specialist_contact;
	}
	public void setSpecialist_contact(String specialist_contact) {
		this.specialist_contact = specialist_contact;
	}
	public String getSpecialist_email() {
		return specialist_email;
	}
	public void setSpecialist_email(String specialist_email) {
		this.specialist_email = specialist_email;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSpecialist_description() {
		return specialist_description;
	}
	public void setSpecialist_description(String specialist_description) {
		this.specialist_description = specialist_description;
	}
	

}
