package it.clinic.controller;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.EJBTransactionRolledbackException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.clinic.facade.PatientFacade;
import it.clinic.model.Patient;



@ManagedBean
public class PatientController {
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String name;
	private String username;
	private String surname;
	private String pwd;
	private Patient patient;
	private List<Patient> patients;
	private String loginErr;
	
	@EJB
	private PatientFacade patientFacade;
	
	@PostConstruct
	public void PatientList(){
		this.patients = this.patientFacade.getAllPatients();
	}
	
	public String createPatient(){
		String nextPage = "successNewPaziente";
		try{
			this.patient = patientFacade.createPatient(username, name, surname, pwd);
		} catch (EJBTransactionRolledbackException e){ // DBMS ha già un paziente con lo stesso username
			nextPage = "errorNewPaziente";
			this.patient = new Patient(username, name, surname, pwd); 
		}
		return nextPage;
	}
	
	public String verifyLogin() {
		if (this.patient!=null)
			return "./patient.jsp";
		else
			return "./loginPatient.jsp";
	}
	
	public String validate(){
		try {
			this.patient = patientFacade.validate(username, pwd);
		}catch (EJBException e) {
			this.loginErr = "Username o password errati";
			return "/faces/loginPatient.jsp";
		} 
		return "/faces/patient.jsp";
	}
	
	public String listPatients(){
		this.patients = patientFacade.getAllPatients();
		return "patient";
	}
	
	public String findPatient(){
		this.patient = patientFacade.getPatient(id);
		return "patient";
	}
	
	//metodi getter e setter 
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getLoginErr() {
		return loginErr;
	}

	public void setLoginErr(String loginErr) {
		this.loginErr = loginErr;
	}

	public String getPwd() {
		return pwd;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public List<Patient> getPatients() {
		return patients;
	}
	
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	
}
