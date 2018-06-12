package it.clinic.persistence;

import java.util.List;

import it.clinic.model.Patient;

public interface PatientDao {
	
	public void save(Patient patient); //Create
	
	public void delete(Patient patient ); //Delete
	
	public void update(Patient patient); //Update
	
	public List<Patient> findAll(); 
	
	public Patient findByPrimaryKey(Long id); //Retrieve
	public Patient findByUsername(String username);
	public void delete(Long id);

	Patient findPatient(String username, String pwd);
}
