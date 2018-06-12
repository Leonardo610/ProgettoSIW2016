package it.clinic.controller;



import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.clinic.facade.AdministratorFacade;
import it.clinic.model.Exam;
import it.clinic.model.ExamTypology;
import it.clinic.model.Indicator;
import it.clinic.model.Medic;
import it.clinic.model.Patient;



@ManagedBean
public class ExamController {

	@ManagedProperty(value="#{param.id}")
	private Long id;
	private Date prenotationDate;
	private Date visitDate;
	private String code;
	private String description;
	private int price;


	@ManagedProperty(value="#{param.idpatient}")
	private Long idpatient;
	private Patient patient;
	private List<Exam> patientExams;
	@ManagedProperty(value="#{param.idtypology}")
	private Long idtypology;
	private ExamTypology typology;
	@ManagedProperty(value="#{param.idmedic}")
	private Long idmedic;
	private Medic medic;
	private Exam exam;
	private List<Exam> exams;
	private List<Exam> medicExams;
	private Map<Indicator,String> results;
	private String examErr;
	private String result;
	private Long idIndicator;

	@EJB
	private AdministratorFacade administratorFacade;


	public String createExam(){
		String nextPage = "./successNewPrenotazioneEsame.jsp";
		try {
			this.prenotationDate = new Date();
			this.setMedic(administratorFacade.getMedic(idmedic));
			this.setTypology(administratorFacade.getExamTypology(idtypology));
			this.setPatient(administratorFacade.getPatient(idpatient));
			this.exam = administratorFacade.createExam(prenotationDate, visitDate, medic, patient, typology,code, description,price);
		} catch (EJBTransactionRolledbackException e) { //esame già presente nel database
			this.examErr = "Esiste già un esame con questo codice!";
			return "./newPrenotazioneEsame.jsp";
		}
		return nextPage;
	}

	public String findExamByPatient(){
		this.patientExams = administratorFacade.getPatientExams(idpatient);
		return "/consultaRisultatiEsami.jsp";
	}
	
	public String findExamByPatientAdmin(){
		this.patientExams = administratorFacade.getPatientExams(idpatient);
		return "/elencoEsamiPaziente.jsp";
	}
	
	public String findExamByMedic(){
		this.medicExams = administratorFacade.getMedicExams(idmedic);
		return "/elencoEsamiMedico.jsp";
	}
	
	public String findExamResults(){
		this.results = administratorFacade.getExamResults(id);
		return "/dettaglioRisultatiEsame.jsp";}
	
	public String findExamResultsAdmin(){
		this.results = administratorFacade.getExamResults(id);
		return "/aggiungiRisultatiEsame.jsp";}

	public String addResultExam() {
		Indicator indicator = administratorFacade.getIndicator(this.idIndicator);
		this.exam.addResults(indicator, this.result);
		return "./aggiungiRisultatiEsame.jsp";
	}
	
	
	public String getExamErr() {
		return examErr;
	}


	public void setExamErr(String examErr) {
		this.examErr = examErr;
	}


	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	public Date getVisitDate() {
		return visitDate;
	}
	public void setPrenotationDate(Date prenotationDate) {
		this.prenotationDate = prenotationDate;
	}

	public Date getPrenotationDate() {
		return prenotationDate;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setIdmedic(Long idmedic) {
		this.idmedic = idmedic;
	}

	public Long getIdmedic() {
		return idmedic;
	}


	public void setMedic(Medic medic) {
		this.medic= medic;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Medic getMedic() {
		return medic;
	}
	public void setTypology(ExamTypology typology) {
		this.typology = typology;
	}

	public Patient getPatient() {
		return patient;
	}
	public ExamTypology getTypology() {
		return typology;
	}

	public Long getIdpatient() {
		return idpatient;
	}
	public Long getIdtypology() {
		return idtypology;
	}

	public void setIdpatient(Long idpatient) {
		this.idpatient = idpatient;
	}

	public void setIdtypology(Long idtypology) {
		this.idtypology = idtypology;
	}

	public List<Exam> getMedicExams() {
		return medicExams;
	}

	public void setMedicExams(List<Exam> medicExams) {
		this.medicExams = medicExams;
	}
	
	public List<Exam> getPatientExams() {
		return patientExams;
	}

	public void setPatientExams(List<Exam> patientExams) {
		this.patientExams = patientExams;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String codice) {
		this.code = codice;
	}

	
	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	public Map<Indicator,String> getResults() {
		return results;
	}
	
	public void  setResults(Map<Indicator,String> results) {
		this.results = results;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Long getIdIndicator() {
		return this.idIndicator;
	}

	public void setIdIndicator(Long idIndicator) {
		this.idIndicator = idIndicator;
	}
	
	
	
	
}