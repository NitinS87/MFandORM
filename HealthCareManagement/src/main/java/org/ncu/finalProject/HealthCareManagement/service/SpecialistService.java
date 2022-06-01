package org.ncu.finalProject.HealthCareManagement.service;

import java.util.List;

import org.ncu.finalProject.HealthCareManagement.entity.Specialist;

public interface SpecialistService {

	public List<Specialist> fetchSpecialist();

	public void saveSpecialist(Specialist specialist);

	public void editSpecialist(Specialist specialist);

	public Specialist getOneSpecialist(int id);

	public void deleteOneSpecialist(int id);

	boolean validateSpecialist(String username, String pass);
	
}
