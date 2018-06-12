package it.clinic.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@NamedQuery(name="allMedics", query="SELECT m FROM Medic m")
public class Medic {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true, nullable = false)
	private String code;
	@Column(nullable = false)
	private String name;
	private String surname;
	@ManyToOne
	private ExamTypology specialization;
	@OneToMany(mappedBy = "medic")
	@OrderBy("visitDate ASC")
	private List<Exam> exams;

	public Medic(){}
	public Medic(String code, String name, String surname, ExamTypology specialization) {
		super();
		this.code = code;
		this.name = name;
		this.surname = surname;
		this.specialization = specialization;
		this.exams = new ArrayList<>();
	}

	public void addExam(Exam exam){
		exams.add(exam);
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public ExamTypology getSpecialization() {
		return this.specialization;
	}

	public void setSpecialization(ExamTypology specialization) {
		this.specialization = specialization;
	}

	public List<Exam> getExams() {
		return this.exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	} 


	@Override
	public int hashCode(){
		return this.getCode().hashCode();
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o){
		Medic medic = (Medic) o;
		return  this.getCode().equals(medic.getCode());
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Medic"); 
		sb.append("{id='").append(id); 
		sb.append(", name='").append(name);
		sb.append(", surname='").append(surname);
		sb.append(", specialization='").append(specialization);
		sb.append("}\n");
		return sb.toString();
	}

}
