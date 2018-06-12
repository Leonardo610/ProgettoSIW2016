package it.clinic.model;
import javax.persistence.*;

@Entity
@NamedQuery(name="allAdministrators", query="SELECT a FROM Administrator a")
public class Administrator {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true, nullable = false)
	private String username;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String surname;
	@Column(nullable = false)
	private String pwd;

	public Administrator(){}
	
	public Administrator(String username, String name, String surname, String pwd) {
		this.username=username;
		this.name = name;
		this.surname=surname;
		this.pwd = pwd;
	}


	public String getUsername() {
		return this.username;
	}


	public void setUsername(String username) {
		this.username = username ;

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

	public String getSurname() {
		return surname;
	}


	public void setSurname(String surName) {
		this.surname = surName;
	}
	@Override
	public boolean equals(Object o) {
		Administrator adm = (Administrator) o;
		return adm.getUsername().equals(this.getUsername());
	}

	@Override
	public int hashCode() {
		return this.getUsername().hashCode();
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Adinistrator"); 
		sb.append("{id='").append(id); 
		sb.append(", name='").append(name);
		sb.append(", surname='").append(surname);
		sb.append(", username='").append(username);
		sb.append("}\n");
		return sb.toString();
	}


}