package org.ncu.finalProject.HealthCareManagement.dao;

import java.util.List;

import org.ncu.finalProject.HealthCareManagement.entity.Meeting;

public interface MeetingDAO {
	
	// method for fetching all the meeting records from the database
	public List<Meeting> loadMeeting();

	// method for adding a record into the database
	public int createRecord(Meeting meeting);

	// method to update an existing record
	public int updateRecord(Meeting meeting);

	// method to fetch a single meeting record
	public Meeting getMeeting(int id);

	// method to delete a customer record from the database
	public void deleteMeeting(int id);
	
	//method to find meeting with customer_id and specialist_id
	public Meeting getChosenOneMeeting(int customer_id, int specialist_id);
	
	//method to fetch customer meeting
	public List<Meeting> loadCustomerMeeting(int customer_id);

}
