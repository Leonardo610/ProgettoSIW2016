package it.clinic.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="allIndicators",query="SELECT i FROM Indicator i")
public class Indicator {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(unique=true,nullable=false) //false??
	private String name;
	//@ManyToOne //prova 09-06-2016
	//@JoinColumn(name="tipologiaesame_id") //prova 09-06-2016
	//private TipologiaEsame tipologiaEsame; //prova 09-06-2016

	public Indicator() {}

	public Indicator(String name){
		this.name = name;
	}

	//metodi getters e setters
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//metodi equals e hashcode

	@Override
	public boolean equals(Object obj) {
		Indicator ind = (Indicator) obj;
		return ind.getName().equals(this.getName());
	}

	@Override
	public int hashCode() {
		return this.getName().hashCode();
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Indicator"); 
		sb.append("{id='").append(id); 
		sb.append(", nome='").append(name);
		sb.append("}\n");
		return sb.toString();
	}
}