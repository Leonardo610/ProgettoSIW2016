package it.clinic.model;


import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQuery(name="allExamsTypologies", query="SELECT e FROM ExamTypology e")
public class ExamTypology {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true, nullable = false)
	private String name;
	@Column(length = 2000)
	private String detail;
	@Column(nullable = false)
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Prerequisite> prerequisites;
	@Column(nullable = false)
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Indicator> examIndicators;
	@OneToMany(mappedBy = "typology")
	private Map<String, Exam> exams;

public ExamTypology(){}

	public ExamTypology(String name, String detail,Set<Indicator> indicators){
		this.name=name;
		this.detail=detail;
		this.prerequisites = new HashSet<>();
		this.examIndicators = indicators;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Set<Prerequisite> getPrerequisites() {
		return this.prerequisites;
	}

	public void setPrerequisites(Set<Prerequisite> prerequisites) {
		this.prerequisites = prerequisites;
	}

	public Set<Indicator> getExamIndicators() {
		return this.examIndicators;
	}

	public void setExamIndicators(Set<Indicator> examIndicators) {
		this.examIndicators = examIndicators;
	}

	public void addPrerequisite(Prerequisite p){
		this.prerequisites.add( p);
	}


	public void addExamIndicator(Indicator examIndicator){
		this.examIndicators.add(examIndicator);

	}




	@Override
	public boolean equals(Object o) {
		ExamTypology examTypology = (ExamTypology)o;
		return examTypology.getName().equals(this.getName());
	}

	@Override
	public int hashCode() {
		return this.getName().hashCode();
	}


	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("ExamTypology"); 
		sb.append("{id='").append(id); 
		sb.append(", name='").append(name);
		//sb.append(", prerequisites='").append(this.stampAllPrerequisites());
		//sb.append(", examIndicators='").append(this.stampaAllexamIndicators());
		sb.append(", details='").append(detail);
		sb.append("}\n");
		return sb.toString();
	}


}
