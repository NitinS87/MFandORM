package org.ncu.finalProject.HealthCareManagement.service;

import java.util.List;

import org.ncu.finalProject.HealthCareManagement.dao.MeetingDAO;
import org.ncu.finalProject.HealthCareManagement.entity.Meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeetinServiceImpl implements MeetingService {

	@Autowired
	private MeetingDAO meetingDao;

	@Override
	public List<Meeting> fetchMeeting() {
		// TODO Auto-generated method stub
		List<Meeting> meetingList = meetingDao.loadMeeting();
		for (Meeting tempMeeting : meetingList) {
			System.out.println(tempMeeting);
		}
		return meetingList;
	}

	@Override
	public void saveMeeting(Meeting meeting) {
		// TODO Auto-generated method stub
		int rowAdded = meetingDao.createRecord(meeting);
		if (rowAdded == 1) {
			System.out.println("Record saved successfully");
		} else {
			System.out.println("Error Occurred!!");
		}

	}

	@Override
	public void editMeeting(Meeting meeting) {
		// TODO Auto-generated method stub
		int rowUpdated = meetingDao.updateRecord(meeting);
		if (rowUpdated == 1) {
			System.out.println("Record updated successfully");
		} else {
			System.out.println("Error Occurred!!");
		}

	}

	@Override
	public Meeting getOneMeeting(int id) {
		// TODO Auto-generated method stub
		Meeting meeting = meetingDao.getMeeting(id);
		return meeting;
	}

	@Override
	public void deleteOneMeeting(int id) {
		// TODO Auto-generated method stub
		meetingDao.deleteMeeting(id);
		System.out.println("Meeting with " + id + " is deleted successfully!!");
	}

	@Override
	public Meeting chosenOneMeeting(int customer_id, int specialist_id) {
		// TODO Auto-generated method stub
		Meeting meeting = meetingDao.getChosenOneMeeting(customer_id, specialist_id);
		return meeting;
	}

}
