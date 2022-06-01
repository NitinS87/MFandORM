package org.ncu.finalProject.HealthCareManagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.ncu.finalProject.HealthCareManagement.entity.Specialist;
import org.ncu.finalProject.HealthCareManagement.rowmapper.SpecialistRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SpecialistDAOImpl implements SpecialistDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Specialist> loadSpecialist() {
		// TODO Auto-generated method stub
		List<Specialist> specialistList = new ArrayList();
		String query = "select * from specialist";
		specialistList = jdbcTemplate.query(query, new SpecialistRowMapper());
		return specialistList;
	}

	@Override
	public int createRecord(Specialist specialist) {
		// TODO Auto-generated method stub
		String query = "insert into specialist values(?,?,?,?,?,?,?,?)";
		Object records[] = { specialist.getSpecialist_id(), specialist.getSpecialist_username(),
				specialist.getSpecialist_password(), specialist.getSpecialist_name(), specialist.getSpecialist_experience(),
				specialist.getSpecialist_contact(), specialist.getSpecialist_description(), specialist.getSpecialist_email(),};
		int recordInserted = jdbcTemplate.update(query, records);
		return recordInserted;
	}

	@Override
	public int updateRecord(Specialist specialist) {
		// TODO Auto-generated method stub
		String sql = "update specialist set specialist_username = ?, specialist_password = ?, specialist_name = ?, spacialist_experience = ?, specialist_contact = ?, specialist_description = ?, specialist_email = ? where specialist_id = ?";
		Object[] args = { specialist.getSpecialist_username(), specialist.getSpecialist_password(), specialist.getSpecialist_name(),
				specialist.getSpecialist_experience(), specialist.getSpecialist_contact(), specialist.getSpecialist_description(),
				specialist.getSpecialist_email(), specialist.getSpecialist_id()};
		int recordsUpdated = jdbcTemplate.update(sql, args);
		return recordsUpdated;
	}

	@Override
	public Specialist getSpecialist(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from specialist where specialist_id = ?";
		Specialist specialist = jdbcTemplate.queryForObject(sql, new SpecialistRowMapper(), id);
		return specialist;
	}

	@Override
	public void deleteSpecialist(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from specialist where specialist_id = ?";
		jdbcTemplate.update(sql, id);

	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean validateSpecialist(String username, String password) {
		// TODO Auto-generated method stub
		String query = "select * from specialist where specialist_username=?";
		Object[] args = { username };
		List<Specialist> ls = new ArrayList<Specialist>();
		ls = jdbcTemplate.query(query, args, new SpecialistRowMapper());
		ls.get(0).getSpecialist_password();
		if(ls.get(0).getSpecialist_password().equals(password)) 
		{
			return true;
		}
		return false;
	}

}
