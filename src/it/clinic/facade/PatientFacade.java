package it.clinic.facade;




import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.clinic.model.Patient;
import it.clinic.persistence.PatientDaoJPA;




@Stateless(name = "pFacade")
public class PatientFacade {
	
	@PersistenceContext(unitName = "clinic-unit")
	private EntityManager em;
	
	// chiedo alla classe PazienteDao di occuparsi dell'invocazione dei metodi dell'em e di eventuali istruzioni SQL, creando un livello d'indirezione
	public Patient createPatient(String username, String name, String surname, String pwd){
		PatientDaoJPA patientDao = new PatientDaoJPA(em);
		Patient patient = new Patient(username, name, surname, pwd);
		patientDao.save(patient);
		return patient;
	}
	
	public Patient validate(String username, String password){
		PatientDaoJPA patientDao = new PatientDaoJPA(em);
		Patient patient = patientDao.findPatient(username,password);
		return patient;
	}
	
	public void deletePatient(Patient patient){
		PatientDaoJPA patientDao = new PatientDaoJPA(em);
		patientDao.delete(patient);
	}
	
	public void deletePatient(Long id){
		PatientDaoJPA patientDao = new PatientDaoJPA(em);
		patientDao.delete(id);
	}
	
	public void updatePatient(Patient patient){
		PatientDaoJPA patientDao = new PatientDaoJPA(em);
		patientDao.update(patient);
	}
	
	public Patient getPatient(Long id){
		PatientDaoJPA patientDao = new PatientDaoJPA(em);
		return patientDao.findByPrimaryKey(id);
	}
	
	public Patient getPatient(String username){
		PatientDaoJPA patientDao = new PatientDaoJPA(em);
		return patientDao.findByUsername(username);
	}
	
	public List<Patient> getAllPatients(){
		PatientDaoJPA patientDao = new PatientDaoJPA(em);
		List<Patient> patients = patientDao.findAll();
		return patients;
	}
	
}
