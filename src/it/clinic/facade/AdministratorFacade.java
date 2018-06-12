package it.clinic.facade;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import it.clinic.model.Administrator;
import it.clinic.model.Exam;
import it.clinic.model.ExamTypology;
import it.clinic.model.Indicator;
import it.clinic.model.Medic;
import it.clinic.model.Patient;
import it.clinic.persistence.AdministratorDaoJPA;
import it.clinic.persistence.ExamDaoJPA;
import it.clinic.persistence.ExamTypologyDaoJPA;
import it.clinic.persistence.IndicatorDaoJPA;
import it.clinic.persistence.MedicDaoJPA;
import it.clinic.persistence.PatientDaoJPA;



@Stateless(name = "aFacade")
public class AdministratorFacade {
	
	@PersistenceContext(unitName = "clinic-unit")
	private EntityManager em;
	
	//metodi inerenti alla gestione delle Tipologie
	
	public ExamTypology createExamTypology(String name, String detail,Set<Indicator> indicators){
		ExamTypologyDaoJPA examTypologyDao = new ExamTypologyDaoJPA(em);
		ExamTypology examTypology = new ExamTypology(name,detail,indicators);
		examTypologyDao.save(examTypology);
		return examTypology;
	}
	
	
	public ExamTypology getExamTypology(Long id){
		ExamTypologyDaoJPA examTypologyDao = new ExamTypologyDaoJPA(em);
		ExamTypology examTypology = examTypologyDao.findByPrimaryKey(id);
		return examTypology;
	}
	
	public ExamTypology getExamTypology(String name){
		ExamTypologyDaoJPA examTypologyDao = new ExamTypologyDaoJPA(em);
		ExamTypology examTypology = examTypologyDao.findByName(name);
		return examTypology;
	}
	
	public List<ExamTypology> getAllExamTypologies() {
		ExamTypologyDaoJPA examTypologyDao = new ExamTypologyDaoJPA(em);
		List<ExamTypology> examTypologies= examTypologyDao.findAll();
		return examTypologies;
	}
	
	
	//metodi inerenti alla gestione dell'amministratore

	public Administrator createAdministrator(String username, String name, String surname, String pwd){
		AdministratorDaoJPA administratorDao = new AdministratorDaoJPA(em);
		Administrator administrator =new Administrator(username, name, surname, pwd);
		administratorDao.save(administrator);
		return administrator;
	}
	
	public Administrator getAdministrator(String username){
		AdministratorDaoJPA administratorDao = new AdministratorDaoJPA(em);
		Administrator administrator = administratorDao.findByUsername(username);
		return administrator;
	}
	
	public Administrator validate(String username, String password){
		AdministratorDaoJPA amministratoreDao = new AdministratorDaoJPA(em);
		Administrator amministratore = amministratoreDao.findAdmin(username,password);
		return amministratore;
	}
	
	//metodi inerenti alla gestione del medico
	
	public Medic createMedic(String code, String name, String surname, ExamTypology specialization){
		MedicDaoJPA medicDao = new MedicDaoJPA(em);
		Medic medic = new Medic(code, name, surname, specialization);
		medicDao.save(medic);
		return medic;
	}
	
	public Medic getMedic(Long id){
		MedicDaoJPA medicDao = new MedicDaoJPA(em);
		Medic medic= medicDao.findByPrimaryKey(id);
		return medic;
	}
	
	public List<Medic> getAllMedics(){
		MedicDaoJPA medicDao = new MedicDaoJPA(em);
		List<Medic> medics = medicDao.findAll();
		return medics;
	}
	
	public List<Exam> getMedicExams(Long idmedic){
		ExamDaoJPA examDao = new ExamDaoJPA(em);
		List<Exam> medicExams = examDao.findAllByMedicId(idmedic);
		return medicExams;
	}
	//metodi inerenti alla gestione degli indicatori
		public Indicator createIndicator(String name){
			IndicatorDaoJPA indicatorDao = new IndicatorDaoJPA(em);
			Indicator indicator = new Indicator(name);
			indicatorDao.save(indicator);
			return indicator;
		}
		
		public Indicator getIndicator(String name){
			IndicatorDaoJPA indicatorDao = new IndicatorDaoJPA(em);
			Indicator indicator = indicatorDao.findByName(name);
			return indicator;
		}
		
		public Indicator getIndicator(Long id){
			IndicatorDaoJPA indicatorDao = new IndicatorDaoJPA(em);
			Indicator indicator = indicatorDao.findByPrimaryKey(id);
			return indicator;
		}
		
		public List<Indicator> getAllIndicators(){
			IndicatorDaoJPA indicatorDao = new IndicatorDaoJPA(em);
			List<Indicator> indicators = indicatorDao.findAll();
			return indicators;
		}
		
	//metodi per l'esame
	public Exam createExam(Date prenotationDate, Date visitDate, Medic medic, Patient patient, ExamTypology typology, String codice, String description,int price){
		ExamDaoJPA examDao = new ExamDaoJPA(em);
		Exam exam = new Exam(prenotationDate, visitDate, medic, patient, typology, codice, description,price);
		examDao.save(exam);
		return exam;
	}
	
	public Map<Indicator,String> getExamResults(Long idexam){
		ExamDaoJPA examDao = new ExamDaoJPA(em);
		Map<Indicator,String> examResults = examDao.findExamResults(idexam);
		return examResults;
	}
	
	public Patient getPatient(Long id){
		PatientDaoJPA patientDao = new PatientDaoJPA(em);
		Patient patient = patientDao.findByPrimaryKey(id);
		return patient;
	}
	
	public List<Exam> getPatientExams(Long idpatient){
		ExamDaoJPA examDao = new ExamDaoJPA(em);
		List<Exam> patientExams = examDao.findAllByPatient(idpatient);
		return patientExams;
	}
	
//	public String addResultExam(Long idIndicator, String value) {
//		ExamDaoJPA examDao = new ExamDaoJPA(em);
//		IndicatorDaoJPA indicatorDao = new IndicatorDaoJPA(em);
//		Indicator indicator = indicatorDao.findByPrimaryKey(idIndicator);
//	}
	

}