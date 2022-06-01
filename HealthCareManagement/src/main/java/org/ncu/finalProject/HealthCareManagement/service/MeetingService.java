package org.ncu.finalProject.HealthCareManagement.service;

import java.util.List;

import org.ncu.finalProject.HealthCareManagement.entity.Meeting;

public interface MeetingService {

	public List<Meeting> fetchMeeting();

	public void saveMeeting(Meeting meeting);

	public void editMeeting(Meeting meeting);

	public Meeting getOneMeeting(int id);

	public void deleteOneMeeting(int id);
	
	public Meeting chosenOneMeeting(int customer_id, int specialist_id);

}
