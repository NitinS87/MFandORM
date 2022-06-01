package org.ncu.finalProject.HealthCareManagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.ncu.finalProject.HealthCareManagement.entity.Meeting;
import org.ncu.finalProject.HealthCareManagement.rowmapper.MeetingRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MeetingDAOImpl implements MeetingDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Meeting> loadMeeting() {
		// TODO Auto-generated method stub
		List<Meeting> meetingList = new ArrayList();
		String query = "select * from meeting";
		meetingList = jdbcTemplate.query(query, new MeetingRowMapper());
		return meetingList;
	}

	@Override
	public int createRecord(Meeting meeting) {
		// TODO Auto-generated method stub
		String query = "insert into meeting values(?,?,?,?,?,?,?)";
		Object records[] = { meeting.getMeeting_id(), meeting.getDate(), meeting.getTime(), meeting.getLocation(), meeting.getLogistics(),
				meeting.getCustomer_id(), meeting.getSpecialist_id() };
		int recordInserted = jdbcTemplate.update(query, records);
		return recordInserted;
	}

	@Override
	public int updateRecord(Meeting meeting) {
		// TODO Auto-generated method stub
		String sql = "update meeting set logistics = ? where meeting_id = ?";
		Object[] args = { meeting.getLogistics(), meeting.getMeeting_id() };
		int recordsUpdated = jdbcTemplate.update(sql, args);
		return recordsUpdated;
	}

	@Override
	public Meeting getMeeting(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from meeting where meeting_id = ?";
		Meeting meeting = jdbcTemplate.queryForObject(sql, new MeetingRowMapper(), id);
		return meeting;
	}

	@Override
	public void deleteMeeting(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from meeting where meeting_id = ?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public Meeting getChosenOneMeeting(int customer_id, int specialist_id) {
		// TODO Auto-generated method stub
		String sql = "select * from meeting where customer_id = ? && specialist_id = ?";
		Meeting meeting = jdbcTemplate.queryForObject(sql, new MeetingRowMapper(), customer_id, specialist_id);
		return meeting;
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Meeting> loadCustomerMeeting(int customer_id) {
		// TODO Auto-generated method stub
		List<Meeting> meetingList = new ArrayList();
		String query = "select * from meeting where customer_id = ?";
		meetingList = jdbcTemplate.query(query, new MeetingRowMapper(), customer_id);
		return meetingList;
	}

}
