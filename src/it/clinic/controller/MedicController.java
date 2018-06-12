package it.clinic.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.clinic.facade.AdministratorFacade;
import it.clinic.model.ExamTypology;
import it.clinic.model.Medic;

@ManagedBean
public class MedicController {

	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String name;
	private String code;
	private String surname;
	private String pwd;
	private Medic medic;
	private List<Medic> medics;
	@ManagedProperty(value="#{param.idspecialization}")
	private Long idspecialization;
	private ExamTypology specialization;

	@EJB
	private AdministratorFacade administratorFacade;

	@PostConstruct
	public void elencoMedici(){
		this.medics = this.administratorFacade.getAllMedics();
	}


	public String createMedico(){
		String nextPage = "successNewMedico.jsp";
		try{
			this.setSpecialization(administratorFacade.getExamTypology(idspecialization));
			this.medic = administratorFacade.createMedic(code ,name, surname, specialization); 
		} catch (EJBTransactionRolledbackException e){ 
			nextPage = "errorNewMedico.jsp";
			this.medic = new Medic(code, name, surname, specialization); 
		}
		return nextPage;
	}

    public String findMedic(){
		this.medic = administratorFacade.getMedic(id);
		return "elencoEsamiMedico.jsp";
    }
    
	public String findMedic(Long id) {
		this.medic= administratorFacade.getMedic(id);
		return "elencoEsamiMedico.jsp";
	}
	//metodi setters e getters

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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public ExamTypology getSpecialization() {
		return specialization;
	}


	public void setSpecialization(ExamTypology specialization) {
		this.specialization = specialization;
	}


	public Medic getMedic() {
		return medic;
	}

	public void setMedic(Medic medic) {
		this.medic = medic;
	}

	public List<Medic> getMedics() {
		return medics;
	}

	public void setMedics(List<Medic> medics) {
		this.medics = medics;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	public Long getIdspecialization() {
		return idspecialization;
	}


	public void setIdspecialization(Long idspecialization) {
		this.idspecialization = idspecialization;
	}

}
