package it.clinic.persistence;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.clinic.model.Patient;


public class PatientDaoJPA implements PatientDao{
	private EntityManager em;
	
   	public PatientDaoJPA(EntityManager em){
   		this.em=em;
   	}




	@Override
	public void save(Patient patient) {
		em.persist(patient);
	}

	@Override
	public void delete(Patient patient) {
		em.remove(patient);
	}
	
	@Override
	public void delete(Long id){
		Patient patient = em.find(Patient.class, id);
		this.delete(patient);
	}

	@Override
	public void update(Patient patient) {
		em.merge(patient);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> findAll() {
		List<Patient> patients = em.createNamedQuery("allPatients").getResultList();
		return patients;
	}

	@Override
	public Patient findByPrimaryKey(Long id) {
		return em.find(Patient.class, id);
	}

	@Override
	public Patient findByUsername(String username){
		Query query = em.createQuery("SELECT p FROM Patient p WHERE p.username=?");
		return (Patient)query.setParameter(1,username).getSingleResult();
	}
	
	@Override
	public Patient findPatient(String username, String pwd) {
		Query query = em.createQuery("SELECT p FROM Patient p WHERE p.username='" + username + "' AND p.pwd='" + pwd + "'");
		Patient patient = (Patient) query.getSingleResult();
		return patient;
	}



}
