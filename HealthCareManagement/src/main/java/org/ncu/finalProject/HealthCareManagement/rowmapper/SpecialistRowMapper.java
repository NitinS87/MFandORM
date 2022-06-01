package org.ncu.finalProject.HealthCareManagement.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.ncu.finalProject.HealthCareManagement.entity.Specialist;
import org.springframework.jdbc.core.RowMapper;

public class SpecialistRowMapper implements RowMapper<Specialist> {

	@Override
	public Specialist mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Specialist specialist = new Specialist();
		specialist.setSpecialist_id(rs.getInt("specialist_id"));
		specialist.setSpecialist_username(rs.getString("specialist_username"));
		specialist.setSpecialist_password(rs.getString("specialist_password"));
		specialist.setSpecialist_name(rs.getString("specialist_name"));
		specialist.setSpecialist_experience(rs.getInt("specialist_experience"));
		specialist.setSpecialist_contact(rs.getString("specialist_contact"));
		specialist.setSpecialist_description(rs.getString("specialist_description"));
		specialist.setSpecialist_email(rs.getString("specialist_email"));
		return specialist;
	}
	
}
