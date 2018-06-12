package it.clinic.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.persistence.*;

@Entity
@NamedQuery(name="allExams", query="SELECT e FROM Exam e")
public class Exam {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true, nullable = false)
	private String code;
	@Column( nullable = false)
	private int price;
	@Column(length = 2000)
	private String description;
	@ManyToOne
	@JoinColumn(name="examtypology_id")
	private ExamTypology typology;
	@Column(nullable = false)
	@Temporal (TemporalType.TIMESTAMP)
	private Date prenotationDate;
	@ManyToOne
	private Patient patient;
	@ManyToOne
	private Medic medic;
	@Column(nullable = false)
	@Temporal (TemporalType.DATE)
	private Date visitDate;
	@ElementCollection(fetch = FetchType.EAGER)
	@MapKeyJoinColumn(name="indicator_id")
	@Column(name="value")
	private Map<Indicator,String> results;


public Exam(){
	this.results = new HashMap<>();
}

	public Exam(Date prenotationDate, Date visitDate, Medic medic, Patient patient, ExamTypology typology, String codice, String description,int price) {
		super();
		this.results = new HashMap<>();
		this.prenotationDate = prenotationDate;
		this.visitDate = visitDate;
		this.medic = medic;
		this.patient = patient;
		this.typology = typology;
		this.code = codice;
		this.description = description;
		this.price=price;
	}


	public String getCode() {
		return this.code;
	}

	public void setCode(String cod) {
		this.code = cod;
	}

	public String getDescription() {
		return this.description;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ExamTypology getTypology() {
		return this.typology;
	}

	public void setTypology(ExamTypology typology) {
		this.typology = typology;
	}



	public Date getPrenotationDate() {
		return this.prenotationDate;
	}

	public void setPrenotationDate(Date prenotationDate) {
		this.prenotationDate = prenotationDate;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Medic getMedic() {
		return this.medic;
	}

	public void setMedic(Medic medic) {
		this.medic = medic;
	}

	public Date getVisitDate() {
		return this.visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	

	public int getPrice() {
		return this.price;
	}

	public void setMedic(int price) {
		this.price = price;
	}

	public void addIndicatorsFromTypology(){
		Set<Indicator> indicators = this.typology.getExamIndicators();
		for(Indicator indicator : indicators)
			this.results.put(indicator, null);
	}

	public void addResults(Indicator indicator, String result){
		if(this.typology.getExamIndicators().contains(indicator)){
			this.results.put(indicator, result);

		}

	}
	public Map<Indicator,String> getResults() {
		return results;
	}


	public void setResults(Map<Indicator, String> results) {
		this.results = results;
	}


	@Override
	public boolean equals(Object o) {
		Exam exam = (Exam) o;
		return this.getCode().equals(exam.getCode());
	}

	@Override
	public int hashCode() {
		return this.getCode().hashCode();
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Exam"); 
		sb.append("{id='").append(id); 
		sb.append(", prenotationDate='").append(prenotationDate);
		sb.append(", visitDate='").append(visitDate);
		sb.append("}\n");
		return sb.toString();
	}

}
