package it.clinic.model;
import javax.persistence.*;

@Entity
@NamedQuery(name="allPrerequisites", query="SELECT p FROM Prerequisite p")
public class Prerequisite {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true, nullable = false)
	private String name;
	@Column(nullable = false)
	private String value;

	
	public Prerequisite(){}
	public Prerequisite(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		Prerequisite preq = (Prerequisite) o;
		return preq.getName().equals(this.getName());
	}

	@Override
	public int hashCode() {
		return this.getName().hashCode();
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Prerequisite"); 
		//sb.append("{id='").append(id); 
		sb.append(", name='").append(name);
		sb.append(", value='").append(value);
		sb.append("}\n");
		return sb.toString();
	}
}
