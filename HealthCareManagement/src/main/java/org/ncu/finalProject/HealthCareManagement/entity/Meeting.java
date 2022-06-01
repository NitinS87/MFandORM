package org.ncu.finalProject.HealthCareManagement.entity;

import java.sql.Date;
import java.util.ArrayList;

public class Meeting {

	private int meeting_id;
	private int customer_id;
	private int specialist_id;
	private Date date;
	private String time;
	private String location;
	private String[] logistics;
	private ArrayList<String> logisticsOptions;

	public int getMeeting_id() {
		return meeting_id;
	}


	public void setMeeting_id(int meeting_id) {
		this.meeting_id = meeting_id;
	}


	public int getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}


	public int getSpecialist_id() {
		return specialist_id;
	}


	public void setSpecialist_id(int specialist_id) {
		this.specialist_id = specialist_id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
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


	public Meeting() {

		logisticsOptions = new ArrayList<String>();
		logisticsOptions.add("Syringe");
		logisticsOptions.add("Sanitary Towels");
		logisticsOptions.add("Scissors");
		logisticsOptions.add("Spatula");
		logisticsOptions.add("Scalpels");
		logisticsOptions.add("Pulse Oximeter");
		logisticsOptions.add("Blood Pressure Monitor");
		logisticsOptions.add("EDTA tubes");

	}

}
