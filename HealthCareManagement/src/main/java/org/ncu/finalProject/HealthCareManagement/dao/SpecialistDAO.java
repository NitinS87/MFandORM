package org.ncu.finalProject.HealthCareManagement.dao;

import java.util.List;

import org.ncu.finalProject.HealthCareManagement.entity.Specialist;

public interface SpecialistDAO {

	// method for fetching all the specialist records from the database
	public List<Specialist> loadSpecialist();

	// method for adding a record into the database
	public int createRecord(Specialist specialist);

	// method to update an existing record
	public int updateRecord(Specialist specialist);

	// method to fetch a single specialist record
	public Specialist getSpecialist(int id);

	// method to delete a specialist record from the database
	public void deleteSpecialist(int id);

	boolean validateSpecialist(String username, String password);

}
