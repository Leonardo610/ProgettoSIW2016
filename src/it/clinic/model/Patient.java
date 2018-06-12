package it.clinic.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;



@Entity
@NamedQuery(name="allPatients", query="SELECT p FROM Patient p")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true, nullable = false)
	private String username;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String surname;
	@Column(nullable = false, length = 16)
	private String pwd;
	@OneToMany(mappedBy = "patient")
	@OrderBy("visitDate ASC")
	private List<Exam> exams;

	
	public Patient(){}
	public Patient(String username, String name, String surname, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.surname = surname;
		this.username = username;
		this.exams = new ArrayList<>();
	}

	public void addExam(Exam e) {
		this.exams.add(e);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}



	public List<Exam> getExams() {
		return this.exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public boolean checkPassword(String pwd){
		if(this.getPwd().equals(pwd))
			return true;
		else return false;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode(){
		return this.getUsername().hashCode();

	}

	@Override
	public boolean equals(Object o){
		Patient patient = (Patient) o;
		return this.getUsername().equals(patient.getUsername());
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Patient"); 
		sb.append("{id='").append(id); 
		sb.append(", name='").append(name);
		sb.append(", surname='").append(surname);
		sb.append(", username='").append(username);
		sb.append("}\n");
		return sb.toString();
	}

}
