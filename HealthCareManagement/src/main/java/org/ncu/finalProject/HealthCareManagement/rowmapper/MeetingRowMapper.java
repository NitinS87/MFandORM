package org.ncu.finalProject.HealthCareManagement.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.ncu.finalProject.HealthCareManagement.entity.Meeting;
import org.springframework.jdbc.core.RowMapper;

public class MeetingRowMapper implements RowMapper<Meeting> {

	@Override
	public Meeting mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Meeting meeting = new Meeting();
		meeting.setMeeting_id(rs.getInt("meeting_id"));
		meeting.setDate(rs.getDate("date"));
		meeting.setTime(rs.getString("time"));
		meeting.setLocation(rs.getString("location"));
		meeting.setLogistics((String[]) rs.getObject("logistics"));
		meeting.setCustomer_id(rs.getInt("customer_id"));
		meeting.setSpecialist_id(rs.getInt("specialist_id"));
		return meeting;
	}
}
