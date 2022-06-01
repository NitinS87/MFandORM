package org.ncu.finalProject.HealthCareManagement.service;

import java.util.List;

import org.ncu.finalProject.HealthCareManagement.dao.SpecialistDAO;
import org.ncu.finalProject.HealthCareManagement.entity.Specialist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialistServiceImpl implements SpecialistService {

	@Autowired
	private SpecialistDAO specialistDao;
	
	@Override
	public List<Specialist> fetchSpecialist() {
		// TODO Auto-generated method stub
				List<Specialist> specialistList = specialistDao.loadSpecialist();
				for(Specialist tempSpecialist : specialistList) {
					System.out.println(tempSpecialist);
				}
				return specialistList;
	}

	@Override
	public void saveSpecialist(Specialist specialist) {
		// TODO Auto-generated method stub
				int rowAdded = specialistDao.createRecord(specialist);
				if(rowAdded == 1) {
					System.out.println("Record saved successfully");
				}else {
					System.out.println("Error Occurred!!");
				}

	}

	@Override
	public void editSpecialist(Specialist specialist) {
		// TODO Auto-generated method stub
				int rowUpdated = specialistDao.updateRecord(specialist);
				if(rowUpdated == 1) {
					System.out.println("Record updated successfully");
				}else {
					System.out.println("Error Occurred!!");
				}

	}

	@Override
	public Specialist getOneSpecialist(int id) {
		// TODO Auto-generated method stub
		Specialist specialist = specialistDao.getSpecialist(id);
				return specialist;
	}

	@Override
	public void deleteOneSpecialist(int id) {
		// TODO Auto-generated method stub
				specialistDao.deleteSpecialist(id);
				System.out.println("Specialist with "+id+" is deleted successfully!!");
	}
	
	@Override
	public boolean validateSpecialist(String username, String pass) {
		// TODO Auto-generated method stub
		if((specialistDao.validateSpecialist(username, pass)) == true) {
			return true;
		};
		return false;
	}

}
